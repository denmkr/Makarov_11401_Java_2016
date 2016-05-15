package ru.kpfu.dm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.FlashMap;
import ru.kpfu.dm.entity.Product;
import ru.kpfu.dm.entity.ProductGroup;
import ru.kpfu.dm.entity.UserRole;
import ru.kpfu.dm.repository.ProductRepository;
import ru.kpfu.dm.service.GroupService;
import ru.kpfu.dm.service.ProductService;

import javax.annotation.Resource;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final int PAGE_SIZE = 15;

    @Resource
    public ProductRepository productRepository;
    @Autowired
    public GroupService groupService;

    @Override
    @Transactional
    public Product create(Product product) {
        Product createdProduct = product;
        return productRepository.saveAndFlush(createdProduct);
    }

    @Override
    @Transactional
    public Product findById(long id) {
        return productRepository.findOne(id);
    }

    @Override
    @Transactional
    public Product findByArticule(String articule) {
        return productRepository.findByArticule(articule);
    }

    @Override
    @Transactional
    public boolean addProducts(List<Product> products) {
        for (Product product : products) {
            product.setProductGroup(groupService.findByGroupId(product.getProductGroup().getGroupId()));
            productRepository.saveAndFlush(product);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean updateProducts(List<Product> products) {
        for (Product product : products) {
            product.setProductGroup(groupService.findByGroupId(product.getProductGroup().getGroupId()));

            if (productRepository.findByArticule(product.getArticule()) == null) {
                productRepository.saveAndFlush(product);
            }
            else productRepository.updateProductByArticule(product.getArticule(), product.getName(), product.getStock(), product.getPrice(), product.getCurrency(), product.getProductGroup());
        }

        return true;
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        Product deletedProduct = productRepository.findOne(id);
        productRepository.delete(deletedProduct);
        return true;
    }

    @Override
    @Transactional
    public Page<Product> findAll(String groupId, int page, String stock, String searchProduct, String sort) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        int stockValue;
        if (stock.equals("off")) stockValue = -1;
        else stockValue = 0;

        String[] parts = sort.split("_");
        sort = parts[0];
        String direction = parts[1];

        Sort.Direction sortDirection;
        if (direction.equals("ASC")) sortDirection = Sort.Direction.ASC;
        else sortDirection = Sort.Direction.DESC;

        PageRequest pageRequest = new PageRequest(page - 1, PAGE_SIZE, sortDirection, sort);

        Collection<ProductGroup> groups = new ArrayList<ProductGroup>();

        groups.add(groupService.findByGroupId(groupId));
        for (ProductGroup group : groupService.findByGroupId(groupId).getChildGroups()) {
            groups.add(group);
            for (ProductGroup group1 : group.getChildGroups()) {
                groups.add(group1);
                for (ProductGroup group2 : group1.getChildGroups()) {
                    groups.add(group2);
                }
            }
        }

        Page<Product> productPage = productRepository.findByProductGroupInAndStockGreaterThanAndNameContains(groups, stockValue, searchProduct, pageRequest);

        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_PARTNER"))) {
            for (Product product : productPage.getContent()) {
                double newPrice = product.getPrice() - product.getPrice() * 0.18;
                double twodecPartnerPrice = Math.round(newPrice * 100.0) / 100.0;

                product.setPrice(new Float(twodecPartnerPrice));
            }
        }

        return productPage;
    }

    @Override
    @Transactional
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public Product update(Product product) {
        Product updatedProduct = productRepository.findOne(product.getId());

        updatedProduct.setName(product.getName());
        return updatedProduct;
    }

}
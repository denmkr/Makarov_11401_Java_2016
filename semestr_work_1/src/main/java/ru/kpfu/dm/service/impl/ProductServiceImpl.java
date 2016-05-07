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
import ru.kpfu.dm.entity.Product;
import ru.kpfu.dm.entity.UserRole;
import ru.kpfu.dm.repository.ProductRepository;
import ru.kpfu.dm.service.GroupService;
import ru.kpfu.dm.service.ProductService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final int PAGE_SIZE = 15;

    @Resource
    ProductRepository productRepository;
    @Autowired
    GroupService groupService;

    @Override
    @Transactional
    public Product create(Product product) {
        Product createdProduct = product;
        return productRepository.save(createdProduct);
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
    public void addProducts(List<Product> products) {
        for (Product product : products) {
            product.setProductGroup(groupService.findByGroupId(product.getProductGroup().getGroupId()));
            productRepository.saveAndFlush(product);
        }
    }

    @Override
    @Transactional
    public boolean updateProducts(List<Product> products) {
        for (Product product : products) {
            product.setProductGroup(groupService.findByGroupId(product.getProductGroup().getGroupId()));
            System.out.println(product.getArticule());

            if (productRepository.findByArticule(product.getArticule()) == null) {
                productRepository.saveAndFlush(product);
            }
            else productRepository.updateProductByArticule(product.getArticule(), product.getName(), product.getStock(), product.getPrice(), product.getCurrency(), product.getProductGroup());
        }

        return true;
    }

    @Override
    @Transactional
    public Product delete(long id) {
        Product deletedProduct = productRepository.findOne(id);
        productRepository.delete(deletedProduct);
        return deletedProduct;
    }

    @Override
    @Transactional
    public Page<Product> findAll(int page, String stock, String searchProduct, String sort) {
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


        Page<Product> productPage = productRepository.findByStockGreaterThanAndNameContainingIgnoreCase(stockValue, searchProduct, pageRequest);

        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_PARTNER"))) {
            for (Product product : productPage.getContent()) {
                product.setPrice(product.getPrice() - product.getPrice() * new Float(0.13));
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
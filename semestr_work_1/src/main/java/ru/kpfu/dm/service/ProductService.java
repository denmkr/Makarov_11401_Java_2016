package ru.kpfu.dm.service;

import org.springframework.data.domain.Page;
import ru.kpfu.dm.entity.Product;

import java.util.List;

/**
 * Created by Denis on 17.04.16.
 */
public interface ProductService {
    Product create(Product product);
    Product delete(long id);
    Product update(Product product);
    Product findById(long id);
    Product findByArticule(String articule);
    void addProducts(List<Product> products);
    boolean updateProducts(List<Product> products);

    Page<Product> findAll(int page, String stock, String searchProduct, String sort);
    List<Product> findAll();
}

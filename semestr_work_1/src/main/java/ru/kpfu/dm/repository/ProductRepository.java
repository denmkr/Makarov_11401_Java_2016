package ru.kpfu.dm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.dm.entity.Product;
import ru.kpfu.dm.entity.ProductGroup;

import java.util.Collection;
import java.util.List;

/**
 * Created by Denis on 14.04.2016.
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAll(Pageable pageable);
    List<Product> findAll();

    Product findByArticule(String articule);

    @Modifying
    @Transactional
    @Query("UPDATE Product product SET product.name = ?2, product.stock = ?3, product.price = ?4, product.currency = ?5, product.productGroup = ?6 where product.articule = ?1")
    void updateProductByArticule(String articule, String name, int stock, float price, String currency, ProductGroup productGroup);

    Page<Product> findByProductGroupInAndStockGreaterThanAndNameContainingIgnoreCase(Collection<ProductGroup> groups, int num, String name, Pageable pageable);
    Page<Product> findByStockGreaterThanAndNameContainingIgnoreCase(int num, String name, Pageable pageable);

}

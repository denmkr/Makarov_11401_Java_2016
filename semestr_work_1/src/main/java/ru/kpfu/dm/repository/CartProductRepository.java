package ru.kpfu.dm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.dm.entity.CartProduct;
import ru.kpfu.dm.entity.Product;

import java.util.List;

/**
 * Created by Denis on 26.04.16.
 */

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
    List<CartProduct> findByUserId(long id);
    CartProduct findByUserIdAndProductId(long userId, long productId);

    @Modifying
    @Transactional
    @Query("UPDATE CartProduct cartProduct SET cartProduct.count = ?1 where cartProduct.userId = ?2 and cartProduct.product = ?3")
    void updateProductInCart(int count, long userId, Product product);

    @Modifying
    @Transactional
    @Query("DELETE from CartProduct cartProduct WHERE cartProduct.userId = ?1")
    void deleteProductInCart(long userId);
}


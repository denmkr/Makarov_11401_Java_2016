import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import ru.kpfu.dm.entity.*;
import ru.kpfu.dm.repository.CartProductRepository;
import ru.kpfu.dm.repository.OrderRepository;
import ru.kpfu.dm.repository.UserRepository;
import ru.kpfu.dm.repository.UserRoleRepository;
import ru.kpfu.dm.service.UserRoleService;
import ru.kpfu.dm.service.UserService;
import ru.kpfu.dm.service.impl.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Denis on 14.05.16.
 */
public class TestCartProductService {

    private static CartProductServiceImpl cartProductService;
    private static CartProduct cartProduct1, cartProduct2;
    private static Cart cart;
    private static List<CartProduct> cartProducts;

    @BeforeClass
    public static void init() {
        cart = new Cart();
        cartProductService = new CartProductServiceImpl();
        cartProductService.cartProductRepository = mock(CartProductRepository.class);
        cartProductService.productService = mock(ProductServiceImpl.class);
        cartProductService.userService = mock(UserServiceImpl.class);

        cartProduct1 = new CartProduct();
        Product product1 = mock(Product.class);
        product1.setId(new Long(1));
        cartProduct1.setProduct(product1);

        cartProduct2 = new CartProduct();
        Product product2 = mock(Product.class);
        product2.setId(new Long(2));
        cartProduct2.setProduct(product2);

        cartProducts = new ArrayList<CartProduct>();
        cartProducts.add(cartProduct1);
        cartProducts.add(cartProduct2);

        Product product = new Product();
        product.setName("Test");

        when(cartProductService.cartProductRepository.saveAndFlush(any(CartProduct.class))).thenReturn(cartProduct1);
        when(cartProductService.cartProductRepository.findByUserIdAndProductId(anyLong(), anyLong())).thenReturn(cartProduct1);
        when(cartProductService.cartProductRepository.findAll()).thenReturn(cartProducts);
        when(cartProductService.cartProductRepository.findByUserId(anyLong())).thenReturn(cartProducts);
    }


    @Test
    @Ignore
    public void getCartMethodShouldReturnCorrectProducts() {
        Assert.assertEquals(cartProductService.getCart(), cart);
    }

    @Test
    @Ignore
    public void addProductMethodShouldReturnCorrectProduct() {
        Product product1 = new Product();
        product1.setName("Test");
        Assert.assertEquals(cartProductService.addProduct(product1), product1);
    }

    @Test
    @Ignore
    public void removeCartMethodShouldWorkCorrect() {
        Cart cart1 = new Cart();
        Assert.assertEquals(cartProductService.removeCart(cart1), true);
    }

    @Test
    @Ignore
    public void removeProductMethodShouldWorkCorrect() {
        Product product1 = new Product();
        product1.setName("Test");
        Assert.assertEquals(cartProductService.removeProduct(product1), true);
    }

}


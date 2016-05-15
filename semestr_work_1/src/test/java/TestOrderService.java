import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import ru.kpfu.dm.entity.*;
import ru.kpfu.dm.repository.OrderRepository;
import ru.kpfu.dm.repository.UserRepository;
import ru.kpfu.dm.repository.UserRoleRepository;
import ru.kpfu.dm.service.UserRoleService;
import ru.kpfu.dm.service.UserService;
import ru.kpfu.dm.service.impl.OrderServiceImpl;
import ru.kpfu.dm.service.impl.UserRoleServiceImpl;
import ru.kpfu.dm.service.impl.UserServiceImpl;

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
public class TestOrderService {

    private static OrderServiceImpl orderService;
    private static Order order1, order2;
    private static List<Order> orders;

    @BeforeClass
    public static void init() {
        orderService = new OrderServiceImpl();
        orderService.orderRepository = mock(OrderRepository.class);
        orderService.authentication = mock(Authentication.class);

        orders = new ArrayList<Order>();

        User user = new User();
        user.setUsername("Denis");
        user.setId(new Long(1));
        user.setEmail("test");
        user.setPassword("1111");

        Product product = new Product();
        product.setName("Test");

        Product product2 = new Product();
        product2.setName("Test2");

        Cart cart1 = new Cart();
        cart1.addProduct(product);
        cart1.addProduct(product2);

        order1 = new Order();
        order2 = new Order();

        order1.setProduct(product);
        order2.setProduct(product2);
        orders.add(order1);
        orders.add(order2);

        when(orderService.orderRepository.saveAndFlush(any(Order.class))).thenReturn(order1);
        when(orderService.authentication.getName()).thenReturn("Denis");
        when(orderService.orderRepository.findAll()).thenReturn(orders);
    }

    @Test
    @Ignore
    public void createUserMethodShouldSetCorrectUserRole() {
        Cart cart = new Cart();
        Product product = new Product();
        product.setName("Test");
        cart.addProduct(product);

        Assert.assertEquals(orderService.createOrder(cart), true);
    }

    @Test
    public void getOrdersMethodShouldReturnCorrectOrders() {
        Assert.assertEquals(orderService.getOrders(), orders);
    }



}

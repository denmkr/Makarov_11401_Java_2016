package ru.kpfu.dm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.kpfu.dm.entity.Cart;
import ru.kpfu.dm.entity.CartProduct;
import ru.kpfu.dm.entity.Order;
import ru.kpfu.dm.entity.Product;
import ru.kpfu.dm.repository.OrderRepository;
import ru.kpfu.dm.repository.UserRepository;
import ru.kpfu.dm.service.OrderService;
import ru.kpfu.dm.service.UserService;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    public OrderRepository orderRepository;
    @Autowired
    UserService userService;
    public Authentication authentication;

    @Override
    public boolean createOrder(Cart cart) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        Order order = new Order();

        for (CartProduct cartProduct : cart.getCartProducts()) {
            order.setProduct(cartProduct.getProduct());
            order.setCount(1);
            order.setUser(userService.findByUsername(authentication.getName()));

            java.util.Date date = new java.util.Date();
            order.setDate(new Timestamp(date.getTime()));

            orderRepository.saveAndFlush(order);
        }

        return true;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Long countOfOrdersToday() {
        return orderRepository.countOfOrdersToday();
    }
}
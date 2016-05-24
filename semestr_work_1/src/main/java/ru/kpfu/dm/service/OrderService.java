package ru.kpfu.dm.service;

import ru.kpfu.dm.entity.Cart;
import ru.kpfu.dm.entity.Order;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Denis on 17.04.16.
 */
public interface OrderService {
    boolean createOrder(Cart cart);
    List<Order> getOrders();

    Long countOfOrdersToday();
}


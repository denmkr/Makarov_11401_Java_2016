package ru.kpfu.dm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.dm.entity.Order;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Denis on 26.04.16.
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAll();

    @Query("SELECT COUNT(*) from Order order WHERE EXTRACT(DAY FROM date) = EXTRACT(DAY FROM current_timestamp)")
    Long countOfOrdersToday();
}


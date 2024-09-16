package org.example.ctac104ordermanagementsystem.repository;

import org.example.ctac104ordermanagementsystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}


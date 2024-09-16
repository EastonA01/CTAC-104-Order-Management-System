package org.example.ctac104ordermanagementsystem.repository;

import org.example.ctac104ordermanagementsystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

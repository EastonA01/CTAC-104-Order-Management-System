package org.example.ctac104ordermanagementsystem;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private LocalDate orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Product> products;

    // Getters, Setters, Constructors (Lombok can be used here)
}

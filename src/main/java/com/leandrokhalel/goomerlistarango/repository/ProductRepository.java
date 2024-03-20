package com.leandrokhalel.goomerlistarango.repository;

import com.leandrokhalel.goomerlistarango.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

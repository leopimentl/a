package com.leandrokhalel.goomerlistarango.repository;

import com.leandrokhalel.goomerlistarango.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}

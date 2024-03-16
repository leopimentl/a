package com.leandrokhalel.goomerlistarango.repository;

import com.leandrokhalel.goomerlistarango.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}

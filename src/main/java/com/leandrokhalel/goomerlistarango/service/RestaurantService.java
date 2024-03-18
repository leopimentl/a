package com.leandrokhalel.goomerlistarango.service;

import com.leandrokhalel.goomerlistarango.model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.web.multipart.MultipartFile;

public interface RestaurantService {

    Restaurant save(Restaurant restaurant, MultipartFile mf);

    Restaurant findById(Long id);

    Page<Restaurant> findAll(Pageable pageable);

    Restaurant update(Long id, Restaurant restaurant);

    void deleteById(Long id);
}

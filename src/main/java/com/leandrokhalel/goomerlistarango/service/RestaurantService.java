package com.leandrokhalel.goomerlistarango.service;

import com.leandrokhalel.goomerlistarango.dto.CreateRestaurantDTO;
import com.leandrokhalel.goomerlistarango.dto.RestaurantDetails;
import com.leandrokhalel.goomerlistarango.dto.RestaurantMinView;
import com.leandrokhalel.goomerlistarango.model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface RestaurantService {

    RestaurantMinView save(CreateRestaurantDTO createRestaurantDTO, MultipartFile image) throws IOException;

    RestaurantDetails findById(Long id);

    Page<RestaurantMinView> findAll(Pageable pageable);

    void update(Restaurant restaurant);

    void deleteById(Long id);
}

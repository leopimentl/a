package com.leandrokhalel.goomerlistarango.service;

import com.leandrokhalel.goomerlistarango.dto.CreateRestaurantDTO;
import com.leandrokhalel.goomerlistarango.dto.RestaurantMinView;
import com.leandrokhalel.goomerlistarango.model.Restaurant;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface RestaurantService {

    RestaurantMinView save(CreateRestaurantDTO createRestaurantDTO, MultipartFile image) throws IOException;

    byte[] findById(Long id);

    void findAll();

    void update(Restaurant restaurant);

    void deleteById(Long id);
}

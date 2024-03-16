package com.leandrokhalel.goomerlistarango.service.impl;

import com.leandrokhalel.goomerlistarango.model.Restaurant;
import com.leandrokhalel.goomerlistarango.repository.RestaurantRepository;
import com.leandrokhalel.goomerlistarango.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestauranteServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestauranteServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return this.restaurantRepository.save(restaurant);
    }

    @Override
    public void findById(Long id) {

    }

    @Override
    public void findAll() {

    }

    @Override
    public void update(Restaurant restaurant) {

    }

    @Override
    public void deleteById(Long id) {

    }
}

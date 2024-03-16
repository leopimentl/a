package com.leandrokhalel.goomerlistarango.service;

import com.leandrokhalel.goomerlistarango.model.Restaurant;


public interface RestaurantService {

    Restaurant save(Restaurant restaurant);

    void findById(Long id);

    void findAll();

    void update(Restaurant restaurant);

    void deleteById(Long id);

}

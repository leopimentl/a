package com.leandrokhalel.goomerlistarango.controller;

import com.leandrokhalel.goomerlistarango.model.Restaurant;
import com.leandrokhalel.goomerlistarango.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<Restaurant> save(@RequestBody Restaurant restaurant) {
        return ResponseEntity.ok(this.restaurantService.save(restaurant));
    }
}

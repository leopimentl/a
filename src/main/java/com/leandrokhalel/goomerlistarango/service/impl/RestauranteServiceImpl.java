package com.leandrokhalel.goomerlistarango.service.impl;

import com.leandrokhalel.goomerlistarango.model.Restaurant;
import com.leandrokhalel.goomerlistarango.repository.OpeningHourRepository;
import com.leandrokhalel.goomerlistarango.repository.RestaurantRepository;
import com.leandrokhalel.goomerlistarango.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class RestauranteServiceImpl implements RestaurantService {

    private RestaurantRepository restaurantRepo;
    private OpeningHourRepository openingHourRepo;

    @Autowired
    public RestauranteServiceImpl(RestaurantRepository restaurantRepo, OpeningHourRepository openingHourRepo) {
        this.restaurantRepo = restaurantRepo;
        this.openingHourRepo = openingHourRepo;
    }

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant, MultipartFile image) {
        setImage(restaurant, image);

        restaurant.getOpeningHours()
                .forEach(oh -> oh.setRestaurant(restaurant));

        return restaurantRepo.save(restaurant);
    }

    @Override
    @Transactional(readOnly = true)
    public Restaurant findById(Long id) {
        return restaurantRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Restaurant> findAll(Pageable pageable) {
        return restaurantRepo.findAll(pageable);
    }

    @Override
    @Transactional
    public Restaurant update(Long id, Restaurant restaurant) {
        Restaurant restaurantDB = restaurantRepo.getReferenceById(id);
        restaurantDB.setName(restaurant.getName());
        restaurantDB.setAddress(restaurant.getAddress());
        restaurantDB.setOpeningHours(restaurant.getOpeningHours());
        return restaurantRepo.save(restaurantDB);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        restaurantRepo.deleteById(id);
    }

    private void setImage(Restaurant restaurant, MultipartFile image) {
        if (image == null) {
            throw new RuntimeException("Image is required");
        }
        try {
            restaurant.setImage(image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error to read image");
        }
    }
}


package com.leandrokhalel.goomerlistarango.service.impl;

import com.leandrokhalel.goomerlistarango.dto.CreateRestaurantDTO;
import com.leandrokhalel.goomerlistarango.dto.RestaurantMinView;
import com.leandrokhalel.goomerlistarango.mapper.OpenningHourMapper;
import com.leandrokhalel.goomerlistarango.mapper.RestaurantMapper;
import com.leandrokhalel.goomerlistarango.model.OpeningHour;
import com.leandrokhalel.goomerlistarango.model.Restaurant;
import com.leandrokhalel.goomerlistarango.repository.OpeningHourRepository;
import com.leandrokhalel.goomerlistarango.repository.RestaurantRepository;
import com.leandrokhalel.goomerlistarango.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestauranteServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;
    private final OpeningHourRepository openingHourRepository;
    private final OpenningHourMapper openningHourMapper;

    @Override
    public RestaurantMinView save(CreateRestaurantDTO dto, MultipartFile image) throws IOException {

        Restaurant restaurant = restaurantMapper.map(dto);
        restaurant.setImage(image.getBytes());

        List<OpeningHour> openingHours = this.openningHourMapper.map(restaurant.getOpeningHours(), restaurant);

        this.restaurantRepository.save(restaurant);
        this.openingHourRepository.saveAll(openingHours);

        return new RestaurantMinView(restaurant);
    }

    @Override
    public byte[] findById(Long id) {
        return this.restaurantRepository.findById(id).get().getImage();
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


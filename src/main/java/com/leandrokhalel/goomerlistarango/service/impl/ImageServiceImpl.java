package com.leandrokhalel.goomerlistarango.service.impl;

import com.leandrokhalel.goomerlistarango.model.Image;
import com.leandrokhalel.goomerlistarango.repository.ImageRepository;
import com.leandrokhalel.goomerlistarango.repository.RestaurantRepository;
import com.leandrokhalel.goomerlistarango.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;
    private RestaurantRepository restaurantRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, RestaurantRepository restaurantRepository) {
        this.imageRepository = imageRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Image save(MultipartFile file, Long restaurantId) throws Exception {

        var image = Image.builder()
                .filename(file.getOriginalFilename())
                .mimeType(file.getContentType())
                .data(file.getBytes())
                .build();

        var restaurant = this.restaurantRepository.findById(restaurantId).get();
        var savedImage = this.imageRepository.save(image);
        restaurant.setImage(savedImage);
        this.restaurantRepository.save(restaurant);

        return savedImage;
    }
}

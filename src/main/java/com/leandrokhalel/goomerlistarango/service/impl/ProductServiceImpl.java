package com.leandrokhalel.goomerlistarango.service.impl;

import com.leandrokhalel.goomerlistarango.dto.ProductFormData;
import com.leandrokhalel.goomerlistarango.model.Product;
import com.leandrokhalel.goomerlistarango.model.Restaurant;
import com.leandrokhalel.goomerlistarango.repository.ProductRepository;
import com.leandrokhalel.goomerlistarango.service.ProductService;
import com.leandrokhalel.goomerlistarango.service.RestaurantService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private RestaurantService restaurantService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, RestaurantService restaurantService) {
        this.productRepository = productRepository;
        this.restaurantService = restaurantService;
    }

    @Override
    public Product save(ProductFormData data) {
        Restaurant restaurant = restaurantService.findById(data.restaurantId());

        Product product = Product.builder()
                .name(data.name())
                .price(data.price())
                .category(data.category())
                .restaurant(restaurant)
                .build();

        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }
}

package com.leandrokhalel.goomerlistarango.service.impl;

import com.leandrokhalel.goomerlistarango.dto.SaleFormData;
import com.leandrokhalel.goomerlistarango.model.Product;
import com.leandrokhalel.goomerlistarango.model.Sale;
import com.leandrokhalel.goomerlistarango.repository.SaleRepository;
import com.leandrokhalel.goomerlistarango.service.ProductService;
import com.leandrokhalel.goomerlistarango.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepo;
    private ProductService productService;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepo, ProductService productService) {
        this.saleRepo = saleRepo;
        this.productService = productService;
    }

    @Override
    public Sale save(SaleFormData data) {
        Product product = productService.findById(data.productId());

        Sale sale = Sale.builder()
                .description(data.description())
                .discountPercentage(data.discountPercentage())
                .saleDaysHours(data.saleDayHour())
                .product(product)
                .build();

        return saleRepo.save(sale);
    }
}

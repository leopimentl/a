package com.leandrokhalel.goomerlistarango.service.impl;

import com.leandrokhalel.goomerlistarango.dto.SaleFormData;
import com.leandrokhalel.goomerlistarango.model.Product;
import com.leandrokhalel.goomerlistarango.model.Sale;
import com.leandrokhalel.goomerlistarango.model.SaleDayHour;
import com.leandrokhalel.goomerlistarango.repository.ProductRepository;
import com.leandrokhalel.goomerlistarango.repository.SaleDayHourRepository;
import com.leandrokhalel.goomerlistarango.repository.SaleRepository;
import com.leandrokhalel.goomerlistarango.service.ProductService;
import com.leandrokhalel.goomerlistarango.service.SaleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepo;
    private ProductRepository productRepository;
    private SaleDayHourRepository dayHourRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepo, ProductRepository productRepository, SaleDayHourRepository dayHourRepository) {
        this.saleRepo = saleRepo;
        this.productRepository = productRepository;
        this.dayHourRepository = dayHourRepository;
    }

    @Override
    public Sale save(SaleFormData data) {
        Product product = productRepository.findById(data.productId()).get();

        Sale sale = Sale.builder()
                .description(data.description())
                .discountPercentage(data.discountPercentage())
                .saleDaysHours(data.saleDayHours())
                .product(product)
                .build();

        sale = saleRepo.save(sale);

        List<SaleDayHour> saleDayHours = data.saleDayHours();
        for (SaleDayHour saleDayHour : saleDayHours) {
            saleDayHour.setSale(sale);
        }
        dayHourRepository.saveAll(saleDayHours);

        product.setSale(sale);
        productRepository.save(product);

        return sale;
    }

    @Override
    public Sale findById(Long id) {
        return saleRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found"));
    }
}

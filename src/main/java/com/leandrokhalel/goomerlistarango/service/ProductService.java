package com.leandrokhalel.goomerlistarango.service;

import com.leandrokhalel.goomerlistarango.dto.ProductFormData;
import com.leandrokhalel.goomerlistarango.model.Product;

public interface ProductService {

    Product save(ProductFormData data);

    Product findById(Long id);
}

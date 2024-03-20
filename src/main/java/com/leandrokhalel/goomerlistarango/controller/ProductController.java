package com.leandrokhalel.goomerlistarango.controller;

import com.leandrokhalel.goomerlistarango.dto.ProductFormData;
import com.leandrokhalel.goomerlistarango.model.Product;
import com.leandrokhalel.goomerlistarango.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductFormData data) {
        Product product = productService.save(data);

        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}").buildAndExpand(product.getId()).toUri())
                .body(product);
    }
}

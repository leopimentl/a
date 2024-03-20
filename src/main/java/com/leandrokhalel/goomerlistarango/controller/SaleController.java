package com.leandrokhalel.goomerlistarango.controller;

import com.leandrokhalel.goomerlistarango.dto.SaleFormData;
import com.leandrokhalel.goomerlistarango.model.Sale;
import com.leandrokhalel.goomerlistarango.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class SaleController {

    private SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<Sale> save(@RequestBody SaleFormData data) {
        return ResponseEntity.ok(saleService.save(data));
    }
}

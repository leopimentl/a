package com.leandrokhalel.goomerlistarango.service;

import com.leandrokhalel.goomerlistarango.dto.SaleFormData;
import com.leandrokhalel.goomerlistarango.model.Sale;

public interface SaleService {

    Sale save(SaleFormData data);

    Sale findById(Long id);
}

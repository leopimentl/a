package com.leandrokhalel.goomerlistarango.service;

import com.leandrokhalel.goomerlistarango.model.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    Image save(MultipartFile file, Long restaurantId) throws Exception;

}

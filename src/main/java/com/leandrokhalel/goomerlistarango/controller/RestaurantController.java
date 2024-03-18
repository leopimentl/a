package com.leandrokhalel.goomerlistarango.controller;

import com.leandrokhalel.goomerlistarango.dto.CreateRestaurantDTO;
import com.leandrokhalel.goomerlistarango.dto.RestaurantMinView;
import com.leandrokhalel.goomerlistarango.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<RestaurantMinView> save(@RequestPart("restaurant") CreateRestaurantDTO dto,
                                                  @RequestPart("image") MultipartFile file) throws IOException {

        var restaurantMinView = this.restaurantService.save(dto, file);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(restaurantMinView.id())
                .toUri();

        return ResponseEntity.created(location).body(restaurantMinView);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<?> downloadFile(@PathVariable Long id) {
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(this.restaurantService.findById(id));
    }
}

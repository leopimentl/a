package com.leandrokhalel.goomerlistarango.controller;

import com.leandrokhalel.goomerlistarango.dto.CreateRestaurantDTO;
import com.leandrokhalel.goomerlistarango.dto.RestaurantMinView;
import com.leandrokhalel.goomerlistarango.dto.RestaurantDetails;
import com.leandrokhalel.goomerlistarango.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping
    public ResponseEntity<Page<RestaurantMinView>> findAll(Pageable pageable) {
        return ResponseEntity.ok(restaurantService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDetails> findById(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantService.findById(id));
    }
}

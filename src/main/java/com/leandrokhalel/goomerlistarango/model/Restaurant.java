package com.leandrokhalel.goomerlistarango.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Entity(name = "restaurant")
@Table(name = "restaurant")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Adress adress;

    @Lob
    private byte[] image;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<OpeningHour> openingHours;
}

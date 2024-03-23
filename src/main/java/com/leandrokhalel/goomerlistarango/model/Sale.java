package com.leandrokhalel.goomerlistarango.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "sale")
@Table(name = "sale")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Integer discountPercentage;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleDayHour> saleDaysHours;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonIgnore
    private Product product;

}

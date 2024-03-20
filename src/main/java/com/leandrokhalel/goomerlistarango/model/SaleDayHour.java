package com.leandrokhalel.goomerlistarango.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity(name = "sale_day_hour")
@Table(name = "sale_day_hour")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDayHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DayOfWeek day;

    private LocalTime open;

    private LocalTime close;

    @ManyToOne()
    @JoinColumn(name = "sale_id")
    @JsonIgnore
    private Sale sale;
}

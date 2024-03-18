package com.leandrokhalel.goomerlistarango.repository;

import com.leandrokhalel.goomerlistarango.model.OpeningHour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpeningHourRepository extends JpaRepository<OpeningHour, Long> {
}

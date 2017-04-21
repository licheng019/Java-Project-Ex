package com.cheng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cheng.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

}

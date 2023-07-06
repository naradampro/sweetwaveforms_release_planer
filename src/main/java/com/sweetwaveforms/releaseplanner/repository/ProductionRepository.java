package com.sweetwaveforms.releaseplanner.repository;

import com.sweetwaveforms.releaseplanner.model.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Long> {
}
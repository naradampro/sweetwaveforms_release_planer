package com.sweetwaveforms.releaseplanner.repository;

import com.sweetwaveforms.releaseplanner.model.SongRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRequestRepository extends JpaRepository<SongRequest, Long> {
}

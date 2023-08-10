package com.sweetwaveforms.releaseplanner.repository;

import com.sweetwaveforms.releaseplanner.model.WorkManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkManageRepository extends JpaRepository<WorkManager,Long> {
}

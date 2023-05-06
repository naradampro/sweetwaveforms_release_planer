package com.sweetwaveforms.releaseplanner.repository;

import com.sweetwaveforms.releaseplanner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

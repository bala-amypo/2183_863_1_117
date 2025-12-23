package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.DeviceProfile;
import java.util.Optional;
import java.util.List;

public interface DeviceProfileRepository extends JpaRepository<DeviceProfile, Long> {

    Optional<DeviceProfile> findByDeviceId(String deviceId);

    List<DeviceProfile> findByUserId(Long userId);
}


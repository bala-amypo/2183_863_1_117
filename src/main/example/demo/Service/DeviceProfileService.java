package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;
import java.util.List;

public interface DeviceProfileService {

    DeviceProfile createDevice(DeviceProfile deviceProfile);

    DeviceProfile getDeviceById(Long id);

    DeviceProfile updateDevice(Long id, DeviceProfile deviceProfile);

    void deleteDevice(Long id);

    List<DeviceProfile> getAllDevices();
}

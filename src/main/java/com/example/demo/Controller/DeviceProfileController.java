package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    // CREATE device
    @PostMapping
    public DeviceProfile create(@RequestBody DeviceProfile deviceProfile) {
        return service.createDevice(deviceProfile);
    }

    // GET device by ID
    @GetMapping("/{id}")
    public DeviceProfile getById(@PathVariable Long id) {
        return service.getDeviceById(id);
    }

    // UPDATE device
    @PutMapping("/{id}")
    public DeviceProfile update(@PathVariable Long id,
                                @RequestBody DeviceProfile deviceProfile) {
        return service.updateDevice(id, deviceProfile);
    }

    // DELETE device
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteDevice(id);
    }

    // GET all devices
    @GetMapping
    public List<DeviceProfile> getAll() {
        return service.getAllDevices();
    }
}

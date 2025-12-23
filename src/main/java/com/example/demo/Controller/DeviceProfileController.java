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
    public DeviceProfile create(
package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    DeviceProfileService deviceService;   

    public DeviceProfileController(DeviceProfileService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping
    public DeviceProfile register(@RequestBody DeviceProfile device) {
        return deviceService.registerDevice(device);
    }

    @PutMapping("/{id}/trust")
    public DeviceProfile updateTrust(@PathVariable Long id,
                                     @RequestParam boolean trust) {
        return deviceService.updateTrustStatus(id, trust);
    }

    @GetMapping("/user/{userId}")
    public List<DeviceProfile> getDevicesByUser(@PathVariable Long userId) {
        return deviceService.getDevicesByUser(userId);
    }

    @GetMapping("/lookup/{deviceId}")
    public Optional<DeviceProfile> getByDeviceId(@PathVariable String deviceId) {
        return deviceService.findByDeviceId(deviceId);
    }
}
@RequestBody DeviceProfile deviceProfile) {
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

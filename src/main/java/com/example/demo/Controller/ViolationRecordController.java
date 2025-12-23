package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    private final ViolationRecordService service;

    // ✅ Constructor injection (MANDATORY)
    public ViolationRecordController(ViolationRecordService service) {
        this.service = service;
    }

    // POST /api/violations
    @PostMapping
    public ViolationRecord logViolation(@RequestBody ViolationRecord violation) {
        return service.logViolation(violation);
    }

    // GET /api/violations/user/{userId}
    @GetMapping("/user/{userId}")
    public List<ViolationRecord> getByUser(@PathVariable Long userId) {
        return service.getViolationsByUser(userId);
    }

    // PUT /api/violations/{id}/resolve
    @PutMapping("/{id}/resolve")
    public ViolationRecord resolve(@PathVariable Long id) {
        return service.markResolved(id);
    }

    // GET /api/violations/unresolved
    @GetMapping("/unresolved")
    public List<ViolationRecord> getUnresolved() {
        return service.getUnresolvedViolations();
    }

    // GET /api/violations
    @GetMapping
package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    ViolationRecordService violationService;   

    public ViolationRecordController(ViolationRecordService violationService) {
        this.violationService = violationService;
    }

    @PostMapping
    public ViolationRecord log(@RequestBody ViolationRecord violation) {
        return violationService.logViolation(violation);
    }

    @GetMapping("/user/{userId}")
    public List<ViolationRecord> getByUser(@PathVariable Long userId) {
        return violationService.getViolationsByUser(userId);
    }

    @PutMapping("/{id}/resolve")
    public ViolationRecord resolve(@PathVariable Long id) {
        return violationService.markResolved(id);
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> getUnresolved() {
        return violationService.getUnresolvedViolations();
    }

    @GetMapping
    public List<ViolationRecord> getAll() {
        return violationService.getAllViolations();
    }
}

    public List<ViolationRecord> getAll() {
        return service.getAllViolations();
    }
}

package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class PolicyRuleController {

    private final PolicyRuleService service;

    // ✅ Constructor injection (MANDATORY)
    public PolicyRuleController(PolicyRuleService service) {
        this.service = service;
    }

    // POST /api/rules
    @PostMapping
    public PolicyRule createRule(@RequestBody PolicyRule rule) {
        return service.createRule(rule);
    }

    // PUT /api/rules/{id}
    @PutMapping("/{id}")
    public PolicyRule updateRule(@PathVariable Long id,
                                 @RequestBody PolicyRule rule) {
        return service.updateRule(id, rule);
    }

    // GET /api/rules/active
    @GetMapping("/active")
    public List<PolicyRule> getActiveRules() {
        return service.getActiveRules();
    }

    // GET /api/rules
    @GetMapping
    public List<PolicyRule> getAllRules() {
        return service.getAllRules();
    }
}

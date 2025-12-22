package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repo;

    // ✅ REQUIRED CONSTRUCTOR SIGNATURE
    public PolicyRuleServiceImpl(PolicyRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {

        repo.findAll().forEach(r -> {
            if (r.getRuleCode().equals(rule.getRuleCode())) {
                throw new IllegalArgumentException("Rule exists");
            }
        });

        return repo.save(rule);
    }

    @Override
    public PolicyRule updateRule(Long id, PolicyRule updated) {
        PolicyRule rule = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));

        rule.setDescription(updated.getDescription());
        rule.setSeverity(updated.getSeverity());
        rule.setConditionsJson(updated.getConditionsJson());
        rule.setActive(updated.getActive());

        return repo.save(rule);
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    @Override
    public Optional<PolicyRule> getRuleByCode(String ruleCode) {
        return repo.findAll().stream()
                .filter(r -> r.getRuleCode().equals(ruleCode))
                .findFirst();
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return repo.findAll();
    }
}

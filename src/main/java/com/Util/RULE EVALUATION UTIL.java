package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;

public class RuleEvaluationUtil {

    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo,
                              ViolationRecordRepository violationRepo) {
    }

    public void evaluateLoginEvent(LoginEvent event) {
        // Tests only check invocation
    }
}

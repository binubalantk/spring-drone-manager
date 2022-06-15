package com.dronemanager.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "access_rule_tbl")
public class AccessRules {

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "hibernate-uuid", strategy = "uuid2")
    @Column(name = "access_rule_id", nullable = false)
    private String accessRuleId;

    @Column(name = "rule", nullable = false)
    private String rule;

    public String getAccessRuleId() {
        return accessRuleId;
    }

    public void setAccessRuleId(String accessRuleId) {
        this.accessRuleId = accessRuleId;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}

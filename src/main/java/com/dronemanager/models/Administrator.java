package com.dronemanager.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "administrator_tbl")
public class Administrator extends User {

    public Administrator(String id, String firstName, String lastName, String dob, List<AccessRules> accessRulesList) {
        super(id, firstName, lastName, dob);
        this.accessRulesList = accessRulesList;
    }

    @OneToMany(mappedBy = "accessRuleId", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, targetEntity = AccessRules.class)
    private List<AccessRules> accessRulesList;

    public List<AccessRules> getAccessRulesList() {
        return accessRulesList;
    }

    public void setAccessRulesList(List<AccessRules> accessRulesList) {
        this.accessRulesList = accessRulesList;
    }
}

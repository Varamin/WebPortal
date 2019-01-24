package com.rnko.webportal.backend.rest.data;

import com.atlassian.jira.issue.fields.rest.json.beans.IssueRefJsonBean;

import java.util.Map;

public class Issue {
    private String self;
    private String key;
    private Map<String, ?> fields;

    public Issue() {}


    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    public Map<String, ?> getFields() {
        return fields;
    }

    public void setFields(Map<String, ?> fields) {
        this.fields = fields;
    }
}

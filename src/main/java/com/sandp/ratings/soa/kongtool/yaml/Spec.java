package com.sandp.ratings.soa.kongtool.yaml;

public class Spec {

    private Rule[] rules;
    private String type;
    private String externalName;
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExternalName() {
        return externalName;
    }

    public void setExternalName(String externalName) {
        this.externalName = externalName;
    }

    public Rule[] getRules() {
	return rules;
    }

    public void setRules(Rule[] value) {
	this.rules = value;
    }

}

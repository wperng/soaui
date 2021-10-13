package com.sandp.ratings.soa.kongtool.yaml;

import java.util.Map;

public class Metadata {

    private String name;
    private Map<String, String> annotations;

    public String getName() {
	return name;
    }

    public void setName(String value) {
	this.name = value;
    }

    public Map<String, String> getAnnotations() {
	return annotations;
    }

    public void setAnnotations(Map<String, String> value) {
	this.annotations = value;
    }
}

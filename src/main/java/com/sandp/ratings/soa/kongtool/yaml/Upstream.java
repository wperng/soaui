package com.sandp.ratings.soa.kongtool.yaml;

public class Upstream {

    private long slots = 10000;
    private String hashOn = "none";
    private String hashFallback = "none"; 
    private Healthchecks healthchecks;

    public long getSlots() {
	return slots;
    }

    public void setSlots(long value) {
	this.slots = value;
    }

    public String getHashOn() {
	return hashOn;
    }

    public void setHashOn(String value) {
	this.hashOn = value;
    }

    public String getHashFallback() {
	return hashFallback;
    }

    public void setHashFallback(String value) {
	this.hashFallback = value;
    }

    public Healthchecks getHealthchecks() {
	return healthchecks;
    }

    public void setHealthchecks(Healthchecks value) {
	this.healthchecks = value;
    }

}

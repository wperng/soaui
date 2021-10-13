package com.sandp.ratings.soa.kongtool.yaml;

public class Healthchecks {

    private int threshold;
    private Active active ;
    private Passive passive;

    public int getThreshold() {
	return threshold;
    }

    public void setThreshold(int value) {
	this.threshold = value;
    }

    public Active getActive() {
	return active;
    }

    public void setActive(Active value) {
	this.active = value;
    }

    public Passive getPassive() {
	return passive;
    }

    public void setPassive(Passive value) {
	this.passive = value;
    }

}

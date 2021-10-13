package com.sandp.ratings.soa.kongtool.yaml;

public class Healthy {

    private int[] httpStatuses;
    private int interval;
    private int successes;

    public int[] getHTTPStatuses() {
	return httpStatuses;
    }

    public void setHTTPStatuses(int[] value) {
	this.httpStatuses = value;
    }

    public int getInterval() {
	return interval;
    }

    public void setInterval(int value) {
	this.interval = value;
    }

    public int getSuccesses() {
	return successes;
    }

    public void setSuccesses(int value) {
	this.successes = value;
    }

}

package com.sandp.ratings.soa.kongtool.yaml;

public class Unhealthy {

    private int httpFailures;
    private int[] httpStatuses;
    private int interval;
    private int tcpFailures;
    private int timeouts;

    public long getHTTPFailures() {
	return httpFailures;
    }

    public void setHTTPFailures(int value) {
	this.httpFailures = value;
    }

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

    public int getTCPFailures() {
	return tcpFailures;
    }

    public void setTCPFailures(int value) {
	this.tcpFailures = value;
    }

    public int getTimeouts() {
	return timeouts;
    }

    public void setTimeouts(int value) {
	this.timeouts = value;
    }

}

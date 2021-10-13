package com.sandp.ratings.soa.kongtool.yaml;

public class Active {

    private int concurrency;
    private Healthy healthy;
    private String httpPath;
    private int timeout;
    private Unhealthy unhealthy;

    public int getConcurrency() {
	return concurrency;
    }

    public void setConcurrency(int value) {
	this.concurrency = value;
    }

    public Healthy getHealthy() {
	return healthy;
    }

    public void setHealthy(Healthy value) {
	this.healthy = value;
    }

    public String getHTTPPath() {
	return httpPath;
    }

    public void setHTTPPath(String value) {
	this.httpPath = value;
    }

    public int getTimeout() {
	return timeout;
    }

    public void setTimeout(int value) {
	this.timeout = value;
    }

    public Unhealthy getUnhealthy() {
	return unhealthy;
    }

    public void setUnhealthy(Unhealthy value) {
	this.unhealthy = value;
    }

}

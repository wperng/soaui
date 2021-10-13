package com.sandp.ratings.soa.kongtool.yaml;

public class Route {

    // private String[] methods;
    private long regexPriority;
    private boolean stripPath;
    private boolean preserveHost;
    private String requestBuffering;
    private String responseBuffering;
    private String[] protocols;

    public long getRegexPriority() {
	return regexPriority;
    }

    public void setRegexPriority(long value) {
	this.regexPriority = value;
    }

    public boolean getStripPath() {
	return stripPath;
    }

    public void setStripPath(boolean value) {
	this.stripPath = value;
    }

    public boolean getPreserveHost() {
	return preserveHost;
    }

    public void setPreserveHost(boolean value) {
	this.preserveHost = value;
    }

    public String getRequestBuffering() {
	return requestBuffering;
    }

    public void setRequestBuffering(String value) {
	this.requestBuffering = value;
    }

    public String getResponseBuffering() {
	return responseBuffering;
    }

    public void setResponseBuffering(String value) {
	this.responseBuffering = value;
    }

    public String[] getProtocols() {
	return protocols;
    }

    public void setProtocols(String[] value) {
	this.protocols = value;
    }

}

package com.sandp.ratings.soa.kongtool.yaml;

public class Proxy {
    private String protocol;
    private String path;
    private long connectTimeout;
    private long readTimeout;
    private long writeTimeout;

    public String getProtocol() {
	return protocol;
    }

    public void setProtocol(String value) {
	this.protocol = value;
    }

    public String getPath() {
	return path;
    }

    public void setPath(String value) {
	this.path = value;
    }

    public long getConnectTimeout() {
	return connectTimeout;
    }

    public void setConnectTimeout(long value) {
	this.connectTimeout = value;
    }

    public long getReadTimeout() {
	return readTimeout;
    }

    public void setReadTimeout(long value) {
	this.readTimeout = value;
    }

    public long getWriteTimeout() {
	return writeTimeout;
    }

    public void setWriteTimeout(long value) {
	this.writeTimeout = value;
    }
}

package com.sandp.ratings.soa.kongtool.yaml;

import java.util.Map;

public class K8SSection {

    private String apiVersion;
    private String kind;
    private Metadata metadata;
    private boolean disabled;
    private Map<String, Object> config;
    private Spec spec;
    private String plugin;
    private Upstream upstream;
    private Proxy proxy;
    private Route route;
    
    public K8SSection(String apiVersion, String kind){
	this.apiVersion = apiVersion;
	this.kind = kind;
    }
    
    public String getApiVersion() {
	return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
	this.apiVersion = apiVersion;
    }

    public String getKind() {
	return kind;
    }

    public void setKind(String kind) {
	this.kind = kind;
    }

    public Metadata getMetadata() {
	return metadata;
    }

    public void setMetadata(Metadata metadata) {
	this.metadata = metadata;
    }

    public boolean isDisabled() {
	return disabled;
    }

    public void setDisabled(boolean disabled) {
	this.disabled = disabled;
    }

    public Map<String, Object> getConfig() {
	return config;
    }

    public void setConfig(Map<String, Object> config) {
	this.config = config;
    }

    public Spec getSpec() {
	return spec;
    }

    public void setSpec(Spec spec) {
	this.spec = spec;
    }

    public String getPlugin() {
	return plugin;
    }

    public void setPlugin(String plugin) {
	this.plugin = plugin;
    }

    public Upstream getUpstream() {
        return upstream;
    }

    public void setUpstream(Upstream upstream) {
        this.upstream = upstream;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
    

}

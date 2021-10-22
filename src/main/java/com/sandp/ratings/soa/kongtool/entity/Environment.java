package com.sandp.ratings.soa.kongtool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KT_ENVIRONMENT")
public class Environment {
    
    @Id
    @Column(name = "ID", length=50)
    private String id; // int-dev, int-qa ... dmz-dev, dmz-alpha...ext-dev
    
    @Column(name = "CLUSTERNAME", length=50, nullable = false)
    private String caasClusterName;
    
    @Column(name = "WORKSPACE", length=50, nullable = false)
    private String workspace;
    
    @Column(name = "BASEKONGURL", length=100, nullable = false)
    private String baseKongURL;
    
    @Column(name = "APIGEEBASEURL", length=100, nullable = false)
    private String baseApigeeURL;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getCaasClusterName() {
	return caasClusterName;
    }

    public void setCaasClusterName(String caasClusterName) {
	this.caasClusterName = caasClusterName;
    }

    public String getWorkspace() {
	return workspace;
    }

    public void setWorkspace(String workspace) {
	this.workspace = workspace;
    }

    public String getBaseKongURL() {
	return baseKongURL;
    }

    public void setBaseKongURL(String baseKongURL) {
	this.baseKongURL = baseKongURL;
    }

    public String getBaseApigeeURL() {
	return baseApigeeURL;
    }

    public void setBaseApigeeURL(String baseApigeeURL) {
	this.baseApigeeURL = baseApigeeURL;
    }

}

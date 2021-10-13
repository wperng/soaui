package com.sandp.ratings.soa.kongtool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "KT_APIGEEAPI")
public class ApigeeAPI {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "api_id", nullable = false)
    private API api;

    @Column(name = "ENVIRONMENTNAME", length = 100, nullable = false)
    private String environmentName;

    @Column(name = "APIGEENAME", length = 50, nullable = false)
    private String apigeeName;

    @Column(name = "APIGEEURL", length = 100, nullable = false)
    private String apigeeURL;

    @Column(name = "APIGEEEXTERNALURL", length = 100, nullable = false)
    private String apigeeExternalURL;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public API getApi() {
	return api;
    }

    public void setApi(API api) {
	this.api = api;
    }

    public String getEnvironmentName() {
	return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
	this.environmentName = environmentName;
    }

    public String getApigeeName() {
	return apigeeName;
    }

    public void setApigeeName(String apigeeName) {
	this.apigeeName = apigeeName;
    }

    public String getApigeeURL() {
	return apigeeURL;
    }

    public void setApigeeURL(String apigeeURL) {
	this.apigeeURL = apigeeURL;
    }

    public String getApigeeExternalURL() {
	return apigeeExternalURL;
    }

    public void setApigeeExternalURL(String apigeeExternalURL) {
	this.apigeeExternalURL = apigeeExternalURL;
    }

}

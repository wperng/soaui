package com.sandp.ratings.soa.kongtool.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


import com.sandp.ratings.soa.kongtool.service.Constant;

public class APIOnBoardForm {

    @NotBlank(message = "CMDB record name cannot be empty")
    private String cmdbRecordName;

    @NotBlank(message = "short team name cannot be empty")
    private String shortTeamName;

    @NotBlank(message = "scrum team email cannot be empty")
    private String scrumTeamEmails;

    @NotBlank(message = "major contact email cannot be empty")
    @Email(message = "major contact email is invalid")
    private String majorContactEmail;

    private String httpProtocol = Constant.HTTPPOTOCOL_REST; // rest, soap, websocket

    @NotBlank(message = "api zone cannot be empty")
    private String apiZone; // external, DMZ

    @NotBlank(message = "api name cannot be empty")
    private String apiName;

    @NotBlank(message = "target URL cannot be empty")
    private String targetURL;

    @NotEmpty(message = "Authentication type cannot be empty")
    private String[] authentications;

    @NotEmpty(message = "Supported Http methods cannot be empty")
    private String[] httpMethods; // comma seperate method
    
    /*
    @NotEmpty(message = "Supported environment cannot be empty")
    private String[] environments; // comma seperate method
    */

    private String oauthGroups; // comma seperated group names

    @NotEmpty(message = "Buffering control cannot be empty")
    private String[] enableBufferOn;

    @NotEmpty(message = "Logging control cannot be empty")
    private String[] enableLogOn;

    private String specURL;
    private long rateLimit = 300;
    private long timeout = 120;
    private String targetCredential;
    private String allowedContextPaths;
    private String blockedContextPaths;
    private String ipWhiteList;

    @NotBlank(message = "Consumer list cannot be empty")
    private String consumerShortTeamNames; // comma seperate name

    private String appCodeRepoName;
    private String appCodeRepoPwd;
    private String pocRepoPwd;


    public String getCmdbRecordName() {
        return cmdbRecordName;
    }

    public void setCmdbRecordName(String cmdbRecordName) {
        this.cmdbRecordName = cmdbRecordName;
    }

    public String getShortTeamName() {
	return shortTeamName;
    }

    public void setShortTeamName(String shortTeamName) {
	this.shortTeamName = shortTeamName;
    }

    public String getScrumTeamEmails() {
	return scrumTeamEmails;
    }

    public void setScrumTeamEmails(String scrumTeamEmails) {
	this.scrumTeamEmails = scrumTeamEmails;
    }

    public String getMajorContactEmail() {
	return majorContactEmail;
    }

    public void setMajorContactEmail(String majorContactEmail) {
	this.majorContactEmail = majorContactEmail;
    }

    public String getHttpProtocol() {
	return httpProtocol;
    }

    public void setHttpProtocol(String httpProtocol) {
	this.httpProtocol = httpProtocol;
    }

    public String getApiZone() {
	return apiZone;
    }

    public void setApiZone(String apiZone) {
	this.apiZone = apiZone;
    }

    public String getApiName() {
	return apiName;
    }

    public void setApiName(String apiName) {
	this.apiName = apiName;
    }

    public String getTargetURL() {
	return targetURL;
    }

    public void setTargetURL(String targetURL) {
	this.targetURL = targetURL;
    }
    
    public String getAllowedContextPaths() {
        return allowedContextPaths;
    }

    public void setAllowedContextPaths(String allowedContextPaths) {
        this.allowedContextPaths = allowedContextPaths;
    }

    public String getBlockedContextPaths() {
        return blockedContextPaths;
    }

    public void setBlockedContextPaths(String blockedContextPaths) {
        this.blockedContextPaths = blockedContextPaths;
    }

    public String getIpWhiteList() {
        return ipWhiteList;
    }

    public void setIpWhiteList(String ipWhiteList) {
        this.ipWhiteList = ipWhiteList;
    }

    public String[] getAuthentications() {
	return authentications;
    }

    public void setAuthentications(String[] authentications) {
	this.authentications = authentications;
    }

    public String[] getHttpMethods() {
	return httpMethods;
    }

    public void setHttpMethods(String[] httpMethods) {
	this.httpMethods = httpMethods;
    }
    
    /*
    public String[] getEnvironments() {
        return environments;
    }

    public void setEnvironments(String[] environments) {
        this.environments = environments;
    }
    */

    public String getOauthGroups() {
	return oauthGroups;
    }

    public void setOauthGroups(String oauthGroups) {
	this.oauthGroups = oauthGroups;
    }

    public String[] getEnableBufferOn() {
	return enableBufferOn;
    }

    public void setEnableBufferOn(String[] enableBufferOn) {
	this.enableBufferOn = enableBufferOn;
    }

    public String[] getEnableLogOn() {
	return enableLogOn;
    }

    public void setEnableLogOn(String[] enableLogOn) {
	this.enableLogOn = enableLogOn;
    }

    public String getSpecURL() {
	return specURL;
    }

    public void setSpecURL(String specURL) {
	this.specURL = specURL;
    }

    public long getRateLimit() {
	return rateLimit;
    }

    public void setRateLimit(long rateLimit) {
	this.rateLimit = rateLimit;
    }

    public long getTimeout() {
	return timeout;
    }

    public void setTimeout(long timeout) {
	this.timeout = timeout;
    }

    public String getTargetCredential() {
	return targetCredential;
    }

    public void setTargetCredential(String targetCredential) {
	this.targetCredential = targetCredential;
    }

    public String getConsumerShortTeamNames() {
	return consumerShortTeamNames;
    }

    public void setConsumerShortTeamNames(String consumerShortTeamNames) {
	this.consumerShortTeamNames = consumerShortTeamNames;
    }

    public String getAppCodeRepoName() {
	return appCodeRepoName;
    }

    public void setAppCodeRepoName(String appCodeRepoName) {
	this.appCodeRepoName = appCodeRepoName;
    }

    public String getAppCodeRepoPwd() {
	return appCodeRepoPwd;
    }

    public void setAppCodeRepoPwd(String appCodeRepoPwd) {
	this.appCodeRepoPwd = appCodeRepoPwd;
    }

    public String getPocRepoPwd() {
	return pocRepoPwd;
    }

    public void setPocRepoPwd(String pocRepoPwd) {
	this.pocRepoPwd = pocRepoPwd;
    }

 
}

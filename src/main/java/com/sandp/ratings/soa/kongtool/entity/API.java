package com.sandp.ratings.soa.kongtool.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "KT_API")
public class API {
    
    @Id
    @Column(name = "ID", length=50)
    private String id; // short team name + api name
    
    @Column(name = "CMDBRECORDNAME", length=100, nullable = false)
    private String cmdbRecordName;
    
    @Column(name = "SHORTTEAMNAME", length=50, nullable = false)
    private String shortTeamName;
    
    @Column(name = "SCRUMTEAMEMAILs", length=50, nullable = false)
    private String scrumTeamEmails;
    
    @Column(name = "MAJORCONTACTEMAIL", length=50, nullable = false)
    private String majorContactEmail;
    
    @Column(name = "HTTPPROTOCOL", length=10, nullable = false)
    private String httpProtocol; // rest, soap, websocket
    
    @Column(name = "APIZONE", length=10, nullable = false)
    private String apiZone; // external, DMZ
    
    @Column(name = "apiname", length=50, nullable = false)
    private String apiName;
    
    @Column(name = "TARGETURL", length=100, nullable = false)
    private String targetURL;
    
    @Column(name = "IS_DEFAULT_AUTH", nullable = false)
    private boolean isDefaultAuth;
    
    @Column(name = "IS_BASIC_AUTH", nullable = false)
    private boolean isBasicAuth;
    
    @Column(name = "IS_LDAP_AUTH", nullable = false)
    private boolean isLDAPAuth;
    
    @Column(name = "IS_OAUTH_AUTH", nullable = false)
    private boolean isOAUTHAuth;
    
    @Column(name = "IS_SNLJWT_AUTH", nullable = false)
    private boolean isSNLJWTAuth;
    
    @Column(name = "IS_OAM_AUTH", nullable = false)
    private boolean isOAMAuth;
    
    @Column(name = "ENABLE_GET_METHOD", nullable = false)
    private boolean enableGETMethod;
    
    @Column(name = "ENABLE_PUT_METHOD", nullable = false)
    private boolean enablePUTMethod;
    
    @Column(name = "ENABLE_POST_METHOD", nullable = false)
    private boolean enablePOSTMethod;
    
    @Column(name = "ENABLE_OPTIONS_METHOD", nullable = false)
    private boolean enableOPTIONSMethod;
    
    @Column(name = "ENABLE_DELETE_METHOD", nullable = false)
    private boolean enableDELETEMethod;
    
    @Column(name = "OAUTHGROUP", length=50, nullable = false)
    private String oauthGroups; // comma separated group names
    
    @Column(name = "ENABLE_REQUEST_BUFFERING", nullable = false)
    private boolean enableRequestBuffering;
    
    @Column(name = "ENABLE_RESPONSE_BUFFERING", nullable = false)
    private boolean enableReponseBuffering;
    
    @Column(name = "ENABLE_REQUEST_LOG", nullable = false)
    private boolean enableRequestLog;
    
    @Column(name = "ENABLE_RESPONSE_LOG", nullable = false)
    private boolean enableResponseLog;
    
    @Column(name = "SPECURL", length=100, nullable = false)
    private String specURL;
    
    @Column(name = "RATELIMIT", nullable = false)
    private long rateLimit;
    
    @Column(name = "TIMEOUT", nullable = false)
    private long timeout;

    @Column(name = "ALLOWCONTEXTPATHS", length=200, nullable = false)
    private String allowedContextPaths;
    
    @Column(name = "BLOCKEDCONTEXTPATHS", length=200, nullable = false)
    private String blockedContextPaths;
    
    @Column(name = "IPWHITELIST", length=200, nullable = false)
    private String ipWhiteList;
    
    @Column(name = "TARGETCREDENTIAL", length=50, nullable = false)
    private String targetCredential;
    
    @Column(name = "CONSUMERSHORTNAMES", length=200, nullable = false)
    private String consumerShortTeamNames; // comma seperate name
    
    @Column(name = "APPCODEREPONAME", length=50, nullable = false)
    private String appCodeRepoName;
    
    @Column(name = "STATUS", length=50, nullable = false)
    private String status;
    
    @Column(name = "REASON", length=225, nullable = true)
    private String reason;
    
    @Column(name = "CREATEDBY", length=50, nullable = false)
    private String createdBy;
    
    @Column(name = "CREATED_DATETIME", nullable = false)
    private Date createDateTime;
    
    /*
    @OneToMany(mappedBy="api")
    private Set<ApigeeAPI> apigeeAPIs;
    */
    
    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }
    
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

    public boolean isDefaultAuth() {
	return isDefaultAuth;
    }

    public void setDefaultAuth(boolean isDefaultAuth) {
	this.isDefaultAuth = isDefaultAuth;
    }

    public boolean isBasicAuth() {
	return isBasicAuth;
    }

    public void setBasicAuth(boolean isBasicAuth) {
	this.isBasicAuth = isBasicAuth;
    }

    public boolean isLDAPAuth() {
	return isLDAPAuth;
    }

    public void setLDAPAuth(boolean isLDAPAuth) {
	this.isLDAPAuth = isLDAPAuth;
    }

    public boolean isOAUTHAuth() {
	return isOAUTHAuth;
    }

    public void setOAUTHAuth(boolean isOAUTHAuth) {
	this.isOAUTHAuth = isOAUTHAuth;
    }

    public boolean isSNLJWTAuth() {
	return isSNLJWTAuth;
    }

    public void setSNLJWTAuth(boolean isSNLJWTAuth) {
	this.isSNLJWTAuth = isSNLJWTAuth;
    }

    public boolean isOAMAuth() {
	return isOAMAuth;
    }

    public void setOAMAuth(boolean isOAMAuth) {
	this.isOAMAuth = isOAMAuth;
    }

    public boolean isEnableGETMethod() {
        return enableGETMethod;
    }

    public void setEnableGETMethod(boolean enableGETMethod) {
        this.enableGETMethod = enableGETMethod;
    }

    public boolean isEnablePUTMethod() {
        return enablePUTMethod;
    }

    public void setEnablePUTMethod(boolean enablePUTMethod) {
        this.enablePUTMethod = enablePUTMethod;
    }

    public boolean isEnablePOSTMethod() {
        return enablePOSTMethod;
    }

    public void setEnablePOSTMethod(boolean enablePOSTMethod) {
        this.enablePOSTMethod = enablePOSTMethod;
    }

    public boolean isEnableOPTIONSMethod() {
        return enableOPTIONSMethod;
    }

    public void setEnableOPTIONSMethod(boolean enableOPTIONSMethod) {
        this.enableOPTIONSMethod = enableOPTIONSMethod;
    }

    public boolean isEnableDELETEMethod() {
        return enableDELETEMethod;
    }

    public void setEnableDELETEMethod(boolean enableDELETEMethod) {
        this.enableDELETEMethod = enableDELETEMethod;
    }

    public String getOauthGroups() {
	return oauthGroups;
    }

    public void setOauthGroups(String oauthGroups) {
	this.oauthGroups = oauthGroups;
    }

    public boolean isEnableRequestBuffering() {
	return enableRequestBuffering;
    }

    public void setEnableRequestBuffering(boolean enableRequestBuffering) {
	this.enableRequestBuffering = enableRequestBuffering;
    }

    public boolean isEnableReponseBuffering() {
	return enableReponseBuffering;
    }

    public void setEnableReponseBuffering(boolean enableReponseBuffering) {
	this.enableReponseBuffering = enableReponseBuffering;
    }

    public boolean isEnableRequestLog() {
	return enableRequestLog;
    }

    public void setEnableRequestLog(boolean enableRequestLog) {
	this.enableRequestLog = enableRequestLog;
    }

    public boolean isEnableResponseLog() {
	return enableResponseLog;
    }

    public void setEnableResponseLog(boolean enableResponseLog) {
	this.enableResponseLog = enableResponseLog;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCreatedBy() {
	return createdBy;
    }

    public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    /*
    public Set<ApigeeAPI> getApigeeAPIs() {
        return apigeeAPIs;
    }

    public void setApigeeAPIs(Set<ApigeeAPI> apigeeAPIs) {
        this.apigeeAPIs = apigeeAPIs;
    }
    */
    

}

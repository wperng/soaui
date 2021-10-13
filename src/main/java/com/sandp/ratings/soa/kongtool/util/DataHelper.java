package com.sandp.ratings.soa.kongtool.util;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.sandp.ratings.soa.kongtool.entity.API;
import com.sandp.ratings.soa.kongtool.form.APIOnBoardForm;
import com.sandp.ratings.soa.kongtool.service.Constant;

public class DataHelper {
    
    public static API copyDataToEntityObject(APIOnBoardForm form) {
	API api = new API();
	api.setCmdbRecordName(form.getCmdbRecordName());
	api.setShortTeamName(form.getShortTeamName());
	api.setScrumTeamEmails(form.getScrumTeamEmails());
	api.setMajorContactEmail(form.getMajorContactEmail());
	api.setHttpProtocol(form.getHttpProtocol());
	api.setApiZone(form.getApiZone());
	api.setApiName(form.getApiName());
	api.setTargetURL(form.getTargetURL());
	
	String[] auths = form.getAuthentications();
	for(int i=0; i< auths.length; i++) {
	    if(Constant.AUTHENTICATION_DEFAULT.equalsIgnoreCase(auths[i])) {
		api.setDefaultAuth(true);
	    }else {
		api.setDefaultAuth(false);
	    }
	    
	    if(Constant.AUTHENTICATION_BASIC.equalsIgnoreCase(auths[i])) {
		api.setBasicAuth(true);
	    }else {
		api.setBasicAuth(false);
	    }
	    
	    if(Constant.AUTHENTICATION_LDAP.equalsIgnoreCase(auths[i])) {
		api.setLDAPAuth(true);
	    }else {
		api.setLDAPAuth(false);
	    }
	    
	    if(Constant.AUTHENTICATION_OAUTH.equalsIgnoreCase(auths[i])) {
		api.setOAUTHAuth(true);
	    }else {
		api.setOAUTHAuth(false);
	    }
	    
	    if(Constant.AUTHENTICATION_SNLJWT.equalsIgnoreCase(auths[i])) {
		api.setSNLJWTAuth(true);
	    }else {
		api.setSNLJWTAuth(false);
	    }
	    
	    if(Constant.AUTHENTICATION_OAM.equalsIgnoreCase(auths[i])) {
		api.setOAMAuth(true);
	    }else {
		api.setOAMAuth(false);
	    }
	    
	}
	
	String[] httpMethods = form.getHttpMethods();
	for(int i=0; i< httpMethods.length; i++) {
	    if(Constant.HTTPMETHOD_GET.equalsIgnoreCase(httpMethods[i])) {
		api.setEnableGETMethod(true);
	    }else {
		api.setEnableGETMethod(false);
	    }
	    
	    if(Constant.HTTPMETHOD_PUT.equalsIgnoreCase(httpMethods[i])) {
		api.setEnablePUTMethod(true);
	    }else {
		api.setEnablePUTMethod(false);
	    }
	    
	    if(Constant.HTTPMETHOD_POST.equalsIgnoreCase(httpMethods[i])) {
		api.setEnablePOSTMethod(true);
	    }else {
		api.setEnablePOSTMethod(false);
	    }
	    
	    if(Constant.HTTPMETHOD_DELETE.equalsIgnoreCase(httpMethods[i])) {
		api.setEnableDELETEMethod(true);
	    }else {
		api.setEnableDELETEMethod(false);
	    }
	    
	}
	
	api.setOauthGroups(form.getOauthGroups());
	
	String[] bufferSettings = form.getEnableBufferOn();
	for(int i=0; i< bufferSettings.length; i++) {
	    
	    if(Constant.HTTP_REQUEST.equals(bufferSettings[i])) {
		api.setEnableRequestBuffering(true);
	    }else {
		api.setEnableRequestBuffering(false);
	    }
	    
	    if(Constant.HTTP_RESPONSE.equals(bufferSettings[i])) {
		api.setEnableReponseBuffering(true);
	    }else {
		api.setEnableReponseBuffering(false);
	    }
	    
	}
	
	String[] logSettings = form.getEnableBufferOn();
	for(int i=0; i< logSettings.length; i++) {
	    
	    if(Constant.HTTP_REQUEST.equals(logSettings[i])) {
		api.setEnableRequestLog(true);
	    }else {
		api.setEnableRequestLog(false);
	    }
	    
	    if(Constant.HTTP_RESPONSE.equals(logSettings[i])) {
		api.setEnableResponseLog(true);
	    }else {
		api.setEnableResponseLog(false);
	    }
	    
	}
	
	api.setSpecURL(form.getSpecURL());
	api.setRateLimit(form.getRateLimit());
	api.setTimeout(form.getTimeout());
	api.setTargetCredential(form.getTargetCredential());
	api.setAllowedContextPaths(form.getAllowedContextPaths());
	api.setBlockedContextPaths(form.getBlockedContextPaths());
	api.setIpWhiteList(form.getIpWhiteList());
	api.setConsumerShortTeamNames(form.getConsumerShortTeamNames());
	api.setAppCodeRepoName(form.getAppCodeRepoName());
	api.setStatus(Constant.API_STATUS_WAITING_FOR_APPROVAL);

	Authentication authContext = SecurityContextHolder.getContext().getAuthentication(); 
	api.setCreatedBy(authContext.getName());
	api.setCreateDateTime(new Date());
	
	return api;
    }

}

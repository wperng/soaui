package com.sandp.ratings.soa.kongtool.yaml.manager;

import java.util.ArrayList;
import java.util.List;

import com.sandp.ratings.soa.kongtool.entity.API;
import com.sandp.ratings.soa.kongtool.util.StringUtil;
import com.sandp.ratings.soa.kongtool.yaml.KongPluginSection;


public class KongPluginSectionManager {
    
    public static List<KongPluginSection> getKongPluginSections(API api) {
	
	ArrayList<KongPluginSection> KongPluginSections = new ArrayList<KongPluginSection>();
	
	KongPluginSections.add(KongPluginHelper.getKeyAuthPlugin(api.getApiName(), api.getHttpProtocol(), false));
	
	if(api.isEnableOPTIONSMethod()) {
	    KongPluginSections.add(KongPluginHelper.getKeyAuthPlugin(api.getApiName(), api.getHttpProtocol(), true));
	}
	
	KongPluginSections.add(KongPluginHelper.getACLPluginSection(api.getApiName(), api.getHttpProtocol()));
	KongPluginSections.add(KongPluginHelper.getSPGGetLogRequestPayloadPluginSection(api.getApiName(), api.getHttpProtocol()));
	KongPluginSections.add(KongPluginHelper.getSPGGetLogResponsePayloadPluginSection(api.getApiName(), api.getHttpProtocol()));
	
	if(!StringUtil.isEmpty(api.getIpWhiteList())) 
	    KongPluginSections.add(KongPluginHelper.getIPRestrictionPluginSection(api.getApiName(), api.getHttpProtocol()));
	
	if(!StringUtil.isEmpty(api.getAllowedContextPaths()))
	    KongPluginSections.add(KongPluginHelper.getAllowedURLPluginSection(api.getApiName(), api.getHttpProtocol()));
	
	if(!StringUtil.isEmpty(api.getBlockedContextPaths()))
	    KongPluginSections.add(KongPluginHelper.getRestrictURLPluginSection(api.getApiName(), api.getHttpProtocol()));
	
	if(!StringUtil.isEmpty(api.getTargetCredential()))
	    KongPluginSections.add(KongPluginHelper.getInjectBasicAuthPluginSection(api.getApiName(), api.getHttpProtocol()));
	
	if(api.getRateLimit() > 0)
	    KongPluginSections.add(KongPluginHelper.getRateLimitingPluginSection(api.getApiName(), api.getHttpProtocol()));
	
	     
	if(api.isBasicAuth()) {
	    KongPluginSections.add(KongPluginHelper.getBasicAuthPluginSection(api.getApiName(), api.getHttpProtocol()));
	}
	    
	if(api.isOAUTHAuth()) {
	    KongPluginSections.add(KongPluginHelper.getSPGOauthValidatorPluginSection(api.getApiName(), api.getHttpProtocol()));
	}
	    
	if(api.isSNLJWTAuth()) {
	    KongPluginSections.add(KongPluginHelper.getSPGSNLJWTValidatorPluginSection(api.getApiName(), api.getHttpProtocol()));
	}

        if(api.isLDAPAuth()) {
    		KongPluginSections.add(KongPluginHelper.getLDAPAuthPluginSection(api.getApiName(), api.getHttpProtocol()));
        }
	   
	
	return KongPluginSections;
    }
    
   
}

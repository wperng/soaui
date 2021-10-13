package com.sandp.ratings.soa.kongtool.service;

import java.io.File;
import java.net.MalformedURLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.sandp.ratings.soa.kongtool.entity.API;
import com.sandp.ratings.soa.kongtool.util.URLUtil;


@Service
public class KongDeploymentDataFileService {
    
    public static Map<String, Object> getDataFileService(API api) {
	
	Map<String, Object> dataFileMap = new LinkedHashMap<String, Object>();
	Map<String, Object> general = new LinkedHashMap<String, Object>();
	Map<String, Object> upstreamInfo = new LinkedHashMap<String, Object>();
	dataFileMap.put("general", general);
	general.put("upstreamInfo", upstreamInfo);
	
	try {
	    upstreamInfo.put("protocol", URLUtil.getProtocol(api.getTargetURL()));
	    upstreamInfo.put("domainName", URLUtil.getDomainName(api.getTargetURL()));
	    upstreamInfo.put("port", URLUtil.getPort(api.getTargetURL()));
	    upstreamInfo.put("basePath", URLUtil.getPath(api.getTargetURL()));
	} catch (MalformedURLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	upstreamInfo.put("supportedProtocolExceptOption", "GET");
	if(api.isEnableOPTIONSMethod() && Constant.HTTPPOTOCOL_REST.equalsIgnoreCase(api.getHttpProtocol()))   
	    upstreamInfo.put("supportOptions", true);
	else
	    upstreamInfo.put("supportOptions", false);
	
	if(api.isEnableRequestBuffering())
	    upstreamInfo.put("request_buffering", true);
	
	if(api.isEnableReponseBuffering())
	    upstreamInfo.put("response_buffering", true);
	
	Map<String, Object> kongplugin = new LinkedHashMap<String, Object>();
	dataFileMap.put("kongplugin", kongplugin);
	
	if(api.getRateLimit() != -1) {
	    Map<String, Object> rate_limiting_advanced = new LinkedHashMap<String, Object>();
	    Map<String, Object> config = new LinkedHashMap<String, Object>();
	    rate_limiting_advanced.put("config", config);
	    long[] limit = new long[] {api.getRateLimit()};
	    config.put("limit", limit);
	    kongplugin.put("rate_limiting_advanced", rate_limiting_advanced);
	}
	
	Map<String, Object> acl = new LinkedHashMap<String, Object>();
	Map<String, Object> config = new LinkedHashMap<String, Object>();
	acl.put("config", config);
	String[] allow = new String[] {"APIM", "CE"};
	config.put("allow", allow);
	kongplugin.put("acl", acl);
	
	if(api.isOAUTHAuth()) {
	    
	}
	
	if(api.isSNLJWTAuth()) {
	    
	}
	
	// if()
	
	
	
	return dataFileMap; 
    }
    
    public static void main(String[] args) throws Exception {
	
	API api = new API();
	api.setTargetURL("https://actrss-analyticsecurityweb-rest-prod.faas.pde.spratingsvpc.com/test/123");
	api.setHttpProtocol(Constant.HTTPPOTOCOL_REST);
	api.setEnableOPTIONSMethod(true);
	api.setEnablePOSTMethod(true);
	api.setEnableReponseBuffering(true);
	api.setRateLimit(200);
	
	ObjectMapper om = new ObjectMapper(new YAMLFactory());
	om.writeValue(new File("src/main/resources/orderOutput.yaml"), KongDeploymentDataFileService.getDataFileService(api));
	
    }
}

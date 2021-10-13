package com.sandp.ratings.soa.kongtool.yaml.manager;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.sandp.ratings.soa.kongtool.entity.API;
import com.sandp.ratings.soa.kongtool.service.Constant;
import com.sandp.ratings.soa.kongtool.util.StringUtil;
import com.sandp.ratings.soa.kongtool.yaml.Backend;
import com.sandp.ratings.soa.kongtool.yaml.HTTP;
import com.sandp.ratings.soa.kongtool.yaml.IngressSection;
import com.sandp.ratings.soa.kongtool.yaml.Metadata;
import com.sandp.ratings.soa.kongtool.yaml.Path;
import com.sandp.ratings.soa.kongtool.yaml.Rule;
import com.sandp.ratings.soa.kongtool.yaml.Spec;

public class IngressSectionManager {
    
    public static List<IngressSection> getIngressSection(API api) {

	ArrayList<IngressSection> ingressSections = new ArrayList<IngressSection>();
	
	for(int i=0; i<Constant.ALL_AUTHENTICATIONS.length; i++) {
	    
	    String auth = Constant.ALL_AUTHENTICATIONS[i];
	    if(auth.equals(Constant.AUTHENTICATION_DEFAULT) && !api.isDefaultAuth()) 
		continue;
	    
	    if(auth.equals(Constant.AUTHENTICATION_BASIC) && !api.isDefaultAuth()) 
		continue;
	    
	    if(auth.equals(Constant.AUTHENTICATION_SNLJWT) && !api.isDefaultAuth()) 
		continue;
	    
	    if(auth.equals(Constant.AUTHENTICATION_OAUTH) && !api.isDefaultAuth()) 
		continue;
	    
	    if(auth.equals(Constant.AUTHENTICATION_LDAP) && !api.isDefaultAuth()) 
		continue;
	   
	    if(auth.equals(Constant.AUTHENTICATION_OAM) && !api.isDefaultAuth()) 
		continue;
	    
	    IngressSection ingressSectionForAuth = new IngressSection();
	    Metadata metadata = new Metadata();
	    metadata.setName(api.getApiName() + "-default");
	    LinkedHashMap<String, String> annotations = new LinkedHashMap<String, String>();
	    annotations.put("kubernetes.io/ingress.class", "{{ TODO_PIPELINE_WORKSPACE_NAME }}");
	    annotations.put("konghq.com/override",         api.getApiName() + "-config");
	    annotations.put("konghq.com/preserve-host",    "false");
	    if(Constant.HTTPPOTOCOL_REST.equalsIgnoreCase(api.getHttpProtocol()))
		 annotations.put("konghq.com/methods",     "{{ TODO_SERVICE_SUPPORTED_PROTOCOLS_EXCEPT_OPTIONS }}");
	    else
		 annotations.put("konghq.com/methods",     "POST");
	   
	    annotations.put("konghq.com/host-aliases",     "{{ TODO_MASTER_KONG_DOMAIN_ALIAS }}");
	    
	    StringBuffer sb = new StringBuffer();
	    sb.append(api.getApiName() + "-spg-log-request-payload");
	    
	    if(Constant.AUTHENTICATION_BASIC.equals(auth))
		sb.append("," + api.getApiName() + "-basic-auth");
	    else if(Constant.AUTHENTICATION_OAUTH.equals(auth))
		sb.append("," + api.getApiName() + "-spg-oauth-validator");
	    else if(Constant.AUTHENTICATION_LDAP.equals(auth))
		sb.append("," + api.getApiName() + "-ldap-auth-advanced");
	    else if(Constant.AUTHENTICATION_SNLJWT.equals(auth))
        	sb.append("," + api.getApiName() + "-spg-snljwt-validator");
		// not sure why SOAP does not have rate limiting. 
	    if(Constant.HTTPPOTOCOL_REST.equalsIgnoreCase(api.getHttpProtocol())) {
		if(api.getRateLimit() == -1) 
		    sb.append("," + api.getApiName() + "-rate-limiting-advanced");
	    }
	    
	    sb.append("," + api.getApiName() + "-key-auth");
	    sb.append("," + api.getApiName() + "-acl");
	    
	    if(Constant.HTTPPOTOCOL_REST.equalsIgnoreCase(api.getHttpProtocol())) {
		if(!StringUtil.isEmpty(api.getBlockedContextPaths()))
		    sb.append("," + api.getApiName() + "-restrict-urls");
	    
		if(!StringUtil.isEmpty(api.getAllowedContextPaths()))
		    sb.append("," + api.getApiName() + "-allow-urls");
	    
		if(!StringUtil.isEmpty(api.getTargetCredential()))
		    sb.append("," + api.getApiName() + "-spg-inject-basic-credentials");
	    
		if(!StringUtil.isEmpty(api.getIpWhiteList()))
		    sb.append("," + api.getApiName() + "-ip-restriction");
	    }
	    sb.append("," + api.getApiName() + "-spg-log-response-payload");
	    annotations.put("konghq.com/plugins",  sb.toString());
	    
	    metadata.setAnnotations(annotations);
	    ingressSectionForAuth.setMetadata(metadata);
	    
	    Backend backend = new Backend();
	    backend.setServiceName(api.getApiName());
	    backend.setServicePort("{{TODO_PROVIDER_URL_PORT}}");
	    
	    Path[] paths = new Path[1];
	    Path path = new Path();
	    
	    String routePath = "";
	    if(Constant.AUTHENTICATION_BASIC.equals(auth))
		routePath = "/" + api.getApiName() + "-basic-auth";
	    else if(Constant.AUTHENTICATION_OAUTH.equals(auth))
		routePath = "/" + api.getApiName() + "-spg-oauth-validator";
	    else if(Constant.AUTHENTICATION_LDAP.equals(auth))
		routePath = "/" + api.getApiName() + "-ldap-auth-advanced";
	    else if(Constant.AUTHENTICATION_SNLJWT.equals(auth))
		routePath = "/" + api.getApiName() + "-spg-snljwt-validator";
	    else if(Constant.AUTHENTICATION_DEFAULT.equals(auth))
		routePath = "/" + api.getApiName() + "-default";
	    
	    path.setPath(routePath);
	    path.setBackend(backend);
	    
	    HTTP http = new HTTP();
	    http.setPaths(paths);
	    
	    Rule rule = new Rule();
	    rule.setHost("{{TODO_MASTER_KONG_DOMAIN}}");
	    rule.setHTTP(http);
	    
	    Spec spec = new Spec();
	    spec.setRules(new Rule[] { rule });
	    
	    ingressSections.add(ingressSectionForAuth);
	}
	
	if(api.isEnableOPTIONSMethod()) {
	    IngressSection ingressSectionForOptions = new IngressSection();
	    Metadata metadata = new Metadata();
	    if(Constant.HTTPPOTOCOL_REST.equalsIgnoreCase(api.getHttpProtocol())) 
		metadata.setName(api.getApiName() + "-options");
	    else
		metadata.setName(api.getApiName() + "-getoptions");
	    LinkedHashMap<String, String> annotations = new LinkedHashMap<String, String>();
	    annotations.put("kubernetes.io/ingress.class", "{{ TODO_PIPELINE_WORKSPACE_NAME }}");
	    annotations.put("konghq.com/override",         api.getApiName() + "-config");
	    annotations.put("konghq.com/preserve-host",    "false");
	    if(Constant.HTTPPOTOCOL_REST.equalsIgnoreCase(api.getHttpProtocol())) 
		annotations.put("konghq.com/methods",      "OPTIONS");
	    else
		annotations.put("konghq.com/methods",      "GET,OPTIONS");
	    annotations.put("konghq.com/host-aliases",     "{{ TODO_MASTER_KONG_DOMAIN_ALIAS }}");
	    
	    StringBuffer sb = new StringBuffer();
	    sb.append(api.getApiName() + "-spg-log-request-payload");
	    if(Constant.HTTPPOTOCOL_REST.equalsIgnoreCase(api.getHttpProtocol()))
		sb.append("," + api.getApiName() + "-key-auth-options");
	    else
		sb.append("," + api.getApiName() + "-key-auth");
	    sb.append("," + api.getApiName() + "-acl");
	    
	    if(Constant.HTTPPOTOCOL_REST.equalsIgnoreCase(api.getHttpProtocol())) {
		if(!StringUtil.isEmpty(api.getBlockedContextPaths()))
    		    sb.append("," + api.getApiName() + "-restrict-urls");
    	    
    	    	if(!StringUtil.isEmpty(api.getAllowedContextPaths()))
    	    	    sb.append("," + api.getApiName() + "-allow-urls");
    	    
    	    	if(!StringUtil.isEmpty(api.getTargetCredential()))
    	    	    sb.append("," + api.getApiName() + "-spg-inject-basic-credentials");
    	    
    	    	if(!StringUtil.isEmpty(api.getIpWhiteList()))
    	    	    sb.append("," + api.getApiName() + "-ip-restriction");
	    } 
	    sb.append("," + api.getApiName() + "-spg-log-response-payload");
	    annotations.put("konghq.com/plugins",  sb.toString());
	    
	    metadata.setAnnotations(annotations);
	    ingressSectionForOptions.setMetadata(metadata);
	    
	    Backend backend = new Backend();
	    backend.setServiceName(api.getApiName());
	    backend.setServicePort("{{TODO_PROVIDER_URL_PORT}}");
	    
	    HTTP http = new HTTP();
	    Rule rule = new Rule();
	    rule.setHost("{{TODO_MASTER_KONG_DOMAIN}}");
	    rule.setHTTP(http);
	    
	    List<Path> pathList = new ArrayList<Path>();
	    for(int i=0; i<Constant.ALL_AUTHENTICATIONS.length; i++) {
		 String auth = Constant.ALL_AUTHENTICATIONS[i];
		 if(auth.equals(Constant.AUTHENTICATION_DEFAULT) && !api.isDefaultAuth()) 
		     continue;
		    
		 if(auth.equals(Constant.AUTHENTICATION_BASIC) && !api.isDefaultAuth()) 
		     continue;
		    
		 if(auth.equals(Constant.AUTHENTICATION_SNLJWT) && !api.isDefaultAuth()) 
		     continue;
		    
		 if(auth.equals(Constant.AUTHENTICATION_OAUTH) && !api.isDefaultAuth()) 
		     continue;
		    
		 if(auth.equals(Constant.AUTHENTICATION_LDAP) && !api.isDefaultAuth()) 
		     continue;
		   
		 if(auth.equals(Constant.AUTHENTICATION_OAM) && !api.isDefaultAuth()) 
		     continue;
		 
		 Path path = new Path();
		 if(Constant.AUTHENTICATION_BASIC.equals(auth))
		     path.setPath("/" + api.getApiName() + "/basic");
		 if(Constant.AUTHENTICATION_OAUTH.equals(auth))
		     path.setPath("/" + api.getApiName() + "/oauth");
		 if(Constant.AUTHENTICATION_LDAP.equals(auth))
		     path.setPath("/" + api.getApiName() + "/ldap");
		 if(Constant.AUTHENTICATION_SNLJWT.equals(auth))
		     path.setPath("/" + api.getApiName() + "/snljwt");
		 if(Constant.AUTHENTICATION_DEFAULT.equals(auth))
		     path.setPath("/" + api.getApiName() + "/default");
		 pathList.add(path);
		 http.setPaths(pathList.toArray(new Path[0]));
	    }
	    
	    Spec spec = new Spec();
	    spec.setRules(new Rule[] { rule });
	    
	    ingressSections.add(ingressSectionForOptions);
	}
	

	return ingressSections;
    }
    
   

}

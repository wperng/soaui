package com.sandp.ratings.soa.kongtool.service;

public class Constant {
    
    public static final String HTTP_REQUEST = "REQUEST";
    public static final String HTTP_RESPONSE = "RESPONSE";
    
    public static final String HTTPPOTOCOL_REST = "REST";
    public static final String HTTPPOTOCOL_SOAP = "SOAP";
    
    public static final String APIZONE_INTERNAL = "INTERNAL";
    public static final String APIZONE_DMZ      = "DMZ";
    public static final String APIZONE_EXTERNAL = "EXTERNAL";
    
    public static final String HTTPMETHOD_PUT = "PUT";
    public static final String HTTPMETHOD_POST = "POST";
    public static final String HTTPMETHOD_GET = "GET";
    public static final String HTTPMETHOD_DELETE = "DELETE";
    public static final String HTTPMETHOD_OPTIONS = "OPTIONS";
    
    public static final String ENVIRONMENT_DEV       = "DEV";
    public static final String ENVIRONMENT_SI        = "SI";
    public static final String ENVIRONMENT_QA        = "QA";
    public static final String ENVIRONMENT_HF        = "UAT";
    public static final String ENVIRONMENT_PROD      = "PROD";
    public static final String ENVIRONMENT_DR        = "DR";
    public static final String ENVIRONMENT_DMZALPHA  = "DMZALPHA";
    public static final String ENVIRONMENT_DMZPROD   = "DMZPROD";
    public static final String ENVIRONMENT_DMZDR     = "DMZDR";
    
    public static final String API_STATUS_READY                = "READY";
    public static final String API_STATUS_WAITING_FOR_APPROVAL = "WAITING_FOR_APPROVAL";
    public static final String API_STATUS_DEPLOYED_TO_DEV      = "DEPLOYED_TO_DEV";
    public static final String API_STATUS_REQUESTED_TO_MERGE   = "REQUESTED_TO_MERGE";
    public static final String API_STATUS_MERGED_TO_KONGMAIN   = "MERGED_TO_KONGMAIN";
    public static final String API_STATUS_UNKNOWN              = "UNKNOWN";

    
    
    public static final String AUTHENTICATION_DEFAULT = "DEFAULT";
    public static final String AUTHENTICATION_BASIC = "BASIC";
    public static final String AUTHENTICATION_OAUTH = "OAUTH";
    public static final String AUTHENTICATION_SNLJWT = "SNLJWT";
    public static final String AUTHENTICATION_LDAP = "LDAP";
    public static final String AUTHENTICATION_OAM = "OAM";
    
    public static final String K8S_KONGINGRESS_APIVERSION_V1 = "configuration.konghq.com/v1";
    public static final String K8S_KONGPLUGIN_APIVERSION_V1 = "configuration.konghq.com/v1";
    public static final String K8S_SERVICE_APIVERSION_V1 = "v1";
    public static final String K8S_INGRESS_APIVERSION_V1 = "extensions/v1beta1";
    
    public static final String K8S_KIND_KONGINGRESS = "KongIngress";
    public static final String K8S_KIND_KONGPLUGIN = "KongPlugin";
    public static final String K8S_KIND_SERVICE = "Service";
    public static final String K8S_KIND_INGRESS = "Ingress";
    
    public static final String K8S_PLUGIN_NAME_KEYAUTH = "key-auth";
    public static final String K8S_PLUGIN_NAME_ACL = "acl";
    public static final String K8S_PLUGIN_NAME_IP_RESTRICTION = "ip-restriction";
    public static final String K8S_PLUGIN_NAME_RESTRICT_URLS = "restrict-urls";
    public static final String K8S_PLUGIN_NAME_ALLOW_URLS = "allow-urls";
    public static final String K8S_PLUGIN_NAME_INJECT_BASIC_CREDENTIALS = "spg-inject-basic-credentials";
    public static final String K8S_PLUGIN_NAME_RATE_LIMITING = "rate-limiting-advanced";
    
    public static final String K8S_PLUGIN_NAME_SPG_OAUTH_VALIDATOR      = "spg-oauth-validator";
    public static final String K8S_PLUGIN_NAME_SPG_SNLJWT_VALATOR       = "spg-snljwt-validator";
    public static final String K8S_PLUGIN_NAME_LDAP_AUTH_ADVANCED       = "ldap-auth-advanced";
    public static final String K8S_PLUGIN_NAME_BASIC_AUTH               = "basic-auth";
    public static final String K8S_PLUGIN_NAME_OAM_AUTH                 = "spg-oam-validator";
    public static final String K8S_PLUGIN_NAME_SPG_LOG_REQUEST_PAYLOAD  = "spg-log-request-payload";
    public static final String K8S_PLUGIN_NAME_SPG_LOG_RESPONSE_PAYLOAD = "spg-log-response-payload";
    
    public static final String[] ALL_AUTHENTICATIONS = new String[]{Constant.AUTHENTICATION_DEFAULT, Constant.AUTHENTICATION_BASIC, Constant.AUTHENTICATION_LDAP
	    , Constant.AUTHENTICATION_OAUTH, Constant.AUTHENTICATION_SNLJWT, Constant.AUTHENTICATION_OAM};

    
    /*
    public static final String K8S_PLUGIN_METADATA_NAME_KEYAUTH_NONOPTIONS_EXT = "-key-auth";
    public static final String K8S_PLUGIN_METADATA_NAME_KEYAUTH_OPTIONS_EXT = "-key-auth-options";
    public static final String K8S_PLUGIN_METADATA_NAME_ACL_EXT = "-acl";
    public static final String K8S_PLUGIN_METADATA_NAME_IPRESTRICTION_EXT = "-ip-restriction";
    public static final String K8S_PLUGIN_METADATA_NAME_RESTRICTEDURL_EXT = "-restrict-urls";
    public static final String K8S_PLUGIN_METADATA_NAME_ALLOWEDURL_EXT = "-allow-urls";
    public static final String K8S_PLUGIN_METADATA_NAME_INJECT_BASIC_CREDENTIALS_EXT = "-spg-inject-basic-credentials";
    public static final String K8S_PLUGIN_METADATA_NAME_RATELIMITING_EXT = "-rate-limiting-advanced";
    */	

   
    
    

}

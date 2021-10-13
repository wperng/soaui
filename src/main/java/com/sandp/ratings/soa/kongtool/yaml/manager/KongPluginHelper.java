package com.sandp.ratings.soa.kongtool.yaml.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sandp.ratings.soa.kongtool.service.Constant;
import com.sandp.ratings.soa.kongtool.yaml.KongPluginSection;
import com.sandp.ratings.soa.kongtool.yaml.Metadata;

public class KongPluginHelper {
    
    public static KongPluginSection getKeyAuthPlugin(String apiName, String httpProtocol, boolean isOptions) {
	
	KongPluginSection keyAuthSection = new KongPluginSection();
	Metadata metadata = new Metadata();
	if(isOptions)
	    metadata.setName(apiName + "-" + Constant.K8S_PLUGIN_NAME_KEYAUTH + "-options");
	else
	    metadata.setName(apiName + "-" + Constant.K8S_PLUGIN_NAME_KEYAUTH);
	
	keyAuthSection.setMetadata(metadata);
	keyAuthSection.setDisabled(false);
	Map<String, Object> config = new HashMap<String, Object>();
	List<String> key_names = new ArrayList<String>();
	key_names.add("apikey");
	config.put("key_names", key_names);
	config.put("hide_credentials", "{{ TODO_KEY_AUTH_HIDE_CREDENTIALS | default(true, true)}}");
	if(isOptions)
	    config.put("run_on_preflight", "true");
	else
	    config.put("run_on_preflight", "false");
	config.put("key_in_header", "true");
	config.put("key_in_query","true");
	keyAuthSection.setConfig(config);
	keyAuthSection.setPlugin(Constant.K8S_PLUGIN_NAME_KEYAUTH);
	
	return keyAuthSection;
	
    }
    
    public static KongPluginSection getACLPluginSection(String apiName, String httpProtocol) {
	KongPluginSection ipRestrictionPluginSection = new KongPluginSection();
	Metadata metadata = new Metadata();
	metadata.setName(apiName + "-" + Constant.K8S_PLUGIN_NAME_ACL);
	ipRestrictionPluginSection.setMetadata(metadata);
	ipRestrictionPluginSection.setDisabled(false);
	Map<String, Object> config = new HashMap<String, Object>();
	config.put("allow", "{{TODO_ACL_GROUPNAMES}}");
	ipRestrictionPluginSection.setConfig(config);
	ipRestrictionPluginSection.setPlugin(Constant.K8S_PLUGIN_NAME_ACL);
	
	return ipRestrictionPluginSection;
    }
    
    public static KongPluginSection getIPRestrictionPluginSection(String apiName, String httpProtocol) {
	
	KongPluginSection ipRestrictionPluginSection = new KongPluginSection();
	Metadata metadata = new Metadata();
	metadata.setName(apiName + "-" + Constant.K8S_PLUGIN_NAME_IP_RESTRICTION);
	ipRestrictionPluginSection.setMetadata(metadata);
	ipRestrictionPluginSection.setDisabled(false);
	Map<String, Object> config = new HashMap<String, Object>();
	config.put("allow", "{{TODO_IP_RESTRICTION_ALLOW_LIST}}");
	ipRestrictionPluginSection.setConfig(config);
	ipRestrictionPluginSection.setPlugin(Constant.K8S_PLUGIN_NAME_IP_RESTRICTION);
	
	return ipRestrictionPluginSection;
    }
    
    public static KongPluginSection getAllowedURLPluginSection(String apiName, String httpProtocol) {
	
	KongPluginSection ipRestrictionPluginSection = new KongPluginSection();
	Metadata metadata = new Metadata();
	metadata.setName(apiName + "-" + Constant.K8S_PLUGIN_NAME_ALLOW_URLS);
	ipRestrictionPluginSection.setMetadata(metadata);
	ipRestrictionPluginSection.setDisabled(false);
	Map<String, Object> config = new HashMap<String, Object>();
	config.put("context_path", "{{TODO_ALLOW_URLS}}");
	ipRestrictionPluginSection.setConfig(config);
	ipRestrictionPluginSection.setPlugin(Constant.K8S_PLUGIN_NAME_ALLOW_URLS);
	
	return ipRestrictionPluginSection;
    }
    
    public static KongPluginSection getRestrictURLPluginSection(String apiName, String httpProtocol) {
	
	KongPluginSection ipRestrictionPluginSection = new KongPluginSection();
	Metadata metadata = new Metadata();
	metadata.setName(apiName + "-" + Constant.K8S_PLUGIN_NAME_RESTRICT_URLS);
	ipRestrictionPluginSection.setMetadata(metadata);
	ipRestrictionPluginSection.setDisabled(false);
	Map<String, Object> config = new HashMap<String, Object>();
	config.put("context_path", "{{TODO_RESTRICT_URLS}}");
	ipRestrictionPluginSection.setConfig(config);
	ipRestrictionPluginSection.setPlugin(Constant.K8S_PLUGIN_NAME_RESTRICT_URLS);
	
	return ipRestrictionPluginSection;
    }
    
    public static KongPluginSection getInjectBasicAuthPluginSection(String apiName, String httpProtocol) {
	
	KongPluginSection basicAuthPluginSection = new KongPluginSection();
	Metadata metadata = new Metadata();
	metadata.setName(apiName + "-" + Constant.K8S_PLUGIN_NAME_INJECT_BASIC_CREDENTIALS);
	basicAuthPluginSection.setMetadata(metadata);
	basicAuthPluginSection.setDisabled(false);
	Map<String, Object> config = new HashMap<String, Object>();
	config.put("service_provider_basic_credentials", "{{TODO_SHELF_SERVICE_PROVIDER_BASIC_CREDENTIALS}}");
	basicAuthPluginSection.setConfig(config);
	basicAuthPluginSection.setPlugin(Constant.K8S_PLUGIN_NAME_INJECT_BASIC_CREDENTIALS);
	
	return basicAuthPluginSection;
    }
    
    public static KongPluginSection getRateLimitingPluginSection(String apiName, String httpProtocol) {
	
	KongPluginSection rateLimitingPluginSection = new KongPluginSection();
	Metadata metadata = new Metadata();
	metadata.setName(apiName + "-" + Constant.K8S_PLUGIN_NAME_RATE_LIMITING);
	rateLimitingPluginSection.setMetadata(metadata);
	rateLimitingPluginSection.setDisabled(false);
	Map<String, Object> config = new HashMap<String, Object>();
	config.put("identifier", "{{TODO_RATELIMIT_IDENTIFIER|default('consumer', true)}}");
	config.put("strategy", "{{ TODO_MASTER_RATELIMIT_STRATEGY }}");
	Map<String, Object> redis = new HashMap<String, Object>();
	redis.put("cluster_addresses", new String[] {"{{TODO_MASTER_RATELIMIT_REDIS_CLUSTER_ADDRESS}}"});	
	redis.put("password", "{{TODO_MASTER_RATELIMIT_REDIS_PASSOWRD}}");
	redis.put("timeout", "{{TODO_MASTER_RATELIMIT_TIMEOUT}}");
	redis.put("database", "{{TODO_MASTER_RATELIMIT_DATABASE}}");
	redis.put("ssl", "{{TODO_MASTER_RATELIMIT_ENABLE_SSL}}");
	redis.put("ssl_verify", "false");
	config.put("redis", redis);
	config.put("limit", new String[] {"{{TODO_RATELIMIT_LIMIT|default(300, true)}}"});
	config.put("window_size", new int[] {60});
	config.put("window_type", "{{TODO_RATELIMIT_TYPE|default('sliding', true)}}");
	config.put("sync_rate", "{{TODO_MASTER_RATELIMIT_SYNC_RATE}}");
	config.put("namespace", "random_auto_generated_string");
	rateLimitingPluginSection.setConfig(config);
	rateLimitingPluginSection.setPlugin(Constant.K8S_PLUGIN_NAME_RATE_LIMITING);
	
	return rateLimitingPluginSection;
    }
    
    public static KongPluginSection getSPGOauthValidatorPluginSection(String apiName, String httpProtocol) {
	
	KongPluginSection spgOauthValidatorPluginSection = new KongPluginSection();
	Metadata metadata = new Metadata();
	metadata.setName(apiName + "-" + Constant.K8S_PLUGIN_NAME_SPG_OAUTH_VALIDATOR);
	spgOauthValidatorPluginSection.setMetadata(metadata);
	spgOauthValidatorPluginSection.setDisabled(false);
	Map<String, Object> config = new HashMap<String, Object>();
	config.put("oauth_validation_port", 443);
	config.put("oauth_validation_protocol", "https");
	config.put("oauth_validation_url_path", "{{ TODO_OAUTH_VALIDATION_URL_PATH | default('/oauth2/rest/token/info', true) }}");
	config.put("identity_domain_header_name", "X-OAUTH-IDENTITY-DOMAIN-NAME");
	config.put("identity_domain_header_value", "{{ TODO_OAUTH_DOMAIN_NAME|default('RatingsDomain', true) }}");
	config.put("allowed_ldap_groups", "{{ TODO_OAUTH_LDAP_GROUPS }}");
	config.put("allowed_spapp_groups", "{{ TODO_OAUTH_SPAPP_GROUPS }}");
	config.put("allowed_scopes","{{ TODO_OAUTH_SCOPES }}");
	config.put("mandate_all_authorizations", "{{ TODO_OAUTH_MANDATE_ALL_AUTHORIZATIONS|default(false, true) }}");
	config.put("remove_authz_header_after_validation", "{{ TODO_OAUTH_REMOVE_AUTH_HEADER_FLAG|default(true, true) }}");
	config.put("populate_user_name", "{{ TODO_OAUTH_POPULATE_USER_NAME|default(true, true) }}");
	config.put("populate_user_profile", "{{ TODO_OAUTH_POPULATE_USER_PROFILE|default(false, true) }}");
	config.put("populate_spapp_groups", "{{ TODO_OAUTH_POPULATE_SPAPP_GROUPS|default(false, true) }}");
	config.put("run_on_preflight", "{{ TODO_OAUTH_RUN_ON_PREFLIGHT|default(false, true) }}");
	spgOauthValidatorPluginSection.setConfig(config);
	spgOauthValidatorPluginSection.setPlugin(Constant.K8S_PLUGIN_NAME_SPG_OAUTH_VALIDATOR);
	
	return spgOauthValidatorPluginSection;
	
    }
    
    public static KongPluginSection getSPGSNLJWTValidatorPluginSection(String apiName, String httpProtocol) {
	
	KongPluginSection spgSNLJWTValidatorPluginSection = new KongPluginSection();
	Metadata metadata = new Metadata();
	metadata.setName(apiName + "-" + Constant.K8S_PLUGIN_NAME_SPG_SNLJWT_VALATOR);
	spgSNLJWTValidatorPluginSection.setMetadata(metadata);
	spgSNLJWTValidatorPluginSection.setDisabled(false);
	Map<String, Object> config = new HashMap<String, Object>();
	config.put("snljwt_validation_host", "{{ TODO_MASTER_SNLJWT_HOST }}");
	config.put("snljwt_validation_port", 443);
	config.put("snljwt_validation_protocol", "https");
	config.put("snljwt_validation_url_path", "{{ TODO_MASTER_SNLJWT_URL_PATH }}");
	config.put("identity_domain_header_name", "{{ TODO_MASTER_SNLJWT_RUN_ON_PREFLIGHT|default(false, true) }}");
	config.put("snljwt_remove_authz_header_after_validation", false);
	spgSNLJWTValidatorPluginSection.setConfig(config);
	spgSNLJWTValidatorPluginSection.setPlugin(Constant.K8S_PLUGIN_NAME_SPG_SNLJWT_VALATOR);
	
	return spgSNLJWTValidatorPluginSection;
	
    }
    
    public static KongPluginSection getLDAPAuthPluginSection(String apiName, String httpProtocol) {
	
   	KongPluginSection ldapAuthPluginSection = new KongPluginSection();
   	
   	Metadata metadata = new Metadata();
	metadata.setName(apiName + "-" + Constant.K8S_PLUGIN_NAME_LDAP_AUTH_ADVANCED);
	ldapAuthPluginSection.setMetadata(metadata);
	ldapAuthPluginSection.setDisabled(false);
	Map<String, Object> config = new HashMap<String, Object>();
	config.put("hide_credentials", "{{TODO_LDAP_HIDE_CREDENTIALS|default(true, true)}}");
	config.put("ldap_host", "{{TODO_MASTER_LDAP_HOST}}");
	config.put("ldap_port", "{{TODO_MASTER_LDAP_PORT|default(1636, true)}}");
	config.put("start_tls", false);
	config.put("ldaps", true);
	config.put("base_dn", "{{TODO_MASTER_LDAP_BASE_DN|default('ou=internal,ou=people,dc=spg,dc=com', true)}}");
	config.put("verify_ldap_host", false);
	config.put("attribute", "uid");
	config.put("cache_ttl", "{{TODO_MASTER_LDAP_CACHE_TTL}}");
	config.put("header_type", "basic");
	ldapAuthPluginSection.setConfig(config);
	ldapAuthPluginSection.setPlugin(Constant.K8S_PLUGIN_NAME_LDAP_AUTH_ADVANCED);
	
   	return ldapAuthPluginSection;
   	
    }
    
    public static KongPluginSection getBasicAuthPluginSection(String apiName, String httpProtocol) {
	
   	KongPluginSection basicAuthPluginSection = new KongPluginSection();
   	Metadata metadata = new Metadata();
	metadata.setName(apiName + "-" + Constant.K8S_PLUGIN_NAME_BASIC_AUTH);
	basicAuthPluginSection.setMetadata(metadata);
	basicAuthPluginSection.setDisabled(false);
	Map<String, Object> config = new HashMap<String, Object>();
	config.put("hide_credentials", true);
	basicAuthPluginSection.setConfig(config);
	basicAuthPluginSection.setPlugin(Constant.K8S_PLUGIN_NAME_BASIC_AUTH);
   	
   	return basicAuthPluginSection;
   	
    }
    
    public static KongPluginSection getSPGGetLogRequestPayloadPluginSection(String apiName, String httpProtocol) {
	
   	KongPluginSection spgLogRequestPayloadPluginSection = new KongPluginSection();
   	
   	Metadata metadata = new Metadata();
	metadata.setName(apiName + "-" + Constant.K8S_PLUGIN_NAME_SPG_LOG_REQUEST_PAYLOAD);
	spgLogRequestPayloadPluginSection.setMetadata(metadata);
	spgLogRequestPayloadPluginSection.setDisabled(false);
	Map<String, Object> config = new HashMap<String, Object>();
	config.put("log_request_payload", "{{ TODO_LOG_REQUEST_PAYLOAD|default('no', true) }}");
	config.put("max_reqest_size_in_bytes", 1048576);
	config.put("log_file_path", "/dev/stdout");
	config.put("log_file_reopen", false);
	config.put("environment", "{{TODO_PIPELINE_WORKSPACE_NAME|default('changeme', true)}}");
	config.put("provider_app_name", "{{ TODO_CMDB_APP_SHORTNAME }}");
	spgLogRequestPayloadPluginSection.setConfig(config);
	spgLogRequestPayloadPluginSection.setPlugin(Constant.K8S_PLUGIN_NAME_SPG_LOG_REQUEST_PAYLOAD);
   	
   	return spgLogRequestPayloadPluginSection;
   	
    }
    
    public static KongPluginSection getSPGGetLogResponsePayloadPluginSection(String apiName, String httpProtocol) {
	
   	KongPluginSection spgLogResponsePayloadPluginSection = new KongPluginSection();
   	
   	Metadata metadata = new Metadata();
	metadata.setName(apiName + "-" + Constant.K8S_PLUGIN_NAME_SPG_LOG_RESPONSE_PAYLOAD);
	spgLogResponsePayloadPluginSection.setMetadata(metadata);
	spgLogResponsePayloadPluginSection.setDisabled(false);
	Map<String, Object> config = new HashMap<String, Object>();
	config.put("log_request_payload", "{{ TODO_LOG_RESPONSE_PAYLOAD|default('no', true) }}");
	config.put("max_reqest_size_in_bytes", 1048576);
	config.put("log_file_path", "/dev/stdout");
	config.put("log_file_reopen", false);
	config.put("environment", "{{TODO_PIPELINE_WORKSPACE_NAME|default('changeme', true)}}");
	config.put("provider_app_name", "{{ TODO_CMDB_APP_SHORTNAME }}");
	spgLogResponsePayloadPluginSection.setConfig(config);
	spgLogResponsePayloadPluginSection.setPlugin(Constant.K8S_PLUGIN_NAME_SPG_LOG_RESPONSE_PAYLOAD);
   	
   	return spgLogResponsePayloadPluginSection;
   	
    }
    
    public static KongPluginSection getOAMValidatorPluginSection(String apiName, String httpProtocol) {
	
	KongPluginSection oamValidatorPluginSection = new KongPluginSection();
	Metadata metadata = new Metadata();
	metadata.setName(apiName + "-" + Constant.K8S_PLUGIN_NAME_OAM_AUTH);
	oamValidatorPluginSection.setMetadata(metadata);
	oamValidatorPluginSection.setDisabled(false);
	Map<String, Object> config = new HashMap<String, Object>();
	config.put("oauth_validation_host", 443);
	config.put("oauth_validation_protocol", "https");
	config.put("oauth_validation_url_path", "{{ TODO_MASTER_OAM_VALIDATION_URL_PATH |default('/oauth2/rest/token/info', true) }}");
	config.put("identity_domain_header_name", "X-OAUTH-IDENTITY-DOMAIN-NAME");
	config.put("identity_domain_header_value", "{{ TODO_MASTER_OAM_DOMAIN_NAME|default('RatingsDomain', true) }}");
	config.put("allowed_ldap_groups", "{{ TODO_OAM_LDAP_GROUPS }}");
	config.put("allowed_spapp_groups", "{{ TODO_OAM_SPAPP_GROUPS }}");
	config.put("allowed_scopes","{{ TODO_OAM_SCOPES }}");
	config.put("mandate_all_authorizations", "{{ TODO_OAM_MANDATE_ALL_AUTHORIZATIONS | default(false, true) }}");
	config.put("populate_user_name", "{{ TODO_OAM_VALIDATOR_POPULATE_USER_NAME | default(false, true) }}");
	oamValidatorPluginSection.setConfig(config);
	oamValidatorPluginSection.setPlugin(Constant.K8S_PLUGIN_NAME_OAM_AUTH);
	
	return oamValidatorPluginSection;
	
    }
    
    
    // rewrite wsdl
    // soap error transform
    

}

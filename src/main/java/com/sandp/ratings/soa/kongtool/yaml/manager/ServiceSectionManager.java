package com.sandp.ratings.soa.kongtool.yaml.manager;

import java.io.File;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.sandp.ratings.soa.kongtool.entity.API;
import com.sandp.ratings.soa.kongtool.service.Constant;
import com.sandp.ratings.soa.kongtool.yaml.Metadata;
import com.sandp.ratings.soa.kongtool.yaml.ServiceSection;
import com.sandp.ratings.soa.kongtool.yaml.Spec;


public class ServiceSectionManager {
    
    public static ServiceSection getServiceSection(API api) {
	
	ServiceSection serviceSection = new ServiceSection();
	Metadata metadata = new Metadata();
	metadata.setName(api.getApiName());
	LinkedHashMap<String, String> annotations = new LinkedHashMap<String, String>();
	annotations.put("konghq.com/override", api.getApiName() + "-config");
	annotations.put("konghq.com/path", "{{TODO_PROVIDER_BASE_PATH}}");
	annotations.put("konghq.com/protocols", "{{TODO_PROVIDER_URL_PROTOCOL}}");
	
	if(Constant.HTTPPOTOCOL_SOAP.equalsIgnoreCase(api.getHttpProtocol())) {
	    annotations.put("konghq.com/plugins", "TODO_API_NAME-spg-rewrite-wsdl-address-location,"
	    	+ "TODO_API_NAME-spg-soap-error-transformer,"
	    	+ "TODO_API_NAME-spg-inject-basic-credentials");
	}
	
	metadata.setAnnotations(annotations);
	
	Spec spec = new Spec();
	spec.setType("ExternalName");
	spec.setExternalName("{{TODO_PROVIDER_URL_DOMAIN_NAME}}");
	
	serviceSection.setMetadata(metadata);
	serviceSection.setSpec(spec);
	
	return serviceSection;
    }
    
    public static void main(String[] args) throws Exception {
	
	API api = new API();
	api.setApiName("idm-tokenservice");
	
	ObjectMapper om = new ObjectMapper(new YAMLFactory());
	om.writeValue(new File("src/main/resources/orderOutput.yaml"), ServiceSectionManager.getServiceSection(api));
    }
    
    
    

}

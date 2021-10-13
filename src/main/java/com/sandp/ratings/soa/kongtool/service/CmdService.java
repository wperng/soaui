package com.sandp.ratings.soa.kongtool.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.sandp.ratings.soa.kongtool.entity.API;
import com.sandp.ratings.soa.kongtool.yaml.IngressSection;
import com.sandp.ratings.soa.kongtool.yaml.K8SSection;
import com.sandp.ratings.soa.kongtool.yaml.KongPluginSection;
import com.sandp.ratings.soa.kongtool.yaml.manager.IngressSectionManager;
import com.sandp.ratings.soa.kongtool.yaml.manager.KongIngressSectionManager;
import com.sandp.ratings.soa.kongtool.yaml.manager.KongPluginSectionManager;
import com.sandp.ratings.soa.kongtool.yaml.manager.ServiceSectionManager;

@Service
public class CmdService {
    
    public List<K8SSection> getCommand(API api) {
	
	List<K8SSection> k8sSections = new ArrayList<K8SSection>();
	k8sSections.add(KongIngressSectionManager.getKongIngressSection(api.getApiName()));
	
	List<KongPluginSection> pluginSections = KongPluginSectionManager.getKongPluginSections(api);
	
	for (int i=0; i < pluginSections.size(); i++) {
	    k8sSections.add(pluginSections.get(i));
	}
	
	k8sSections.add(ServiceSectionManager.getServiceSection(api));
	
	List<IngressSection> ingressSections = IngressSectionManager.getIngressSection(api);
	for (int i=0; i < ingressSections.size(); i++) {
	    k8sSections.add(ingressSections.get(i));
	}
	
	return k8sSections;
	
    }
    
    public static void main(String[] args) throws Exception {
	
	API api = new API();
	api.setId("idm-tokenservice");
	api.setCmdbRecordName("Ratings SOA Platform");
	api.setShortTeamName("soa");
	api.setScrumTeamEmails("perngcat@hotmail.com");
	api.setMajorContactEmail("perngcat@hotmail.com");
	api.setHttpProtocol("REST");
	api.setApiZone("INTERNAL");
	api.setApiName("tokenservice");
	api.setTargetURL("https://spglobal.com/api/test");
	api.setBasicAuth(true);
	api.setDefaultAuth(true);
	api.setEnableGETMethod(true);
	api.setEnableOPTIONSMethod(true);
	api.setEnableReponseBuffering(true);
	api.setEnableRequestBuffering(true);
	api.setEnableRequestLog(true);
	api.setEnableResponseLog(true);
	api.setRateLimit(200);
	
	
	ObjectMapper om = new ObjectMapper(new YAMLFactory());
	om.writeValue(new File("src/main/resources/orderOutput.yaml"), new CmdService().getCommand(api));
    }

}

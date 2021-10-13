package com.sandp.ratings.soa.kongtool.yaml;

import com.sandp.ratings.soa.kongtool.service.Constant;

public class ServiceSection extends K8SSection {
    
    public ServiceSection() {
	super(Constant.K8S_SERVICE_APIVERSION_V1, Constant.K8S_KIND_SERVICE);
    }
}

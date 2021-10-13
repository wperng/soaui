package com.sandp.ratings.soa.kongtool.yaml;

import com.sandp.ratings.soa.kongtool.service.Constant;

public class IngressSection extends K8SSection {
    
    public IngressSection() {
	super(Constant.K8S_INGRESS_APIVERSION_V1, Constant.K8S_KIND_INGRESS);
    }
    

}

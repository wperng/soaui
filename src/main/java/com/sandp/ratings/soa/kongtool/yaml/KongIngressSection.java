package com.sandp.ratings.soa.kongtool.yaml;

import com.sandp.ratings.soa.kongtool.service.Constant;

public class KongIngressSection extends K8SSection {
    
    public KongIngressSection() {
   	super(Constant.K8S_KONGINGRESS_APIVERSION_V1, Constant.K8S_KIND_KONGINGRESS);
       }

}

package com.sandp.ratings.soa.kongtool.yaml;

import com.sandp.ratings.soa.kongtool.service.Constant;

public class KongPluginSection extends K8SSection {
    
    public KongPluginSection() {
	super(Constant.K8S_KONGPLUGIN_APIVERSION_V1, Constant.K8S_KIND_KONGPLUGIN);
    }

}

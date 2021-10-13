package com.sandp.ratings.soa.kongtool.yaml.manager;

import com.sandp.ratings.soa.kongtool.yaml.Active;
import com.sandp.ratings.soa.kongtool.yaml.Healthchecks;
import com.sandp.ratings.soa.kongtool.yaml.Healthy;
import com.sandp.ratings.soa.kongtool.yaml.KongIngressSection;
import com.sandp.ratings.soa.kongtool.yaml.Metadata;
import com.sandp.ratings.soa.kongtool.yaml.Passive;
import com.sandp.ratings.soa.kongtool.yaml.Proxy;
import com.sandp.ratings.soa.kongtool.yaml.Route;
import com.sandp.ratings.soa.kongtool.yaml.Unhealthy;
import com.sandp.ratings.soa.kongtool.yaml.Upstream;

public class KongIngressSectionManager {
    
    public static KongIngressSection getKongIngressSection(String apiName) {
	
	Healthy active_healthy = new Healthy();
	active_healthy.setHTTPStatuses(new int[] {200, 302});
	active_healthy.setInterval(0);
	active_healthy.setSuccesses(0);
	
	Unhealthy active_unhealthy = new Unhealthy();
	active_unhealthy.setHTTPFailures(0);
	active_unhealthy.setHTTPStatuses(new int[] {429});
	active_unhealthy.setInterval(0);
	active_unhealthy.setTCPFailures(0);
	active_unhealthy.setTimeouts(0);
	
	Active active = new Active();
	active.setConcurrency(10);
	active.setHealthy(active_healthy);
	active.setHTTPPath("/");
	active.setTimeout(0);
	active.setUnhealthy(active_unhealthy);
	
	Healthy passive_healthy = new Healthy();
	passive_healthy.setHTTPStatuses(new int[] {200});
	passive_healthy.setSuccesses(0);

	Unhealthy passive_unhealthy = new Unhealthy();
	passive_unhealthy.setHTTPFailures(0);
	passive_unhealthy.setHTTPStatuses(new int[] {429, 503});
	passive_unhealthy.setTCPFailures(0);
	passive_unhealthy.setTimeouts(0);
	
	Passive passive = new Passive();
	passive.setHealthy(passive_healthy);
	passive.setUnhealthy(passive_unhealthy);
	
	Healthchecks healthcheck = new Healthchecks();
	healthcheck.setThreshold(25);
	healthcheck.setActive(active);
	healthcheck.setPassive(passive);

	Upstream upstream = new Upstream();
	upstream.setSlots(10000);
	upstream.setHashOn("none");
	upstream.setHashFallback("none");
	upstream.setHealthchecks(healthcheck);
	
	Proxy proxy = new Proxy();
	proxy.setProtocol("https");
	proxy.setPath("/");
	proxy.setConnectTimeout(5000);
	proxy.setReadTimeout(60000);
	proxy.setWriteTimeout(60000);
	
	Route route = new Route();
	route.setRegexPriority(0);
	route.setStripPath(true);
	route.setPreserveHost(true);
	route.setRequestBuffering("{{ TODO_ENABLE_REQUEST_BUFFERING|default('true', true) }}");
	route.setResponseBuffering("{{ TODO_ENABLE_RESPONSE_BUFFERING|default('true', true) }}");
	route.setProtocols(new String[] {"https", "http"});
	
	KongIngressSection kongIngressSection = new KongIngressSection();
	Metadata metadata = new Metadata();
	metadata.setName(apiName+"-config");
	kongIngressSection.setMetadata(metadata);
	kongIngressSection.setUpstream(upstream);
	kongIngressSection.setProxy(proxy);
	kongIngressSection.setRoute(route);
	
	return kongIngressSection;
    }
}

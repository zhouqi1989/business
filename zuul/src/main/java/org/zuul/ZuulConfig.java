package org.zuul;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.CloudEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {
	
	//private DiscoveryClient getDiscoveryClient(){
	//	return new EurekaDiscoveryClient();
	//}
}

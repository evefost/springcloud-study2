package com.dongnaoedu.springcloud.zuul;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.netflix.zuul.context.RequestContext;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
// spring会将对应配置项的值注入进来的
@ConfigurationProperties("tony.zuul.tokenFilter")
public class TonyConfigurationBean {
	// 这个列表存的是routeId。这个列表里面的路由，不需要进行token校验，在TokenValidataFilter中会用到
	private List<String> noAuthenticationRoutes;
	private Map<String,String> serviceList;

	private Map<String,List<String>> noAuthApis;

	@PostConstruct
	public void init(){
		System.out.println("");
	}


	public Map<String, List<String>> getNoAuthApis() {
		return noAuthApis;
	}

	public void setNoAuthApis(Map<String, List<String>> noAuthApis) {
		this.noAuthApis = noAuthApis;
	}

	public Map<String, String> getServiceList() {
		return serviceList;
	}

	public void setServiceList(Map<String, String> serviceList) {
		this.serviceList = serviceList;
	}

	public List<String> getNoAuthenticationRoutes() {
		return noAuthenticationRoutes;
	}

	public void setNoAuthenticationRoutes(List<String> noAuthenticationRoutes) {
		this.noAuthenticationRoutes = noAuthenticationRoutes;
	}

	public boolean isNeedAuthentication(RequestContext context){
		Object requestURI = context.get("requestURI");
        Set<Map.Entry<String, List<String>>> entries = noAuthApis.entrySet();
        for(Map.Entry<String, List<String>> entry:entries){
            if(entry.getValue().contains(requestURI)){
                return false;
            }
        }
        return true;
	}

	
}

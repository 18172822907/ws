package com.meicloud.ws.config;

import org.springframework.context.annotation.Configuration;

import com.meicloud.ws.service.DemoService;
import com.meicloud.ws.service.impl.DemoServiceImpl;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import javax.xml.ws.Endpoint;

@Configuration
public class CxfConfig {

	@Bean
	public ServletRegistrationBean dispatcherServlet() {
		return new ServletRegistrationBean(new CXFServlet(), "/demo/*");
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	@Bean
	public DemoService demoService() {
		return new DemoServiceImpl();
	}

	@Bean
	public Endpoint userEndpoint1() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), demoService());
		endpoint.publish("/user");
		return endpoint;
	}
	

}
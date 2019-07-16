package com.meicloud.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.meicloud.ws.model.User;
import com.meicloud.ws.service.DemoService;

@WebService(serviceName = "DemoService", targetNamespace = "http://service.ws.meicloud.com", endpointInterface = "com.meicloud.ws.service.DemoService")
public class DemoServiceImpl implements DemoService {

	@Override
	public List<User> sayHello() {
		List<User> list = new ArrayList<>();
		for(int i = 0; i < 500; i++) {
			list.add(new User("user"+i,"user"+i,"user"+i,"user"+i,"user"+i));
		}
		return list;
	}

}

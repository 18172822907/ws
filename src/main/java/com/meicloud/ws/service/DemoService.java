package com.meicloud.ws.service;

import java.util.List;

import javax.jws.WebService;

import com.meicloud.ws.model.User;

@WebService(name = "DemoService", targetNamespace = "http://service.ws.meicloud.com")
public interface DemoService {

	public List<User> sayHello();
}

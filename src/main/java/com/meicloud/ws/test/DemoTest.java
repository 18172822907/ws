package com.meicloud.ws.test;

import java.util.List;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import com.meicloud.ws.model.User;

public class DemoTest {

	public static void main(String[] args) {

		JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
		Client client = factory.createClient("http://localhost:8080/demo/user?wsdl");

		// 需要密码的情况需要加上用户名和密码
		// client.getOutInterceptors().add(new
		// ClientLoginInterceptor(USER_NAME,PASS_WORD));
		HTTPConduit conduit = (HTTPConduit) client.getConduit();
		HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
		httpClientPolicy.setConnectionTimeout(2000); // 连接超时
		httpClientPolicy.setAllowChunking(false); // 取消块编码
		httpClientPolicy.setReceiveTimeout(120000); // 响应超时
		conduit.setClient(httpClientPolicy);
		// client.getOutInterceptors().addAll(interceptors);//设置拦截器
		try {
			Object[] objects = new Object[0];
			// invoke("方法名",参数1,参数2,参数3....);
			objects = client.invoke("sayHello", "sujin");
			List<User> l = (List<User>) objects[0];
			System.out.println("返回数据:" + l.get(0).getUserName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.engineer.common.easyquery.test;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import com.engineer.common.easyquery.validation.User;

public class UserServiceConsumer {
	
	public static void main(String[] args) {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient("http://localhost:6666/UserService?wsdl");
		try {
			User user = new User();
			Object[] objects = client.invoke("insert", user);
			System.out.println(objects.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

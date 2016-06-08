package com.engineer.common.easyquery.validation;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

@WebService(endpointInterface="com.engineer.common.easyquery.validation.UserService",serviceName="UserService")
public class UserServiceImpl implements UserService {
	
	@Override
	public void insert(User user) {
		System.out.println("insert the user, the user info is" + user.toString());
	}
	
	@Override
	public void update(User user) {
		System.out.println("update the user, the user info is" + user.toString());
	}
	
	@Override
	public void delete(Long id) {
		System.out.println("delete the user, the user id is" + id);
	}
	
	@Override
	public User findUser(Long id) {
		System.out.println("find the user, the user id is" + id);
		User user = new User();
		user.setId(id);
		user.setName("test");
		return user;
	}
	
	@Override
	public List<User> findAll() {
		System.out.println("find the all users");
		List<User> list = new ArrayList<User>();
		User user1 = new User();
		user1.setId(1l);
		user1.setName("test1");
		User user2 = new User();
		user2.setId(1l);
		user2.setName("test2");
		User user3 = new User();
		user3.setId(1l);
		user3.setName("test3");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		return list;
	}
	
	@Override
	public List<User> findUsersBySex(String sex) {
		System.out.println("find the user by sex");
		List<User> list = new ArrayList<User>();
		User user1 = new User();
		user1.setId(1l);
		user1.setName("test1");
		user1.setSex("male");
		User user2 = new User();
		user2.setId(1l);
		user2.setName("test2");
		user1.setSex("male");
		list.add(user1);
		list.add(user2);
		return list;
	}
}

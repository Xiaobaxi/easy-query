package com.engineer.common.easyquery.validation;

import java.util.List;
import javax.jws.WebService;
import javax.validation.GroupSequence;

@WebService
public interface UserService {
	
	@GroupSequence(Update.class)
	@interface Insert{}
	void insert(User user);
	
	@interface Update{}
	void update(User user);
	
	void delete(Long id);
	
	User findUser(Long id);
	
	List<User> findAll();
	
	List<User> findUsersBySex(String sex);
}

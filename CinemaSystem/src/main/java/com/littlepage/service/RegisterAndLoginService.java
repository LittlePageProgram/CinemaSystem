package com.littlepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlepage.entity.User;
import com.littlepage.mapper.UserMapper;

@Service
public class RegisterAndLoginService {
	
	@Autowired
	UserMapper userMapper;

	/**
	 * 可以注册返回true
	 * @param username
	 * @return
	 */
	public boolean testIsOrNotExist(String username) {
		List<User> li=userMapper.findUser(username);
		return li.size()==0;
	}

	/**
	 * 注册user
	 * @param user
	 */
	public void register(User user) {
		userMapper.addUser(user);
	}

	/**
	 * 查询一个用户
	 * @param username
	 * @return
	 */
	public User findUser(String username) {
		List<User> li=userMapper.findUser(username);
		if(li.size()==0) return null;
		return li.get(0);
	}

}

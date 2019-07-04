package com.littlepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlepage.entity.User;
import com.littlepage.mapper.UserMapper;

@Service
public class RoleService {

	@Autowired
	UserMapper userMapper;
	
	public List<User> showAllUser() {
		return userMapper.showAllUser();
	}

}

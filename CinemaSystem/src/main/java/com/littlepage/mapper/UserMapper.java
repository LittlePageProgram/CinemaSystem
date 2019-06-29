package com.littlepage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.littlepage.entity.User;

@Mapper
public interface UserMapper {
	public List<User> findUser(String username);
	
	public void addUser(User user);
}

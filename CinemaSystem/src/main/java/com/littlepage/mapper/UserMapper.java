package com.littlepage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.littlepage.entity.User;
/**
 * 用户的mybatis映射接口
 * @author 74302
 *
 */
@Mapper
public interface UserMapper {
	public List<User> findUser(String username);
	
	public void addUser(User user);

	public List<User> showAllUser();
}

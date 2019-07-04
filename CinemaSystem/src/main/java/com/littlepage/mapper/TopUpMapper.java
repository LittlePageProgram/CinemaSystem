package com.littlepage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.littlepage.entity.TopUp;
/**
 * topUpMapper充值信息映射
 * @author 74302
 *
 */
@Mapper
public interface TopUpMapper {

	public void addInfo(int id, String info);

	public List<TopUp> getAllInfo(int id);
	
}

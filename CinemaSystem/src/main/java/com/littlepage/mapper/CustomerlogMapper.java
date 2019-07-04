package com.littlepage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.littlepage.entity.Customerlog;

@Mapper
public interface CustomerlogMapper {

	void add(int id, String info);

	List<Customerlog> getAllBuyId(int id);

}

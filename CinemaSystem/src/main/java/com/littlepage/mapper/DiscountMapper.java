package com.littlepage.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DiscountMapper {

	void addDiscount(int discount, String startTime, String endTime, int condi);

}

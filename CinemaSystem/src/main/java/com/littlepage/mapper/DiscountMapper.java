package com.littlepage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.littlepage.entity.Discount;

@Mapper
public interface DiscountMapper {

	void addDiscount(int discount, String startTime, String endTime, int condi);

	List<Discount> findDiscount(int ticketPrice, String time);

}

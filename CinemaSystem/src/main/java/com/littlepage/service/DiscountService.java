package com.littlepage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlepage.mapper.DiscountMapper;

@Service
public class DiscountService {
	
	@Autowired
	DiscountMapper discountMapper;

	public void addDiscount(int discount, String startTime, String endTime, int condi) {
		discountMapper.addDiscount(discount,startTime, endTime,condi);
	}

}

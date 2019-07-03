package com.littlepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlepage.entity.Discount;
import com.littlepage.mapper.DiscountMapper;
import com.littlepage.utils.TimeUtils;
/**
 * 打折服务
 * @author 74302
 *
 */
@Service
public class DiscountService {
	
	/**
	 * 打折映射表
	 */
	@Autowired
	DiscountMapper discountMapper;

	/**
	 * 增加打折
	 * @param discount
	 * @param startTime
	 * @param endTime
	 * @param condi
	 */
	public void addDiscount(int discount, String startTime, String endTime, int condi) {
		discountMapper.addDiscount(discount,startTime, endTime,condi);
	}

	/**
	 * 查找打折
	 * @param ticketPrice
	 * @return
	 */
	public List<Discount> findDiscount(int ticketPrice) {
		String time=TimeUtils.getCurrentTime();
		return discountMapper.findDiscount(ticketPrice,time);
	}

}

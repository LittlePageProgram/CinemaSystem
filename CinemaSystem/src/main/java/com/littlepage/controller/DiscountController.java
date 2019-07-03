package com.littlepage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.littlepage.service.DiscountService;

@Controller
@RequestMapping("/discount")
public class DiscountController {
	
	@Autowired
	DiscountService discountService;
	
	@RequestMapping("/addDiscountCondition")
	public String discountSetPage() {
		return "/administrator/discount/addDiscountCondition";
	}
	
	@RequestMapping("/addDiscountSolve")
	public String addDiscountSolve(@RequestParam("discount")int discount,
			@RequestParam("startTime")String startTime,
			@RequestParam("endTime")String endTime,
			@RequestParam("condi")int condi) {
		discountService.addDiscount(discount,startTime,endTime,condi);
		return "/administrator/discount/addDiscountSuccess";
	}
}

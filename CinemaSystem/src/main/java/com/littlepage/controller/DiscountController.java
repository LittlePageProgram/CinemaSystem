package com.littlepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/discount")
public class DiscountController {
	@RequestMapping("/addDiscountCondition")
	public String discountSetPage() {
		
		return "";
	}
}

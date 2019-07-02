package com.littlepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 充值功能
 * @author 74302
 *
 */
@Controller
@RequestMapping("/topUp")
public class TopUpController {
	@RequestMapping("/firstPage")
	public String topUp() {
		return "/common/clubcard/topUp";
	}
	
	@RequestMapping("/topUpPayMethod")
	public String topUpPayMethod(@RequestParam("price")String price,Model model){
		model.addAttribute("price",price);
		return "/common/clubcard/topUpPayMethod";
	}
	
	@RequestMapping("/payPassword")
	public String payPassword(@RequestParam("price")String price) {
		
		return "/pay/topUpPaymentPage";
	}
}

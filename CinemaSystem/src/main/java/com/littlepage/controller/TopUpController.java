package com.littlepage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.littlepage.entity.User;
import com.littlepage.service.ClubCardService;
import com.littlepage.service.FilmScheduleService;
/**
 * 充值功能
 * @author 74302
 *
 */
@Controller
@RequestMapping("/topUp")
public class TopUpController {
	
	@Autowired
	FilmScheduleService filmScheduleServ;
	
	@Autowired
	ClubCardService clubCardServ;
	
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
	public String payPassword(@RequestParam("price")String price,@RequestParam("payMethod")String payMethod,Model model) {
		model.addAttribute("price",price);
		model.addAttribute("payMethod",payMethod);
		return "/pay/topUpPaymentPage";
	}
	
	@RequestMapping("/topUpSuccess")
	public String top(@RequestParam("price")String price,HttpServletRequest httpReq) {
		User user=(User) httpReq.getSession().getAttribute("userInfo");
		clubCardServ.addMoney(price,user.getId());
		return "/pay/topUpSuccess";
	}
}

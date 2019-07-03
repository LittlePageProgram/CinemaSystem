package com.littlepage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.littlepage.entity.ClubCard;
import com.littlepage.entity.User;
import com.littlepage.service.ClubCardService;

@Controller
@RequestMapping("/club")
public class ClubController {
	
		@Autowired
		ClubCardService clubCardService;

		/**
		 * 购买会员卡页面
		 * @return
		 */
		@RequestMapping("/buycard")
		public String buycard() {
			return "common/clubcard/buycard";
		}
		
		/**
		 * 支付方式页面
		 * @param price
		 * @param model
		 * @return
		 */
		@RequestMapping("/payMethod")
		public String payMethod(@RequestParam("price")int price,Model model) {
			model.addAttribute("price",price);
			return "common/clubcard/payMethod";
		}
		
		/**
		 * 支付密码页面
		 * @param price
		 * @param model
		 * @param payMethod
		 * @return
		 */
		@RequestMapping("/payPassword")
		public String payPassword(@RequestParam("price")int price,Model model,
				@RequestParam("payMethod")String payMethod) {
			model.addAttribute("price",price);
			model.addAttribute("payMethod",payMethod);//alipay or wechat pay
			return "/pay/paymentPage";
		}
		
		/**
		 * 购买结果页面
		 * @return
		 */
		@RequestMapping("/buyResult")
		public String buyResult(@RequestParam("price")String price,HttpServletRequest httpReq) {
			HttpSession session=httpReq.getSession();
			User user=(User) session.getAttribute("userInfo");
			
			List<ClubCard> li=clubCardService.queryAllById(user.getId());
			if(li.size()!=0) {
				return "pay/buyResultFalse";
			}
			clubCardService.addClubInfo(user.getId(),price);
			return "/pay/buyResultSuccess";
		}
		/**
		 * 余额页面
		 * @param httpReq
		 * @param model
		 * @return
		 */
		@RequestMapping("/showBalance")
		public String showBalance(HttpServletRequest httpReq,Model model) {
			HttpSession httpSession=httpReq.getSession();
			User user=(User) httpSession.getAttribute("userInfo");
			int id=user.getId();
			System.out.println(id+"id");
			String balance=clubCardService.getBalanceById(id);
			model.addAttribute("balance",balance);
			model.addAttribute("loginName",user.getLoginName());
			return "/common/clubcard/showBalance";
		}
}

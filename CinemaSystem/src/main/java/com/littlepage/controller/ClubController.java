package com.littlepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/club")
public class ClubController {

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
}

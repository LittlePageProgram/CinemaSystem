package com.littlepage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.littlepage.entity.Customerlog;
import com.littlepage.entity.TopUp;
import com.littlepage.entity.User;
import com.littlepage.mapper.CustomerlogMapper;
import com.littlepage.service.CustomerlogService;
import com.littlepage.service.TopUpService;
/**
 * 充值页面
 * @author 74302
 *
 */
@Controller
@RequestMapping("/topUpInfo")
public class TopUpInfoController {
	/**
	 * 充值信息展示服务
	 */
	@Autowired
	TopUpService topUpServ;
	
	/**
	 * 消费展示服务
	 */
	@Autowired
	CustomerlogService customerlogServ;
	/**
	 * 充值展示页面
	 * @param httpReq
	 * @param model
	 * @return
	 */
	@RequestMapping("info")
	public String info(HttpServletRequest httpReq,Model model) {
		User user=(User) httpReq.getSession().getAttribute("userInfo");
		List<TopUp> li=topUpServ.getAllInfo(user.getId());
		model.addAttribute("topInfo",li);
		return "/common/topUpInfo/info";
	}
	/**
	 * 消费展示页面
	 * @param httpReq
	 * @param model
	 * @return
	 */
	@RequestMapping("cusInfo")
	public String cusInfo(HttpServletRequest httpReq,Model model) {
		User user=(User) httpReq.getSession().getAttribute("userInfo");
		List<Customerlog> li=customerlogServ.getAllBuyId(user.getId());
		model.addAttribute("cusLogLi",li);
		return "/common/topUpInfo/cusInfo";
	}
}

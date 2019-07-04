package com.littlepage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.littlepage.entity.TopUp;
import com.littlepage.entity.User;
import com.littlepage.service.TopUpService;
/**
 * 充值页面
 * @author 74302
 *
 */
@Controller
@RequestMapping("/topUpInfo")
public class TopUpInfoController {
	
	@Autowired
	TopUpService topUpServ;
	
	
	@RequestMapping("info")
	public String info(HttpServletRequest httpReq,Model model) {
		User user=(User) httpReq.getSession().getAttribute("userInfo");
		List<TopUp> li=topUpServ.getAllInfo(user.getId());
		model.addAttribute("topInfo",li);
		return "/common/topUpInfo/info";
	}
}

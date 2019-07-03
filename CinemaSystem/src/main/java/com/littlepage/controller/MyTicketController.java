package com.littlepage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.littlepage.entity.ShowTicket;
import com.littlepage.entity.Ticketseat;
import com.littlepage.entity.User;
import com.littlepage.service.MyTicketService;
import com.littlepage.service.TicketSeatService;
/**
 * 票务显示控制类
 * @author 74302
 *
 */
@Controller
@RequestMapping("/myticket")
public class MyTicketController {
	
	@Autowired
	MyTicketService myticketServ;
	
	@Autowired
	TicketSeatService ticketSeatServ;
	
	@RequestMapping("/showMyTicket")
	public String showMyTicket(HttpServletRequest httpReq,Model model) {
		User user=(User) httpReq.getSession().getAttribute("userInfo");
		int id=user.getId();
		List<ShowTicket> liShowTicket=myticketServ.getAllByTicket(id);
		model.addAttribute("myticket",liShowTicket);
		return "common/myticket/showMyTicket";
	}
	
	@RequestMapping("/dishonour")
	@ResponseBody
	public String dishonour(@RequestParam("id")int id) {
		ticketSeatServ.deleteById(id);
		return "退票成功";
	}
}

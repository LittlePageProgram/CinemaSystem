package com.littlepage.controller;

import java.util.ArrayList;
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
import com.littlepage.entity.Film;
import com.littlepage.entity.FilmSchedule;
import com.littlepage.entity.Ticketseat;
import com.littlepage.entity.User;
import com.littlepage.service.ClubCardService;
import com.littlepage.service.FilmScheduleService;
import com.littlepage.service.FilmService;
import com.littlepage.service.TicketSeatService;

/**
 * 购买电影票
 * @author 74302
 *
 */
@Controller
@RequestMapping("/buyFilmTicketController")
public class BuyFilmTicketController {
	
	/**
	 * 电影安排表的服务
	 */
	@Autowired
	FilmScheduleService filmScheduleServ;
	
	/**
	 * 电影座位服务
	 */
	@Autowired
	TicketSeatService ticketSeatServ;
	
	/**
	 * 会员卡服务
	 */
	@Autowired
	ClubCardService clubServ;
	
	/**
	 * 买票页面
	 * @param fid
	 * @param model
	 * @return
	 */
	@RequestMapping("/chooseSchedule")
	@ResponseBody
	public String buyFilmTicket(@RequestParam("id")int fid,Model model,HttpServletRequest httpReq) {
		List<FilmSchedule> li=filmScheduleServ.findById(fid);
		httpReq.getSession().setAttribute("ticketPrice", li.get(0).getPrice());
		model.addAttribute("filmScheduleList",li);
		return "/common/buyTicket/chooseSchedule";
	}
	
	/**
	 * 选择座位页面
	 * @param sid
	 * @return
	 */
	@RequestMapping("/chooseSeat")
	public String chooseSeat(@RequestParam("id")int sid,Model model) {
		List<Ticketseat> li=ticketSeatServ.findAllByScheduleId(sid);
		model.addAttribute("hasSeat",li);
		model.addAttribute("id",sid);
		return "/common/buyTicket/chooseSeat";
	}
	
	/**
	 * 座位提交页面
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/seatSolve")
	public String seatSolve(@RequestParam("id")int sid,@RequestParam("seatNum")int seatNum,Model model,HttpServletRequest httpReq) {
		String wrong=null;
		List<Ticketseat> li=ticketSeatServ.findAllByScheduleId(sid);
		if(seatNum<1||seatNum>30) {
			wrong="座位号不在区间";
		}
		if(wrong!=null) {
			model.addAttribute("wrong",wrong);
			return "/common/buyTicket/wrongPage";
		}
		for (Ticketseat ticketseat : li) {
			if(ticketseat.getSeatNum()==seatNum) {
				wrong="座位已经有人占座";
				return "/common/buyTicket/wrongPage";
			}
		}
		
		if(wrong!=null) {
			model.addAttribute("wrong",wrong);
			return "/common/buyTicket/wrongPage";
		}
		HttpSession sesson=httpReq.getSession();
		User user=(User)sesson.getAttribute("userInfo");
		sesson.setAttribute("ticket",new Ticketseat(user.getId(), sid, seatNum));//票放进session
		return "/common/buyTicket/seatSolveSuccess";
	}
	
	/**
	 * 第三方支付
	 */
	@RequestMapping("/payPassword")
	public String payPassword(@RequestParam("payMethod")String method,Model model) {
			model.addAttribute("payMethod",method);
			return "/common/buyTicket/paymentPage";
	}
	
	/**
	 * buyResult第三方支付结果
	 */
	@RequestMapping("/buyResult")
	@ResponseBody
	public String buyResult(@RequestParam("payMethod")String method,@RequestParam("account")String account,
			@RequestParam("password")String password,HttpServletRequest httpReq) {
		if(method.equals("支付宝")||method.equals("微信")) {
			//支付成功
			Ticketseat ticket=(Ticketseat) httpReq.getSession().getAttribute("ticket");
			ticketSeatServ.addTicketSeat(ticket.getId(), ticket.getFilmScheduleId(),ticket.getSeatNum());
			return "支付成功";
		}else {
			//校验账户密码
			HttpSession sesson=httpReq.getSession();
			User user=(User)sesson.getAttribute("userInfo");
			if(!user.getLoginName().equals(account)||!user.getPassword().equals(password)) {
				//插入信息
				return "密码不正确";
			}else {
				Ticketseat ticket=(Ticketseat) httpReq.getSession().getAttribute("ticket");
				//查询ticket价格，查询是否优惠
				String s=(String) httpReq.getSession().getAttribute("ticketPrice");
				int ticketPrice=Integer.parseInt(s);//ticket价格
				String s2=clubServ.getBalanceById(user.getId());
				int balance=Integer.parseInt(s2);
				if(balance>=ticketPrice) {
					balance-=ticketPrice;
					clubServ.addClubInfo(user.getId(), balance+"");
					ticketSeatServ.addTicketSeat(ticket.getId(), ticket.getFilmScheduleId(),ticket.getSeatNum());
					return "支付成功";
				}
				return "余额不足，请充值";
			}
		}
	}
}

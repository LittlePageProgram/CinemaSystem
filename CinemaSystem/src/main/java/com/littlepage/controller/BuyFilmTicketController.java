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
import com.littlepage.entity.Discount;
import com.littlepage.entity.Film;
import com.littlepage.entity.FilmSchedule;
import com.littlepage.entity.Ticketseat;
import com.littlepage.entity.User;
import com.littlepage.service.ClubCardService;
import com.littlepage.service.DiscountService;
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
	 * 电影服务
	 */
	@Autowired
	FilmService filmServ;
	
	/**
	 * 会员卡服务
	 */
	@Autowired
	ClubCardService clubCardServ;
	
	/**
	 * 优惠服务
	 */
	@Autowired
	DiscountService discountServ;
	
	
	/**
	 * 买票页面
	 * @param fid
	 * @param model
	 * @return
	 */
	@RequestMapping("/chooseSchedule")
	public String buyFilmTicket(@RequestParam("id")int fid,Model model,HttpServletRequest httpReq) {
		List<FilmSchedule> li=filmScheduleServ.findById(fid);
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
	public String buyResult(@RequestParam("payMethod")String method,@RequestParam("account")String account,
			@RequestParam("password")String password,HttpServletRequest httpReq,Model model) {
		
		String payInfo=null;//支付信息，展示页面
		
		if(method.equals("支付宝")||method.equals("微信")) {
			//支付成功
			Ticketseat ticket=(Ticketseat) httpReq.getSession().getAttribute("ticket");
			ticketSeatServ.addTicketSeat(ticket.getId(), ticket.getFilmScheduleId(),ticket.getSeatNum());
			payInfo="支付成功";
			model.addAttribute("payInfo",payInfo);
			return "/common/buyTicket/buyResult";
		}else {
			//校验账户密码
			HttpSession sesson=httpReq.getSession();
			User user=(User)sesson.getAttribute("userInfo");
			//从session获取ticket的信息
			Ticketseat ticket=(Ticketseat) httpReq.getSession().getAttribute("ticket");
			//使用ticket获取票价
			
			if(!user.getLoginName().equals(account)||!user.getPassword().equals(password)) {
				//插入信息
				payInfo="支付成功";
				model.addAttribute("payInfo",payInfo);
				return "/common/buyTicket/buyResult";
			}else {
				//查询ticket价格，查询是否优惠
				List<FilmSchedule> list=filmScheduleServ.findById(ticket.getId());
				if(list.size()!=0) {
					FilmSchedule filmSchedule=list.get(0);
					String price=filmSchedule.getPrice();
					int ticketPrice=Integer.parseInt(price);//票价
					String price2=clubCardServ.getBalanceById(user.getId());
					int balance=Integer.parseInt(price2);//会员卡余额
					if(ticketPrice>balance) {
						payInfo="余额不足，请尽快充值";
						model.addAttribute("payInfo",payInfo);
						return "/common/buyTicket/buyResult";
					}else {
						//查看是否优惠
						List<Discount> discountLi=discountServ.findDiscount(ticketPrice);
						if(discountLi.size()!=0) {
							if(discountLi.get(0).getCondi()<ticketPrice) {
								balance-=(ticketPrice-discountLi.get(0).getDiscount());
								payInfo="购买成功，使用优惠券"+discountLi.get(0).getDiscount();
								model.addAttribute("payInfo",payInfo);
								return "/common/buyTicket/buyResult";
							}
						}
						balance-=ticketPrice;
						payInfo="购买成功";
						model.addAttribute("payInfo",payInfo);
						return "/common/buyTicket/buyResult";
					}
					
				}
				payInfo="购买成功";
				return "/common/buyTicket/buyResult";
			}
		}
	}
}

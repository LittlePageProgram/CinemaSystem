package com.littlepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.littlepage.entity.Film;
import com.littlepage.entity.FilmSchedule;
import com.littlepage.service.FilmScheduleService;
import com.littlepage.service.FilmService;
import com.littlepage.utils.RepeatUtils;
import com.littlepage.utils.TimeUtils;
/**
 * 第二阶段
 * 增加电影安排表控制器
 * @author 74302
 *
 */
@Controller
@RequestMapping("/filmSchedule")
public class FilmScheduleController {
	
	@Autowired
	FilmService filmService;
	
	@Autowired
	FilmScheduleService filmScheduleServ;
	
	static FilmSchedule filmSchedule;
	
	/**
	 * 增加电影安排表
	 * @return
	 */
	@RequestMapping("/addFilmSchedule")
	public String addFilmScheduleIndex() {
		
		return "/administrator/filmSchedule/addFilmSchedule";
	}
	
	/**
	 * 选择日期和电影院
	 * @return
	 */
	@RequestMapping("/chooseDateAndFilmRoom")
	public String chooseDateAndFilmRoom(@RequestParam("date")String date,@RequestParam("filmRoom")String filmRoom,Model model) {
		date=TimeUtils.formatDate(date);
		filmSchedule=new FilmSchedule();
		filmSchedule.setDate(date);
		filmSchedule.setFilmroom(filmRoom);
		List<Film> liFilm=filmService.findByDate(date);
		List<FilmSchedule> liSche=filmScheduleServ.findByDate(date);
		
		//筛选liSche重复项,出错！！！！！！！！！！！！！！！！！！！！！！！
		liSche=RepeatUtils.repeatSolve(liSche);
		System.out.println(liSche);
		if(liSche.size()==0) {
			model.addAttribute("schedule","该天没有时间安排");
		}else {
			model.addAttribute("schedulelist",liSche);
		}
		model.addAttribute("filmList",liFilm);
		return "/administrator/filmSchedule/timeAndFilmlist";
	}
	
	/**
	 * 
	 */
	@RequestMapping("/addSchedule")
	public String addSchedule(@RequestParam("time")String time,@RequestParam("film")String film,@RequestParam("price")String price) {
		time=TimeUtils.formatTime(time);
		filmSchedule.setStarttime(time);
		filmSchedule.setEndtime(TimeUtils.formatEndTime(time));
		filmSchedule.setPrice(price);
		boolean isComplete=filmScheduleServ.addSchedule(film,filmSchedule);//检测查重是否成功
		if(isComplete) {
			return "/administrator/filmSchedule/addScheduleSuccess";
		}else {
			return "/administrator/filmSchedule/addRepeat";
		}
	}
}

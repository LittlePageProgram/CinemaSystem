package com.littlepage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.littlepage.entity.Film;
import com.littlepage.entity.FilmSchedule;
import com.littlepage.entity.FilmScheduleShow;
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
	 * 增加排片信息
	 * @param time
	 * @param film
	 * @param price
	 * @return
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
	/**
	 * 展示时刻表的条件
	 * @return
	 */
	@RequestMapping("/showFilmSchedule")
	public String showSchedule() {
		return "/administrator/filmSchedule/showScheduleChooseView";
	}
	
	/**
	 * 映射电影安排表
	 * @param startDate
	 * @param endDate
	 * @param filmRoom
	 * @param sightView
	 * @return
	 */
	@RequestMapping("/filmScheduleList")
	public String filmScheduleList(@RequestParam("startDate")String startDate,
			@RequestParam("endDate")String endDate,@RequestParam("filmRoom")String filmRoom,
			@RequestParam("sightView")String sightView,Model model) {
		startDate=TimeUtils.formatDate(startDate);
		endDate=TimeUtils.formatDate(endDate);
		List<FilmSchedule> li=filmScheduleServ.showList(startDate,endDate,filmRoom,sightView);
		li=RepeatUtils.repeatSolve(li);
		System.out.println(li);
		model.addAttribute("filmScheduleList",li);
		List<Film> liFilm=new ArrayList<Film>();
		List<FilmScheduleShow> lishow=new ArrayList<FilmScheduleShow>();
		for (FilmSchedule filmSchedule : li) {
			FilmScheduleShow fss=new FilmScheduleShow(filmSchedule.getId(),filmSchedule.getFilmroom(), filmService.findById(Integer.parseInt(filmSchedule.getFid())).getName()
					, filmSchedule.getStarttime(), filmSchedule.getEndtime(), filmSchedule.getPrice());
			lishow.add(fss);
		}
		model.addAttribute("filmList",lishow);
		return "/administrator/filmSchedule/filmScheduleList";
	}
	/**
	 * 设置可见时间页面
	 * @return
	 */
	@RequestMapping("/setVisiableTime")
	public String setVisiableTime(@RequestParam("id")String id,Model model) {
		model.addAttribute("id",id);
		return "/administrator/filmSchedule/setVisiableTime";
	}
	
	
	/**
	 * 可见时间解决方案
	 * @return
	 */
	@RequestMapping("/visiableTimeSolve")
	public String visibleTimeSolve(@RequestParam("startDate")String startDate,@RequestParam("endDate")String endDate,@RequestParam("id")String id){
		filmScheduleServ.setStartDateAndEndDate(id,startDate,endDate);
		return "/administrator/filmSchedule/visiableTimeSolveSuccess";
	}
	
	/**
	 * 删除排片时间
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam("id")String id) {
		filmScheduleServ.deleteById(id);
		return "/administrator/filmSchedule/deleteSuccess";
	}
	
	
}

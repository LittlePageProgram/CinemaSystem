package com.littlepage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.littlepage.entity.Film;
import com.littlepage.entity.FilmLike;
import com.littlepage.entity.User;
import com.littlepage.service.FilmLikeService;
import com.littlepage.service.FilmService;
import com.littlepage.utils.TimeUtils;

import jdk.nashorn.internal.runtime.FindProperty;

/**
 * 普通用户功能页面
 * @author 74302
 *
 */
@Controller
@RequestMapping("/common")
public class CommonController {
	
	@Autowired
	FilmService filmService;
	
	@Autowired
	FilmLikeService filmLikeService;
	
	/**
	 * 电影列表页面
	 * @return
	 */
	@RequestMapping("/filmList")
	public String filmList(Model model) {
		List<Film> li=filmService.findAll();
		model.addAttribute("filmList",li);
		return "/common/filmList";
	}
	
	/**
	 * 电影详细信息页面
	 * @throws IOException 
	 */
	@RequestMapping("/filmInfo")
	public String filmInfo(@RequestParam("id")int id,Model model,HttpServletRequest req) throws IOException {
		Film tempFilm=filmService.findById(id);
		String path=filmService.savePic(tempFilm.getPosterLink());
		model.addAttribute("tempFilmInfo",tempFilm);
		model.addAttribute("tempPicPath",path);
		User user=(User) req.getSession().getAttribute("userInfo");
		boolean isLike=filmLikeService.testLike(user,id);
		if(!isLike){
			model.addAttribute("like","喜欢");
		}else {
			model.addAttribute("like","取消喜欢");
		}
		return "/common/filmInfo";
	}
	
	/**
	 * 喜欢模块
	 * @param model
	 * @param id
	 * @param httpReq
	 * @return
	 */
	@RequestMapping("/like")
	public String filmInfo(Model model,@RequestParam("id")int id,HttpServletRequest httpReq) {
		String date=TimeUtils.getCurrentTime();
		Film tempFilm=filmService.findById(id);
		String path=filmService.savePic(tempFilm.getPosterLink());
		model.addAttribute("tempFilmInfo",tempFilm);
		model.addAttribute("tempPicPath",path);
		User user=(User) httpReq.getSession().getAttribute("userInfo");
		List<FilmLike> liLike=filmLikeService.findAll(user.getId(),id);
		if(liLike.size()==0) {
			filmLikeService.addFilmLike(user.getId(),id,date);//增加
			model.addAttribute("like","取消喜欢");
		}else {
			filmLikeService.deleteFilmLike(user.getId(),id);//移除
			model.addAttribute("like","喜欢");
		}
		return "/common/filmInfo";
	}
	
	/**
	 * 搜索模块
	 * @param search
	 * @param model
	 * @return
	 */
	@RequestMapping("/search")
	public String search(@RequestParam("search")String search,Model model) {
		search="%"+search+"%";
		List<Film> li=filmService.search(search);
		model.addAttribute("filmList",li);
		return "/common/filmList";
	}
}

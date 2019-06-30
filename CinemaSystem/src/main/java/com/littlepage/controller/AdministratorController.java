package com.littlepage.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.littlepage.entity.Film;
import com.littlepage.service.FilmService;
/**
 * 管理员控制器页面
 * @author 74302
 *
 */
@Controller
@RequestMapping("/administrator")
public class AdministratorController {
	
	@Autowired
	FilmService filmService;
	
	/**
	 * 管理员登录页面
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "/administrator/index";
	}
	
	/**
	 * 增加电影页面
	 * @return
	 */
	@RequestMapping("/addFilm")
	public String addFilm() {
		return "/administrator/addFilm";
	}
	
	/**
	 * 添加成功页面
	 * @return
	 */
	@RequestMapping("/addFilmSuccess")
	public String addFilmSuccess() {
		return "/administrator/addFilmSuccess";
	}
	
	/**
	 * 电影列表页面
	 * @return
	 */
	@RequestMapping("/filmList")
	public String filmList(Model model) {
		List<Film> li=filmService.findAll();
		model.addAttribute("filmList",li);
		return "/administrator/filmList";
	}
	
	@RequestMapping("/filmInfo")
	public String filmInfo(@RequestParam("filmInfo")int id) {
		Film tempFilm=filmService.findById(id);
		return "/administrator/filmInfo";
	}
	
	/**
	 * 添加电影
	 * @param film
	 * @param posterLink
	 * @return
	 */
	@RequestMapping("/addFilmSolve")
	public String addFilmSolve(@RequestParam("name")String name,@RequestParam("posterLink")MultipartFile posterLink,
			@RequestParam("director")String director,@RequestParam("scriptWriter")String scriptWriter,
			@RequestParam("actor")String actor,@RequestParam("type")String type,
			@RequestParam("location")String location,@RequestParam("language")String language,
			@RequestParam("releaseDate")String releaseDate,@RequestParam("length")String length,
			@RequestParam("reflectDate")String reflectDate,Model model) {
		String result=null;
		try {
			Film film=new Film(-1, name, posterLink.getBytes(), director, scriptWriter, actor, type, location, language, releaseDate, length, reflectDate);
			result=filmService.addFilm(film);
			if(result.equals("success")) {
				return "/administrator/addFilmSuccess";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("filmAddStat", result);
		return "/administrator/addFilmFailed";
	}
	
	
}

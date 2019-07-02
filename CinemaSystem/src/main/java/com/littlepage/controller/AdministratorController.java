package com.littlepage.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.littlepage.entity.Film;
import com.littlepage.entity.FilmLikeCount;
import com.littlepage.service.FilmLikeService;
import com.littlepage.service.FilmService;
import com.littlepage.utils.PictureUtil;
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

	@Autowired
	FilmLikeService filmLikeService;
	
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
	
	
	/**
	 * 添加电影
	 * @param film
	 * @param posterLink
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/addFilmSolve")
	public String addFilmSolve(@RequestParam("name")String name,@RequestParam("posterLink")MultipartFile posterLink,
			@RequestParam("director")String director,@RequestParam("scriptWriter")String scriptWriter,
			@RequestParam("actor")String actor,@RequestParam("type")String type,
			@RequestParam("location")String location,@RequestParam("language")String language,
			@RequestParam("releaseDate")String releaseDate,@RequestParam("length")String length,
			@RequestParam("reflectDate")String reflectDate,Model model) throws IOException {
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
		filmService.savePic(posterLink.getBytes());
		return "/administrator/addFilmFailed";
	}
	
	/**
	 * 电影详细信息页面
	 * @throws IOException 
	 */
	@RequestMapping("/filmInfo")
	public String filmInfo(@RequestParam("id")int id,Model model) throws IOException {
		Film tempFilm=filmService.findById(id);
		String path=PictureUtil.getMD5Site(tempFilm.getPosterLink())+".jpg";
		model.addAttribute("tempFilmInfo",tempFilm);
		model.addAttribute("tempPicPath",path);
		return "/administrator/filmInfo";
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
		return "/administrator/filmList";
	}
	
	
	/**
	 * 图表模块
	 * @return
	 */
	@RequestMapping("/likeGraph")
	public String likeGraph(@RequestParam("id") int id) {
		return "/administrator/likeGraph";
	}
	
	/**
	 * 喜欢人数总计
	 */
	@RequestMapping("/likeList")
	public String likeList(Model model) {
		List<FilmLikeCount> li=filmLikeService.count();
		List<Film> liFilm=filmService.findAll();
		//0人观看添加
		for (Film film : liFilm) {
			for (FilmLikeCount film2 : li) {
				if(film.getName().equals(film2.getFilmName()))break;
			}
			li.add(new FilmLikeCount(film.getName(),0));
		}
		model.addAttribute("likeList",li);
		return "/administrator/likeList";
	}
	
	/**
	 * 删除电影
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam("id")int id) {
		filmService.delete(id);
		return "/administrator/deleteSuccess";
	}
	
	/**
	 * 修改信息
	 */
	@RequestMapping("/modify")
	public String modify(@RequestParam("id")int id,Model model) {
		model.addAttribute("id",id);
		return "/administrator/modifyPage";
	}
	/**
	 * 修改处理
	 */
	@RequestMapping("/modifySolve")
	public String modifySolve(@RequestParam("id")int id,
			@RequestParam("name")String name,@RequestParam("director")String director,
			@RequestParam("scriptWriter")String scriptWriter,@RequestParam("actor")String actor,
			@RequestParam("type")String type,@RequestParam("location")String location,
			@RequestParam("language")String language) {
		filmService.modifyFilm(id,name,director,scriptWriter,actor,type,location,language);
		return "/administrator/modifyPageSuccess";
	}
}

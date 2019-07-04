package com.littlepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.littlepage.entity.FilmRoom;
import com.littlepage.service.FilmRoomService;

/**
 * 影院控制器
 * @author 74302
 *
 */
@Controller
@RequestMapping("/filmRoom")
public class FilmRoomController {
	@Autowired
	FilmRoomService filmRoomServ;
	
	/**
	 * 电影增加页面
	 * @return
	 */
	@RequestMapping("/addFilmRoom")
	public String addFilmRoom() {
		return "/administrator/filmRoom/addFilmRoom";
	}
	
	/**
	 * 电影增加提交处理
	 * @param name
	 * @param seatInfo
	 * @return
	 */
	@RequestMapping("/addFilmRoomSolve")
	public String addFilmRoomSolve(@RequestParam("name")String name,@RequestParam("seatInfo")String seatInfo) {
		filmRoomServ.addFilmRoom(name,seatInfo);
		return "/administrator/filmRoom/addFilmSuccess";
	}
	
	/**
	 * 电影房间列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/filmRoomList")
	public String modifyFilmRoom(Model model) {
		List<FilmRoom> li=filmRoomServ.getAllFilmRoom();
		model.addAttribute("filmRoomLi",li);
		return "/administrator/filmRoom/filmRoomList";
	}
	
	/**
	 * 修改页面
	 */
	@RequestMapping("/modify")
	public String modify(@RequestParam("id")int id,Model model) {
		model.addAttribute("id",id);
		return "/administrator/filmRoom/modifyPage";
	}
	
	/**
	 * 修改过程
	 */
	@RequestMapping("/modifySolve")
	public String modifySolve(@RequestParam("name")String name,@RequestParam("seatInfo")String seatInfo,@RequestParam("id")int id) {
		filmRoomServ.modify(name,seatInfo,id);
		return "/administrator/filmRoom/modifySolve";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam("id")int id) {
		filmRoomServ.delete(id);
		return "/administrator/filmRoom/delete";
	}
}

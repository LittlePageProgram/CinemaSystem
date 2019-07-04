package com.littlepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.littlepage.entity.User;
import com.littlepage.service.RoleService;
/**
 * 角色
 * @author 74302
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	RoleService roleServ;

	/**
	 * 展示User
	 * @param model
	 * @return
	 */
	@RequestMapping("/showAllUser")
	public String roleList(Model model) {
		List<User> userList=roleServ.showAllUser();
		model.addAttribute("userList",userList);
		return "administrator/authority/showRole";
	}
	
	/**
	 * 修改User
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/modify")
	public String modify(Model model,@RequestParam("id")int id ) {
		model.addAttribute("id",id);
		return "administrator/authority/modify";
	}
	
	/**
	 * 修改结果
	 * @param id
	 * @param identify
	 * @return
	 */
	@RequestMapping("/modifySolve")
	public String modifySolve(@RequestParam("id")int id,@RequestParam("identify")String identify) {
		roleServ.modifyIdentify(id,identify);
		return "administrator/authority/modifyResult";
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public String modifySolve(@RequestParam("id")int id) {
		roleServ.delete(id);
		return "administrator/authority/deleteResult";
	}
}

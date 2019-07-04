package com.littlepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.littlepage.entity.User;
import com.littlepage.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	RoleService roleServ;

	@RequestMapping("/showAllUser")
	public String roleList(Model model) {
		List<User> userList=roleServ.showAllUser();
		model.addAttribute("userList",userList);
		return "administrator/authority/showRole";
	}
}

package com.littlepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 主页
 * @author 74302
 *
 */
@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}

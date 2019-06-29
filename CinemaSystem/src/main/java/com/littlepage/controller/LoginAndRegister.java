package com.littlepage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.littlepage.entity.User;
import com.littlepage.service.RegisterAndLoginService;
/**
 * 登录和注册
 * @author 74302
 *
 */
@Controller
@RequestMapping("/loginAndRegister")
public class LoginAndRegister {
	
	@Autowired
	RegisterAndLoginService registerAndLogin;
	
	/**
	 * 注册页面
	 * @return
	 */
	@RequestMapping("/register")
	public String registerPage() {
		return "/loginAndRegister/register";
	}
	
	/**
	 * 登录页面
	 */
	@RequestMapping("/login")
	public String  loginPage() {
		return "/loginAndRegister/login";
	}
	
	/**
	 * 注册验证
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/registerValidate")
	public String registerValidate(@RequestParam String username,@RequestParam String password) {
		if(!registerAndLogin.testIsOrNotExist(username)) {
			return "/loginAndRegister/registerFailed";
		}
		registerAndLogin.register(new User(-1, username, password, "common"));
		return "/loginAndRegister/registerSuccess";
	}
	
	/**
	 * 登录并存进session
	 * @param username
	 * @param password
	 * @param httpReq
	 * @return
	 */
	@RequestMapping("/loginValidate")
	public String loginValidate(@RequestParam String username,@RequestParam String password,HttpServletRequest httpReq) {
		User user=registerAndLogin.findUser(username);
		if(user==null) {
			return "/loginAndRegister/loginFailed";
		}
		if(!user.getPassword().equals(password)) {
			return "/loginAndRegister/passwordWrong";
		}
		HttpSession session=httpReq.getSession();
		session.setAttribute("userInfo", user);
		String role=user.getRole();
		if(role.equals("common")) {
			return "/common/index";
		}else {
			return "/administrator/index";
		}
	}
	
	
}

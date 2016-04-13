package com.spring3x.web;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring3x.domain.User;
import com.spring3x.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/index.html")
	public String loginPage(){
		return "login";
	}
	@RequestMapping(value="/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand){
		boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getUserName());
		if (isValidUser) {
			return new ModelAndView("login","error","Username or password error.");
		} else {
			User user = userService.findUserByUserName(loginCommand.getUserName());
			user.setLastIp(request.getRemoteAddr());
			user.setLastVisit(new Date(System.currentTimeMillis()));
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
		}
	}
}

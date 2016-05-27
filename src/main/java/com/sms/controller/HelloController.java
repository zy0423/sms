package com.sms.controller;

import com.sms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class HelloController
{
	@Autowired
	private UserService userService;

	@RequestMapping
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView model = new ModelAndView("index");
		userService.getUserByName("zhang");
		return model;
	}
}

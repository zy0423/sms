package com.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
class HelloController
{

	@RequestMapping
	public String main(Model model)
	{
		return "index";
	}
}

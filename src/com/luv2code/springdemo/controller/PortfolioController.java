package com.luv2code.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {
	
	@RequestMapping("/list")
	public String listStocks(Model theModel) {
		
		return "list-portfolio";
	}
}

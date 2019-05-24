package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value ="/page")
public class PageController {
	
	@RequestMapping(value ="/sy")
	public ModelAndView  getPage() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value ="/zhif")
	public ModelAndView  getPayPage() {
		return new ModelAndView("pay");
	}
	
	@RequestMapping(value ="/te")
	public ModelAndView  getTestPage() {
		return new ModelAndView("test");
	}

}

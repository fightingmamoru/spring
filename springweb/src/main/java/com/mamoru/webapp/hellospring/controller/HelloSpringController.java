package com.mamoru.webapp.hellospring.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloSpringController
{
	private static final Logger LOGGER = LogManager.getLogger(HelloSpringController.class);

	private static final String JSP_PATH = "hellospring/";

	@RequestMapping(value = "/helloSpring")
	public ModelAndView hello()
	{
		LOGGER.debug("[START hello()]======================================================================");

		ModelAndView mav = new ModelAndView();

		mav.setViewName(JSP_PATH + "hellospring");

		mav.addObject("title", "[Spring Web MVC]");
		mav.addObject("message", "Hello Spring!");

		LOGGER.debug("[END hello()]=======================================================================");

		return mav;
	}
}

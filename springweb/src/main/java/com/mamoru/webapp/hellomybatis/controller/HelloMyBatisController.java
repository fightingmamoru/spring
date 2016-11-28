package com.mamoru.webapp.hellomybatis.controller;

import com.mamoru.webapp.hellomybatis.service.HelloMybatisService;
import com.mamoru.webapp.hellomybatis.vo.HelloMyBatisVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/helloMyBatis")
public class HelloMyBatisController
{
	@Resource
	private HelloMybatisService helloMybatisService;

	@RequestMapping("/form")
	public ModelAndView form(@ModelAttribute("helloMyBatisVO") HelloMyBatisVO helloMyBatisVO, HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView();

		mav.setViewName("/hellospring/form");

		return mav;
	}

	@RequestMapping(value = "/updateFormAjax", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> updateFormAjax(MultipartHttpServletRequest request)
	{
		Map<String,String> result = new HashMap<String, String>();

		return result;
	}
}

package com.baidu.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.dto.device;
import com.baidu.service.IDeviceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/device")
public class DeviceController {
	@Autowired
	private IDeviceService service;
	
	@ResponseBody
	@RequestMapping("/list")
	public ModelAndView list(
			@RequestParam(value = "pageNum",defaultValue = "1",required = false) Integer pageNum) {
		PageHelper.startPage(pageNum, 2);
		
		List<device> seachDevice = service.seachDevice();
		PageInfo<device> pi = new PageInfo<device>(seachDevice);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",seachDevice);
		mav.setViewName("device/list");
		return mav;
	}
}

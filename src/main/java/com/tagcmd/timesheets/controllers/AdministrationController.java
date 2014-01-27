package com.tagcmd.timesheets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tagcmd.timesheets.admin.DataHolder;

@Controller
@RequestMapping(value="/{user}/administration")
public class AdministrationController {
	
	@Autowired
	private DataHolder dataHolder;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView initializePage(@PathVariable("user")String user) {
		return dataHolder.getModelAndView("administration");
	}
	
}

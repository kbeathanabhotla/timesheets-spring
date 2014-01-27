package com.tagcmd.timesheets.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tagcmd.timesheets.admin.DataHolder;

@Controller
@RequestMapping(value="/{user}/logout")
public class LogoutController {
	
	@Autowired
	private DataHolder dataHolder;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView logoutUser(HttpSession session) {
		session.removeAttribute("user");
		return dataHolder.getModelAndView("redirect:/spring/login");
	}
	
}

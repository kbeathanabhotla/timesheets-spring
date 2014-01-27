package com.tagcmd.timesheets.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tagcmd.timesheets.admin.DataHolder;
import com.tagcmd.timesheets.pojo.Login;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private DataHolder dataHolder;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loginUser(@ModelAttribute("login") Login login,
			HttpSession session) {

		session.setAttribute("user", login.getName());

		return dataHolder.getModelAndView("redirect:/spring/"+ login.getName() + "/showWorklog");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLoginUserForm(HttpSession session) {

		//FIXME remove this and move to AOP security aspect
		if (session.getAttribute("user") != null && !session.getAttribute("user").equals("")) {
			return dataHolder.getModelAndView("redirect:/spring/"+ session.getAttribute("user").toString() + "/showWorklog");
		}

		List<String> persons = dataHolder.getPersons();
		ModelAndView responsePage = dataHolder.getModelAndView("login");
		responsePage.addObject("persons", persons);
		responsePage.addObject("login", new Login());
		return responsePage;
	}
}

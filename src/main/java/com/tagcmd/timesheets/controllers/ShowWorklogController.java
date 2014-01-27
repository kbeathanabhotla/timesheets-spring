package com.tagcmd.timesheets.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tagcmd.timesheets.admin.DataHolder;
import com.tagcmd.timesheets.pojo.Worklog;
import com.tagcmd.timesheets.service.IWorklogService;

@Controller
@RequestMapping(value = "/{user}/showWorklog")
public class ShowWorklogController {

	@Autowired
	private DataHolder dataHolder;

	@Autowired
	private IWorklogService worklogService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView initializeShowWorklogForm(HttpSession session, @PathVariable("user") String user, @RequestParam(value="month",defaultValue="") String month) {
		ModelAndView mv = dataHolder.getModelAndView("showWorklog");
		mv.addObject("months", getMonthsOfLog(user));
		mv.addObject("worklogs",getWorklog(user,month));
		return mv;
	}

	private List<Worklog> getWorklog(String user,String month) {
		List<Worklog> worklogs = worklogService.getWorklogOfUser(user,month);
		return worklogs;
	}

	private List<String> getMonthsOfLog(String user) {
		return worklogService.getMonthsOfLog(user);
	}

}

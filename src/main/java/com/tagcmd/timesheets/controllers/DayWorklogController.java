package com.tagcmd.timesheets.controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tagcmd.timesheets.admin.DataHolder;
import com.tagcmd.timesheets.pojo.Worklog;
import com.tagcmd.timesheets.pojo.WorklogWrapper;
import com.tagcmd.timesheets.service.IWorklogService;
 
@Controller
@RequestMapping(value="/{user}/worklog")
public class DayWorklogController {
	
	@Autowired
	private DataHolder dataHolder;
	
	@Autowired
	private IWorklogService worklogService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submitWorklog(@ModelAttribute("worklogWrapper") WorklogWrapper worklogWrapper, BindingResult errors,@PathVariable("user")String user,@RequestParam(value="date",defaultValue="") String date) {
		
		if (errors.hasErrors()) {
			List<ObjectError> l = errors.getAllErrors();
			
			for(ObjectError ob : l) {
				System.out.println("------ "+ob.getDefaultMessage());
			}
		}

		populateObjects(worklogWrapper.getWorklog(),user,date);
		worklogService.addWorklog(worklogWrapper.getWorklog());
		ModelAndView modelAndView = dataHolder.getModelAndView("redirect:/spring/"+ user + "/showWorklog");
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView initializeForm(@PathVariable("user")String user) {
		
		WorklogWrapper worklogWrapper = new WorklogWrapper();
		worklogWrapper.getWorklog().add(new Worklog());
		
		ModelAndView modelAndView = dataHolder.getModelAndView("addworklog");
				
		modelAndView.addObject("statuses", dataHolder.getStatuses());
		modelAndView.addObject("activities", dataHolder.getActivities());
		modelAndView.addObject("activityTypes", dataHolder.getActivityTypes());
		modelAndView.addObject("clients", dataHolder.getClients());
		modelAndView.addObject("modules", dataHolder.getModules());
		modelAndView.addObject("persons", dataHolder.getPersons());
		modelAndView.addObject("worklogWrapper", worklogWrapper);
		
		return modelAndView;
	}
	
	private void populateObjects(List<Worklog> worklog,String user,String date) {
		for(Worklog log : worklog) {
			log.setModule(dataHolder.getModule(log.getModuleString()));
			log.setStatus(dataHolder.getStatus(log.getStatusString()));
			log.setClient(dataHolder.getClient(log.getClientString()));
			log.setActivity(dataHolder.getActivity(log.getActivityString()));
			log.setActivityType(dataHolder.getActivityType(log.getActivityTypeSting()));
			log.setPerson(dataHolder.getPerson(user));
			try {
				if(!date.equals("")) {
					log.setDate(dataHolder.getDateFormat("MM-dd-yyyy").parse(date));
				} else {
					log.setDate(new Date(System.currentTimeMillis()));
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}

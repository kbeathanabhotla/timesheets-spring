package com.tagcmd.timesheets.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.tagcmd.timesheets.pojo.Activity;
import com.tagcmd.timesheets.pojo.ActivityType;
import com.tagcmd.timesheets.pojo.Client;
import com.tagcmd.timesheets.pojo.Module;
import com.tagcmd.timesheets.pojo.Person;
import com.tagcmd.timesheets.pojo.Status;
import com.tagcmd.timesheets.service.ICommonService;

@Component
public class DataHolder {
	
	@Autowired
	private ICommonService commonService;
	
	private Map<String, ModelAndView> modelAndViews = new HashMap<>(0);
	private List<String> personNames = new ArrayList<>(0);
	private List<String> statuses = new ArrayList<>(0);
	private Map<String, SimpleDateFormat> dateFormats = new HashMap<>(0);
	private List<String> activities = new ArrayList<>(0);
	private List<String> modules = new ArrayList<>(0);
	private List<String> clients = new ArrayList<>(0);
	private List<String> activityTypes = new ArrayList<>(0);
	private Map<String, Module> moduleObjects = new HashMap<>(0);
	private Map<String, Status> statusObjects = new HashMap<>(0);
	private Map<String, Client> clientObjects = new HashMap<>(0);
	private Map<String, Activity> activityObjects = new HashMap<>(0);
	private Map<String, ActivityType> activityTypeObjects = new HashMap<>(0);
	private Map<String, Person> personObjects = new HashMap<>(0);
	
	public ModelAndView getModelAndView(String viewName) {
		if(modelAndViews.containsKey(viewName)) {
			return modelAndViews.get(viewName);
		} else {
			ModelAndView mv = new ModelAndView(viewName);
			modelAndViews.put(viewName, mv);
			return mv;
		}
	}
	
	public List<String> getPersons() {
		if(personNames.size() == 0) {
			personNames = commonService.getPersonNames();
		} 
		return personNames;
	}

	public List<String> getStatuses() {
		if(statuses.size() == 0) {
			statuses = commonService.getStatuses();
		} 
		return statuses;
	}
	
	public SimpleDateFormat getDateFormat(String dateFormat) {
		if(dateFormats.containsKey(dateFormat)) {
			return dateFormats.get(dateFormat);
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			dateFormats.put(dateFormat, sdf);
			return sdf;
		}
	}

	public List<String> getActivities() {
		if(activities.size() == 0) {
			activities = commonService.getActivities();
		}
		return activities;
	}

	public List<String> getActivityTypes() {
		if(activityTypes.size() == 0) {
			activityTypes = commonService.getActivityTypes();
		}
		return activityTypes;
	}

	public List<String> getClients() {
		if(clients.size() == 0) {
			clients = commonService.getClients();
		}
		return clients;
	}

	public List<String> getModules() {
		if(modules.size() == 0) {
			modules = commonService.getModules();
		}
		return modules;
	}
	
	public Module getModule(String moduleName) {
		if(moduleObjects.containsKey(moduleName)) {
			return moduleObjects.get(moduleName);
		} else {
			Module m = commonService.getModule(moduleName);
			moduleObjects.put(moduleName, m);
			return m;
		}
	}

	public Status getStatus(String status) {
		if(statusObjects.containsKey(status)) {
			return statusObjects.get(status);
		} else {
			Status s = commonService.getStatus(status);
			statusObjects.put(status, s);
			return s;
		}
	}

	public Client getClient(String client) {
		if(clientObjects.containsKey(client)) {
			return clientObjects.get(client);
		} else {
			Client c = commonService.getClient(client);
			clientObjects.put(client,c);
			return c;
		}
	}

	public Activity getActivity(String activity) {
		if(activityObjects.containsKey(activity)) {
			return activityObjects.get(activity);
		} else {
			Activity a = commonService.getActivity(activity);
			activityObjects.put(activity,a);
			return a;
		}
	}

	public ActivityType getActivityType(String activityType) {
		if(activityTypeObjects.containsKey(activityType)) {
			return activityTypeObjects.get(activityType);
		} else {
			ActivityType at = commonService.getActivityType(activityType);
			activityTypeObjects.put(activityType,at);
			return at;
		}
	}

	public Person getPerson(String user) {
		if(personObjects.containsKey(user)) {
			return personObjects.get(user);
		} else {
			Person p = commonService.getPerson(user);
			personObjects.put(user,p);
			return p;
		}
	}
	
	public void clearCache() {
		modelAndViews = new HashMap<>(0);
		personNames = new ArrayList<>(0);
		statuses = new ArrayList<>(0);
		dateFormats = new HashMap<>(0);
		activities = new ArrayList<>(0);
		modules = new ArrayList<>(0);
		clients = new ArrayList<>(0);
		activityTypes = new ArrayList<>(0);
		moduleObjects = new HashMap<>(0);
		statusObjects = new HashMap<>(0);
		clientObjects = new HashMap<>(0);
		activityObjects = new HashMap<>(0);
		activityTypeObjects = new HashMap<>(0);
		personObjects = new HashMap<>(0);
	}

	public Activity getActivityById(Integer id) {
		for(Entry<String, Activity> entry : activityObjects.entrySet()) {
			Activity a = entry.getValue();
			if(a.getId().equals(id)) {
				return a;
			}
		}
		
		Activity ac = commonService.getActivityById(id);
		activityObjects.put(ac.getName(), ac);
		return ac;
	}

	public ActivityType getActivityTypeById(Integer id) {
		for(Entry<String, ActivityType> entry : activityTypeObjects.entrySet()) {
			ActivityType a = entry.getValue();
			if(a.getId().equals(id)) {
				return a;
			}
		}
		
		ActivityType at = commonService.getActivityTypeById(id);
		activityTypeObjects.put(at.getName(), at);
		return at;
	}

	public Client getClientById(Integer id) {
		for(Entry<String, Client> entry : clientObjects.entrySet()) {
			Client c = entry.getValue();
			if(c.getId().equals(id)) {
				return c;
			}
		}
		
		Client client = commonService.getClientById(id);
		clientObjects.put(client.getName(), client);
		return client;
	}

	public Module getModuleById(Integer id) {
		for(Entry<String, Module> entry : moduleObjects.entrySet()) {
			Module m = entry.getValue();
			if(m.getId().equals(id)) {
				return m;
			}
		}
		
		Module module = commonService.getModuleById(id);
		moduleObjects.put(module.getName(), module);
		return module;
	}

	public Person getPersonById(Integer id) {
		for(Entry<String, Person> entry : personObjects.entrySet()) {
			Person p = entry.getValue();
			if(p.getId().equals(id)) {
				return p;
			}
		}
		
		Person p = commonService.getPersonById(id);
		personObjects.put(p.getName(), p);
		return p;
	}

	public Status getStatusById(Integer id) {
		for(Entry<String, Status> entry : statusObjects.entrySet()) {
			Status s = entry.getValue();
			if(s.getId().equals(id)) {
				return s;
			}
		}
		
		Status s = commonService.getStatusById(id);
		statusObjects.put(s.getName(), s);
		return s;
	}
}

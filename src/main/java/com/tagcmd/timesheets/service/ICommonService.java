package com.tagcmd.timesheets.service;

import java.util.List;

import com.tagcmd.timesheets.pojo.Activity;
import com.tagcmd.timesheets.pojo.ActivityType;
import com.tagcmd.timesheets.pojo.Client;
import com.tagcmd.timesheets.pojo.Module;
import com.tagcmd.timesheets.pojo.Person;
import com.tagcmd.timesheets.pojo.Status;

public interface ICommonService {

	List<String> getStatuses();
	List<String> getActivities();
	List<String> getActivityTypes();
	List<String> getClients();
	List<String> getModules();
	Module getModule(String moduleName);
	Status getStatus(String status);
	Client getClient(String client);
	Activity getActivity(String activity);
	ActivityType getActivityType(String activityType);
	Person getPerson(String user);
	List<String> getPersonNames();
	Activity getActivityById(Integer id);
	ActivityType getActivityTypeById(Integer id);
	Client getClientById(Integer id);
	Module getModuleById(Integer id);
	Person getPersonById(Integer id);
	Status getStatusById(Integer id);
}

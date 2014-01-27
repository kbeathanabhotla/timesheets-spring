package com.tagcmd.timesheets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tagcmd.timesheets.dao.ICommonDAO;
import com.tagcmd.timesheets.pojo.Activity;
import com.tagcmd.timesheets.pojo.ActivityType;
import com.tagcmd.timesheets.pojo.Client;
import com.tagcmd.timesheets.pojo.Module;
import com.tagcmd.timesheets.pojo.Person;
import com.tagcmd.timesheets.pojo.Status;
import com.tagcmd.timesheets.service.ICommonService;

@Service
public class CommonServiceImpl implements ICommonService {
	
	@Autowired
	private ICommonDAO commonDAO;
	
	@Override
	public List<String> getStatuses() {
		return commonDAO.getStatuses();
	}
	
	@Override
	public List<String> getPersonNames() {
		return commonDAO.getPersonNames();
	}
	
	@Override
	public List<String> getActivities() {
		return commonDAO.getActivities();
	}

	@Override
	public List<String> getActivityTypes() {
		return commonDAO.getActivityTypes();
	}

	@Override
	public List<String> getClients() {
		return commonDAO.getClients();
	}

	@Override
	public List<String> getModules() {
		return commonDAO.getModules();
	}

	@Override
	public Module getModule(String moduleName) {
		return commonDAO.getModule(moduleName);
	}

	@Override
	public Status getStatus(String status) {
		return commonDAO.getStatus(status);
	}

	@Override
	public Client getClient(String client) {
		return commonDAO.getClient(client);
	}

	@Override
	public Activity getActivity(String activity) {
		return commonDAO.getActivity(activity);
	}

	@Override
	public ActivityType getActivityType(String activityType) {
		return commonDAO.getActivityType(activityType);
	}

	@Override
	public Person getPerson(String user) {
		return commonDAO.getPerson(user);
	}

	@Override
	public Activity getActivityById(Integer id) {
		return commonDAO.getActivityById(id);
	}

	@Override
	public ActivityType getActivityTypeById(Integer id) {
		return commonDAO.getActivityTypeById(id);
	}

	@Override
	public Client getClientById(Integer id) {
		return commonDAO.getClientById(id);
	}

	@Override
	public Module getModuleById(Integer id) {
		return commonDAO.getModuleById(id);
	}

	@Override
	public Person getPersonById(Integer id) {
		return commonDAO.getPersonById(id);
	}

	@Override
	public Status getStatusById(Integer id) {
		return commonDAO.getStatusById(id);
	}

}

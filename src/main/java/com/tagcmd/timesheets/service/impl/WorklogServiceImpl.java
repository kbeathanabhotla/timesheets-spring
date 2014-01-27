package com.tagcmd.timesheets.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tagcmd.timesheets.admin.DataHolder;
import com.tagcmd.timesheets.dao.IWorklogDAO;
import com.tagcmd.timesheets.pojo.DatesWrapper;
import com.tagcmd.timesheets.pojo.Worklog;
import com.tagcmd.timesheets.service.IWorklogService;
import com.tagcmd.timesheets.util.DateUtil;

@Service
public class WorklogServiceImpl implements IWorklogService {

	@Autowired
	private IWorklogDAO worklogDAO;
	
	@Autowired
	private DateUtil dateUtil;
	
	@Autowired
	private DataHolder dataHolder;
	
	@Override
	public List<String> getMonthsOfLog(String user) {
		List<Date> dates = worklogDAO.getDatesOfLog(user);
		return dateUtil.getFormattedDatesaAsString(dates,"MMMM yyyy");
	}

	@Override
	public void addWorklog(List<Worklog> worklog) {
		worklogDAO.addWorklog(worklog);
	}

	@Override
	public List<Worklog> getWorklogOfUser(String user, String month) {
		DatesWrapper dw = dateUtil.getDateRange(month);
		List<Worklog> worklogs = worklogDAO.getWorklogOfUser(user,dw.getStartDate(),dw.getEndDate());
		getPopulatedWorklogs(worklogs);
		return worklogs;
	}

	private void getPopulatedWorklogs(List<Worklog> worklogs) {
		for(Worklog wl : worklogs) {
			wl.setActivity(dataHolder.getActivityById(wl.getActivity().getId()));
			wl.setActivityType(dataHolder.getActivityTypeById(wl.getActivityType().getId()));
			wl.setClient(dataHolder.getClientById(wl.getClient().getId()));
			wl.setModule(dataHolder.getModuleById(wl.getModule().getId()));
			wl.setPerson(dataHolder.getPersonById(wl.getPerson().getId()));
			wl.setStatus(dataHolder.getStatusById(wl.getStatus().getId()));
		}
	}
}

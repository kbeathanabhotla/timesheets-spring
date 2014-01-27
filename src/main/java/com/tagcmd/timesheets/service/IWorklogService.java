package com.tagcmd.timesheets.service;

import java.util.List;

import com.tagcmd.timesheets.pojo.Worklog;

public interface IWorklogService {

	List<String> getMonthsOfLog(String user);

	void addWorklog(List<Worklog> worklog);

	List<Worklog> getWorklogOfUser(String user, String month);

}

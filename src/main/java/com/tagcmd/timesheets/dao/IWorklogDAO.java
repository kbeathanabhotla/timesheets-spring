package com.tagcmd.timesheets.dao;

import java.util.Date;
import java.util.List;

import com.tagcmd.timesheets.pojo.Worklog;

public interface IWorklogDAO {

	List<Date> getDatesOfLog(String user);

	void addWorklog(List<Worklog> worklog);

	List<Worklog> getWorklogOfUser(String user, Date startDate, Date endDate);

}

package com.tagcmd.timesheets.pojo;

import java.util.ArrayList;
import java.util.List;

public class WorklogWrapper {
	
	private List<Worklog> worklog = new ArrayList<>(0);

	public List<Worklog> getWorklog() {
		return worklog;
	}

	public void setWorklog(List<Worklog> worklog) {
		this.worklog = worklog;
	}
}

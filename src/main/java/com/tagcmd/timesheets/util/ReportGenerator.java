package com.tagcmd.timesheets.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tagcmd.timesheets.pojo.Worklog;
import com.tagcmd.timesheets.service.IWorklogService;

@Component
public class ReportGenerator {
	
	@Autowired
	private IWorklogService worklogService;
	
	private File returnFile = new File(System.getProperty("java.io.tmpdir")
			+ File.separator + System.currentTimeMillis() + ".xls");
	private FileOutputStream fos = null;

	private File getUserTimesheet(String user, String month) {
		try {
			returnFile.createNewFile();
			fos = new FileOutputStream(returnFile);
			List<Worklog> worklogs = worklogService.getWorklogOfUser(user, month);
			writeWorklogs(worklogs,fos,false);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return returnFile;
	}

	private void writeWorklogs(List<Worklog> worklogs, FileOutputStream fos2,boolean newSheet) {
		
		if(newSheet) {
			
		} else {
			
		}

	}

	private File getTeamsTimesheet(String month) {

		try {
			boolean b = returnFile.createNewFile();
			System.out.println("created new File " + b);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return returnFile;
	}

	public File getTimesheet(String user, boolean all, String month) {
		if (all) {
			return getTeamsTimesheet(month);
		} else {
			return getUserTimesheet(user, month);
		}
	}

}

package com.tagcmd.timesheets.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tagcmd.timesheets.util.ReportGenerator;

@Controller
@RequestMapping("/{user}/getworklog")
public class WorklogReportGenerator {

	@Autowired
	private ReportGenerator reportGenerator;

	@RequestMapping(method = RequestMethod.GET)
	public void getWorklogReport(HttpServletResponse response,
			@RequestParam(value = "all", defaultValue = "false") boolean all,
			@RequestParam(value = "month", defaultValue = "") String month,
			@PathVariable("user") String user) throws IOException {

		File timesheet = reportGenerator.getTimesheet(user, all, month);
		FileInputStream fis = new FileInputStream(timesheet);
		response.addHeader("Content-Type", "application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ timesheet.getName());
		ServletOutputStream out = response.getOutputStream();

		byte[] buf = new byte[0x1000];
		while (true) {
			int r = fis.read(buf);
			if (r == -1) {
				break;
			}
			out.write(buf, 0, r);
		}
		
		fis.close();
		out.flush();
		out.close();
	}

}

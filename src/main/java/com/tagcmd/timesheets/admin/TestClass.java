package com.tagcmd.timesheets.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestClass {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		System.out.println(sdf.parse("1-2-2014"));
		
	}

}

package com.tagcmd.timesheets.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tagcmd.timesheets.admin.DataHolder;
import com.tagcmd.timesheets.pojo.DatesWrapper;

@Component
public class DateUtil {

	@Autowired
	private DataHolder dataHolder;
	
	public void sortDates(List<Date> dates) {
		Collections.sort(dates, new Comparator<Date>() {
            public int compare(Date arg0, Date arg1) {
               return arg0.compareTo(arg1);
            }
        });
	}
	
	public String getDateInFormat(Date d , String format) {
		SimpleDateFormat sdf = dataHolder.getDateFormat(format);
		return sdf.format(d);
	}

	public List<String> getFormattedDatesaAsString(List<Date> dates,String dateFormat) {
		Set<String> retSet = new LinkedHashSet<>(0);
		for(Date d : dates) {
			retSet.add(dataHolder.getDateFormat(dateFormat).format(d));
		}
		return new ArrayList<>(retSet);
	}
	

	public DatesWrapper getDateRange() {
		DatesWrapper dw = new DatesWrapper();
        Calendar calendar = getCalendarForNow();
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        dw.setStartDate(calendar.getTime());
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        dw.setEndDate(calendar.getTime());
	    return dw;
	}

	private static Calendar getCalendarForNow() {
	    Calendar calendar = GregorianCalendar.getInstance();
	    calendar.setTime(new Date());
	    return calendar;
	}

	public DatesWrapper getDateRange(String month) {
		if(month.equals("")) {
			return getDateRange();
		} else {
			DatesWrapper dw = new DatesWrapper();
			try {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dataHolder.getDateFormat("MMMM yyyy").parse(month));
		        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		        dw.setStartDate(calendar.getTime());
		        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		        dw.setEndDate(calendar.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return dw;
		}
	}
}

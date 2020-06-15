package com.bgp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getDate(){
		Date date=java.util.Calendar.getInstance().getTime();  
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
		return formatter.format(date);
	}
}

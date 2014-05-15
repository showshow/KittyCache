package com.insightsource.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil
{
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
	
	public static int compareDateTime(String dateTime1, String dateTime2)
	{
		try
		{
			Date date1 = sdf.parse(dateTime1);
			Date date2 = sdf.parse(dateTime2);
			
			if(date1.before(date2))
				return -1;
			if(date1.after(date2))
				return 1;
			else
				return 0;
		}
		catch(Exception e)
		{
			throw new RuntimeException("解析日期时间格式出错，期望的字符串格式为[yyyyMMdd HH:mm:ss]");
		}
	}
}

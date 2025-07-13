package com.oneclick.ecom.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class JavaUtility 
{
	public int getRandomNumber()
	{
		Random random = new Random();
		int randomNum = random.nextInt(5000);
		return randomNum;
	}
	
	public int getRandomNumberwithin20()
	{
		Random random = new Random();
		int randomNum = random.nextInt(20);
		return randomNum;
	}
	
	public String getRandomEmail()
	{
		String random = RandomStringUtils.randomAlphanumeric(4);
		String randomemail = random + "@gmail.com";
		return randomemail;
	}
	public String getSystemDateYYYYDDMM()
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(d);
		return date;
	}
	
	public String getRequiredDateYYYYDDMM(int days)
	{
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");	
		sim.format(d);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String endDate = sim.format(cal.getTime());
		return endDate;
	}

	
}

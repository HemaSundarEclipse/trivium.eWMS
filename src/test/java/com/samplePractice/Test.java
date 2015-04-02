package com.samplePractice;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;

import com.utility.NavigatetoOverviews;

public class Test
{
	@org.testng.annotations.Test
	public void test() throws InterruptedException
	{
		
		System.out.println(Calendar.getInstance().get(Calendar.MONTH));
		
		System.out.println(new SimpleDateFormat("YYYY/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));	
	}
}

package com.crm.qa.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.base.BaseClass;

public class WebEventListener extends BaseClass implements WebDriverEventListener{

	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		System.out.println("Value of element changed to: "+arg0.toString());
		
	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("After click on the following element: "+arg0);
		
	}

	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		System.out.println("Found an element by: "+arg0.toString());
		
		
	}

	public void afterNavigateBack(WebDriver arg0) {
		System.out.println("Navigated to the previous page");
		
		
	}

	public void afterNavigateForward(WebDriver arg0) {
		System.out.println("Navigated to the next page");
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String url, WebDriver arg1) {
		System.out.println("After navigating to url: "+url);
		
	}

	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		System.out.println("Before value of element changed: "+arg0.toString());
		
		
	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("Clicking on element: "+arg0);
		
	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		System.out.println("Before finding an element by: "+arg0.toString());
				
	}

	public void beforeNavigateBack(WebDriver arg0) {
		System.out.println("Navigating to the previous page");
	
		
	}

	public void beforeNavigateForward(WebDriver arg0) {
		System.out.println("Navigating to the next page");
			
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver arg1) {
		System.out.println("Before navigating to URL: "+url);
		
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable arg0, WebDriver arg1) {
		System.out.println("The Exception occurred: "+arg0);
		try
		{
		TestUtil.takeScreenshots();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}

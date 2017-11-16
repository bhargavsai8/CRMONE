package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends BaseClass{

	LoginPage loginpage;
	HomePage home;
	
	public LoginPageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void testTitle()
	{
		String title=loginpage.validatePageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}

	@Test(priority=2)
	public void testImage()
	{
		Assert.assertTrue(loginpage.validteHeadImage());
	}
	
	@Test(priority = 3)
	public void loginSuccess()
	{
		home=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@AfterMethod
	public void quitall()
	{
		driver.quit();
	}
}

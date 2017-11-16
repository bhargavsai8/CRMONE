package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;

public class HomePageTest extends BaseClass{
	
	LoginPage loginpage;
	ContactsPage contactspage;
	HomePage homepage;
	TestUtil testutil;
	
	public HomePageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage= new LoginPage();
		testutil=new TestUtil();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	

	@Test(priority=1)
	public void validateTitle()
	{
		String title=homepage.verifyPageTitle();
		Assert.assertEquals(title, "CRMPRO", "title matches correctly");
			
		
	}
	
	@Test(priority=2)
	public void validateUserName() //throws Exception
	{
		testutil.switchToFrame();
		Assert.assertTrue(homepage.validateUsername());
		//throw new Exception();
	}
	
	@Test(priority = 3)
	public void clickContactsPage()
	{
		testutil.switchToFrame();
		contactspage=homepage.checkContactsLink();
		
		
	}
	
	
	@AfterMethod
	public void exit()
	{
		driver.quit();
	}
	

}

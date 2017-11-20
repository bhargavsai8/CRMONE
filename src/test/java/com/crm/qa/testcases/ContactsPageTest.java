package com.crm.qa.testcases;

import java.io.IOException;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;

public class ContactsPageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	Logger log = Logger.getLogger("devpinoyLogger");
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		log.info("setup");
		initialization();
		loginpage= new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil = new TestUtil();
		testutil.switchToFrame();		
		contactspage=homepage.checkContactsLink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsLabel()
	{
		log.info("verify contacts lavel in test class");

		Assert.assertTrue(contactspage.verifyContactsLabel(),"Contacts Label Present");
		
		
	}
	
	@Test(priority=2)
	public void selectAContact()
	{
		log.info("select contacts lavel in test class");

	// contactspage.selectAContact("Carl Cruger");
	 contactspage.selectAContact("Bruce Wayne");
	}
	
	@DataProvider
	public Object[][] getTestData() throws IOException
	{
		Object data[][]=testutil.readExcelData("Sheet1");
		return data;
	}
	
	@Test(priority=3, dataProvider="getTestData")
	public void addContact(String title, String fname, String lname, String company)
	{
		homepage.clickOnNewContact();
		contactspage.createNewContact(title, fname, lname, company);
		
	}
	
	@AfterTest
	public void exit()
	{
		
	    driver.quit();
	    
	}
	


}

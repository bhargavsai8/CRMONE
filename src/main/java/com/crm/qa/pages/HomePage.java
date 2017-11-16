package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//td[contains(text(),'User: bhargav sai')]//")
	WebElement usernametext;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactbtn;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateUsername()
	{
		return usernametext.isDisplayed();
	}
	
	public ContactsPage checkContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}

	public TasksPage checkTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
	}
	
	public DealsPage checkDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public void clickOnNewContact()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newcontactbtn.click();
	}
}

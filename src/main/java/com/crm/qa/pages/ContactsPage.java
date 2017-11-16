package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.BaseClass;
import com.crm.qa.utility.LogTest;

public class ContactsPage extends BaseClass
{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsText;
	
	@FindBy(xpath=".//*[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath=".//*[@id='surname']")
	WebElement lastName;
	
	@FindBy(xpath=".//input[@type='submit'][@value='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath=".//a[@title='Contacts']")
	WebElement contactsLnk;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	
	public ContactsPage()
	{
		LogTest.infoMessage("initiating elements");
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
		LogTest.infoMessage("verifying contacts");
		
		return contactsText.isDisplayed();
		
	}
	

	public void selectAContact(String name)
	{
		LogTest.infoMessage("select a contact");
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']/input[@name='contact_id']")).click();;
		
		
	}
	
	public void createNewContact(String title, String fname, String lname, String company)
	{
		
		LogTest.infoMessage("create a new contact");
		Select sel = new Select(driver.findElement(By.name("title")));
		sel.selectByVisibleText(title);
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		companyName.sendKeys(company);
		saveBtn.click();
	}
}

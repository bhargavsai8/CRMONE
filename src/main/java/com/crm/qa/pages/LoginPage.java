package com.crm.qa.pages;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(className="img-responsive")
	WebElement headimage;
	
	@FindBy(xpath="//button[text()='Sign Up']")
	WebElement signupbtn;
	
	public LoginPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String validatePageTitle()
	{
		return driver.getTitle();
		
	}
		
	
	public boolean validteHeadImage()
	{
		return headimage.isDisplayed();
	}

	public HomePage login(String uname, String pwd)
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		username.sendKeys(uname);
		password.sendKeys(pwd);
		//loginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginBtn);
    	
		return new HomePage();

	}
	
}

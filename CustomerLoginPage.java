/**
 * 
 */
package SmokeTestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

 //This class will store all the locators and methods of Login page
 
public class CustomerLoginPage {
WebDriver driver;	

By email= By.id("input-email");
By password = By.xpath("//*[@id=\"input-password\"]");
By loginstatus = By.cssSelector("#content > h1");

By loginbutton = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");

By footerText = By.xpath("//*[contains(text(),'Uniform Store')]");
By dropdown=By.xpath("//*[@id=\"top-links1\"]/ul/li[3]/a/i");
By Logout=By.linkText("Logout");
By Login=By.linkText("Login");




//By SignUpBotton=By.linkText("Sign up!");
//creating parameterized constructor to initialize WebDriver reference
public CustomerLoginPage(WebDriver driver)
{
	this.driver =driver;
}


public void typeusername(String s)
{
	driver.findElement(email).sendKeys(s);
}


public void typepassword(String p) {
	driver.findElement(password).sendKeys(p);
}

/*public boolean isUsernameboxAvailable()
{

	if (driver.findElement(email).isDisplayed()) {
		return true;
	}
	else
	{
		return false;
	}
	
	}*/
public boolean isUsernameboxEnabled()
{

	if (driver.findElement(email).isEnabled()) {
		return true;
	}
	else
	{
		return false;
	}
	
	}

public boolean isPasswordboxEnabled()
{

	if (driver.findElement(password).isEnabled()) {
		return true;
	}
	else
	{
		return false;
	}
	
}
 
public void clickDropDown()
{
	driver.findElement(dropdown).click();
}
public void Logout()
{
	driver.findElement(Logout).click();
}
public void Login()
{
	driver.findElement(Login).click();
}



/*public String readTitle()
{
         return driver.getTitle();
}*/
/*
public Point  getPositionOfUsernamebox()   
{
	return driver.findElement(username).getLocation();
}
*/

public void clickLoginButton()
{
	driver.findElement(loginbutton).click();

	//System.out.println("Login success:" + home.checkLogoutButtonExists());
	
}

public String getLoginStatus()
{
	System.out.println(driver.findElement(loginstatus).getText());
	return driver.findElement(loginstatus).getText();
}


public String getFooterString()
{
	
	//System.out.println(driver.findElement(footerText).getText());
	//return footerText.toString();
	//return driver.findElement(footerText).getText();
	String footerString;
	try {
		footerString=driver.findElement(footerText).getText();
	}
	catch(NoSuchElementException e)
	{
		footerString="Not found";
	}
	return footerString;
}

public boolean isFooterFound()

{
	
	boolean found=false;
	try {
		
		found=driver.findElement(footerText).isDisplayed();
	}
	
	catch (NoSuchElementException e)
	{
		found=false;
	}
	
	return found;
	
}
//public void clickSignUp()
//{
//	driver.findElement(SignUpBotton).click();
//}*/



}
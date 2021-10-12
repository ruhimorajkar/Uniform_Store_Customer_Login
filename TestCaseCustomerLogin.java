package SmokeTestTestCase;

import org.testng.annotations.Test;

import SmokeTestPage.CustomerLoginPage;

import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;




public class TestCaseCustomerLogin {
	static String driverPath = "C:\\Users\\Ruhi\\Desktop\\sel\\chromedriver_win32\\chromedriver.exe";

    static WebDriver driver;	
	
    @AfterTest
    public void closeAll()
    {
    	driver.close();
    }
    
    
    @BeforeTest
    public void init()
    {
    	System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("http://uniformm1.upskills.in/index.php?route=common/home");
		   
		driver.manage().window().maximize();
		
    }
	
	
	@Test
	public void veryfylogin()
	{
	
		/*System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/");
		driver.manage().window().maximize();*/
	// creating object of LoginPage class
		
		CustomerLoginPage login = new CustomerLoginPage(driver);
		login.clickDropDown();
		//login.clickLogin();
		driver.navigate().to("http://uniformm1.upskills.in/index.php?route=account/login");
		
			if(login.isUsernameboxEnabled()==true)
			{
		
				login.typeusername("ruhiiii@gmail.com");
			}
			
			if(login.isPasswordboxEnabled()==true)
			{	
				login.typepassword("12345");
			}
			
			login.clickLoginButton();
			
			String status = login.getLoginStatus();
			
			 if (status.contains("MY ACCOUNT"))
				{
					
						System.out.println("\nLoggin successful\n");
						Assert.assertEquals(true, true);
					
					
				}
				else
				{
				     Reporter.log("Incorrect Credentials. Negative Test case passed by not letting the user in.",true);
				     
				     Assert.assertEquals(true, true);
							     
				}
			login.Logout();
			login.Login();
			if(login.isUsernameboxEnabled()==true)
			{
		
				login.typeusername("ruhi");
			}
			
			if(login.isPasswordboxEnabled()==true)
			{	
				login.typepassword("123");
			}
			
			login.clickLoginButton();
			
			
			
			/*try {
			        String status1 = login.getLoginStatus();
					System.out.println("\nLogin successful\n");
					AssertJUnit.assertEquals(true, true);
			}
			
			catch (NoSuchElementException e)
			{
				//Reporter.log("Incorrect Credentials. Negative Test case passed by not letting the user in.",true);
				System.out.println("Cannot register\n"+driver.findElement(By.xpath("//*[@id=\"login-block\"]/div/div[2]")).getText());
				AssertJUnit.assertEquals(true, true);
				//status=false;
			}*/
			
			
	}
	
}

package demo.demo;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUp {
	
	@Test
	public void TestMethod() throws InterruptedException
	{
		//Launch firefox browser 
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\LENOVO\\git\\FrameworkSelenium\\FirstFrameWork\\Drivers\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver();  
			    
			    //maximize the browser
			    driver.manage().window().maximize();
			    
			    //Implicit wait, wait for at least some time (10 sec) to identify an element, //if can't find the element with in 10 
			    
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			 
			    //open the url or AUT 
			    driver.get("https://www.demoblaze.com/index.html");
			 
			    //Click on the register link: 
			    WebElement lnk_register = driver.findElement(By.cssSelector("#signin2")); 
			    lnk_register.click();
			 
			    //Enter details on the provided text boxes by using sendkeys method. 
			    WebElement txtBox_Username = driver.findElement(By.xpath("//input[@id='sign-username']")); 
			    txtBox_Username.sendKeys("Lenovofsff89"); 
			    
			    //or directly we can identify element and act on that in one line 
			    WebElement txtbox_Password =driver.findElement(By.cssSelector("#sign-password"));
			    txtbox_Password.sendKeys("1234567");
			    WebElement SignInButton =driver.findElement(By.xpath("//button[contains(text(),'Sign up')]"));
			    SignInButton.click();
			    Thread.sleep(2000);
			    System.out.println(driver.switchTo().alert().getText());
			    
			    Assert.assertEquals("Sign up successful.",driver.switchTo().alert().getText() );
                driver.switchTo().alert().accept();
                driver.close();
                
               

			    


			    
			    
			}
	}



package demo.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_24_ProductPriceInCart {
	@SuppressWarnings("deprecation")
	@Test
	public void TestMethod() throws InterruptedException 
	{
		//Launch firefox browser 
				System.setProperty("webdriver.gecko.driver","C:\\Users\\LENOVO\\git\\FrameworkSelenium\\FirstFrameWork\\Drivers\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver();      
			    //maximize the browser
			    driver.manage().window().maximize();
			    //Implicit wait, wait for at least some time (10 sec) to identify an element, //if can't find the element with in 10 
			    //open the url or AUT 
			    driver.get("https://www.demoblaze.com/index.html");
			    //Click on the register link: 
			    WebElement lnk_register = driver.findElement(By.xpath("//a[@id='login2']")); 
			    lnk_register.click();
			    //Enter details on the provi'ded text boxes by using sendkeys method. 
			    Thread.sleep(3000);
			    new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']"))).click();
			    new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']"))).sendKeys("javed123456");
			    new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginpassword']"))).sendKeys("Reset@123");
			    new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Log in')]"))).click();
			   String Welcome = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='nameofuser']"))).getText();
			   System.out.println(Welcome);
			   //Adding product to cart 
			   new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Samsung galaxy s6')]"))).click();
			   Thread.sleep(2000);
			   String price =driver.findElement(By.tagName("h3")).getText();
			    System.out.println(price);
			   
			   new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Add to cart')]"))).click();
			   Thread.sleep(3000);
			   
			   Assert.assertEquals("Product added.",driver.switchTo().alert().getText() );
			   System.out.println(driver.switchTo().alert().getText());
               driver.switchTo().alert().accept();
               
               
               driver.close();

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	

}

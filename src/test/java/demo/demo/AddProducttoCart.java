package demo.demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProducttoCart {
	@SuppressWarnings("deprecation")
	@Test
	public void TestMethod() throws InterruptedException 
	{
		//Launch firefox browser 
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\LENOVO\\git\\FrameworkSelenium\\FirstFrameWork\\Drivers\\geckodriver.exe");
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
			   new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Add to cart')]"))).click();
			   Thread.sleep(3000);
			   Alert alert = driver.switchTo().alert();
                     alert.accept();
              new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='cartur']"))).click();      
              //Placing order 
              new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Place Order')]"))).click();      
     
              //Fill form for Purchase order 
              new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='name']"))).sendKeys("Name");      
              new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='country']"))).sendKeys("Countyry");      
              new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='city']"))).sendKeys("city");      
              new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='card']"))).sendKeys("card");      
              new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='month']"))).sendKeys("month");      
              new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='year']"))).sendKeys("year");      
              new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Purchase')]"))).click();      
            //h2[contains(text(),'Thank you for your purchase!')] 
              Thread.onSpinWait();
              String ThankYou = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]"))).getText();
			    
			    System.out.println(ThankYou);
			    Assert.assertEquals("Thank you for your purchase!",ThankYou);
			    driver.close();
	
	}
}


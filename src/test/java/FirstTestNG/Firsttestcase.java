package FirstTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Firsttestcase {
       @Test(priority=1)
       
      public void login() throws InterruptedException {
    	   WebDriverManager.chromedriver().setup();
    	   WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://magento.com");
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.id("email")).sendKeys("vinnygeoffrey@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("vinny");
		driver.findElement(By.id("send2")).click();
		Thread.sleep(3000);
		String error_msg=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
		//checking True or False, error 
		
		Assert.assertEquals(error_msg,"Invalid login or password.");
{
	System.out.println("Test passed");
}
	driver.quit();	
       }
       

   @Test(priority=2,enabled=false)
   
   public void register() throws InterruptedException {
	   WebDriverManager.chromedriver().setup();
	   WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://magento.com");
	driver.findElement(By.className("account-icon")).click();
	//driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
	driver.findElement(By.id("register")).click();
	driver.findElement(By.id("firstname")).sendKeys("Vinny");
	driver.findElement(By.id("lastname")).sendKeys("Xavier");
	driver.findElement(By.id("email_address")).sendKeys("vinnygeoffrey@gmail.com");
	driver.findElement(By.id("self_defined_company")).sendKeys("private");
	
	//For dropdowns,initialize select class
	//selectByValue,selectByIndex,selectByVisibleText
	
	Thread.sleep(3000);
	Select Compprime=new Select(driver.findElement(By.id("company_type")));
	Compprime.selectByValue("selling");
	Select myrole=new Select(driver.findElement(By.id("individual_role")));
	myrole.selectByIndex(1);
	Select Country=new Select(driver.findElement(By.id("country")));
	Country.selectByVisibleText("Germany");
					
	driver.findElement(By.id("password")).sendKeys("Magento@123%");
	driver.findElement(By.id("password-confirmation")).sendKeys("Magento@123%");
	//switching to window frames
	
	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"recaptcha-f979c2ff515d921c34af9bd2aee8ef076b719d03\"]/div/div/iframe")));
	driver.findElement(By.className("recaptcha-checkbox-border")).click();
	driver.switchTo().defaultContent();
	
	if(!driver.findElement(By.id("agree_terms")).isSelected());
	{
	driver.findElement(By.id("agree_terms")).click();
	}
	System.out.println("registration done");
	//driver.close();
}

}

       
       
       


package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class GenericMethods extends AppUtils{
	
	public static  void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public static void threadWait() throws InterruptedException
	{
		Thread.sleep(5);
	}
	

}

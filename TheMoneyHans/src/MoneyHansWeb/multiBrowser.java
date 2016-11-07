//package MoneyHans;
package MoneyHansWeb;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import MoneyHans.appMethods;

public class multiBrowser {

	public String appURL;
	public WebDriver driver1;
	appMethods ap = new appMethods();
	
	@BeforeTest
	public void setDriver() throws MalformedURLException
	{
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WIN10);
		//driver1 = new RemoteWebDriver(new URL("http://192.168.56.1:5566/wd/hub"),cap);
		appURL = "http://www.themoneyhans.com";
	}
		
	@Test
	public void verifyOnFirefox() throws InterruptedException
	{  
		driver1 = new FirefoxDriver();
		driver1.get(appURL);
		String expTitle = "-The Money Hans";
		String actTitle = driver1.getTitle();
		Assert.assertEquals(expTitle,actTitle);
		
		ap.navigateFunMoneyPage(driver1);
		ap.validateBlogDiscussions(driver1);
		ap.clickCommentsLink(driver1);
		ap.validateSocialMediaLinks(driver1);
		
	}
	
	@AfterTest
	public void afterTest() 
	{
		driver1.close();
	}
}

package MoneyHans;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import MoneyHans.appMethods;

//import WebServices.*;

public class moneyHansChrome {

	public String appURL;
	public WebDriver driver;
	
	appMethods ft = new appMethods();
	WebServices ws = new WebServices();
	
	@BeforeClass
	public static void ClassSetUp()
	{
		File file = new File("E://chromedriver_win32//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		//System.setProperty("webdriver.chrome.driver", "E://chromedriver_win32//chromedriver.exe");
	}
	
	@BeforeTest
	public void setDriver() throws MalformedURLException
	{
		/*DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		driver = new RemoteWebDriver(new URL("http://192.168.56.1:5566/wd/hub"),cap);*/
		appURL = "http://www.themoneyhans.com";
	}
	
	@Test
	public void verifyOnChrome() throws Exception
	{
		File file = new File("E://chromedriver_win32//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get(appURL);
		String expTitle = "-The Money Hans";
		String actTitle = driver.getTitle();
		Assert.assertEquals(expTitle,actTitle);	
		
		Thread.sleep(5000);
		ft.navigateFunMoneyPage(driver);
		Thread.sleep(5000);
		ft.validateBlogDiscussions(driver);
		Thread.sleep(5000);
		ft.clickCommentsLink(driver);
		Thread.sleep(5000);
		ft.validateSocialMediaLinks(driver);
		
		String actURL = null;
		//validate web serices
		String sURL = ws.aptTesting(actURL);
		
		System.out.println(sURL);
		String expPage = driver.findElement(By.cssSelector(".img-responsive")).getAttribute("src");//.getText();//toString();
		System.out.println(expPage);
		
		Assert.assertEquals(expPage, sURL);
		
	}
		
	@AfterTest
	public void afterTest() 
	{
		driver.close();
	}
}

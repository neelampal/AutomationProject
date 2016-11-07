package MoneyHans;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import MoneyHans.appMethods;

public class moneyHansMicrooftEdge 
{
		public String appURL;
		public WebDriver driver2;
		DesiredCapabilities cap;
		
		appMethods ft = new appMethods();
		
		@BeforeClass
		public static void ClassSetUp()
		{
			/*File file = new File("E://Android//MicrosoftWebDriver.exe");
			System.setProperty("webdriver.edge.driver", file.getAbsolutePath());*/
			//System.setProperty("webdriver.edge.driver", "E://Android//MicrosoftWebDriver.exe");
		    /*DesiredCapabilities capabilities = new DesiredCapabilities("MicrosoftEdge", "", Platform.WINDOWS);
		    driver2 = new EdgeDriver(capabilities);*/
			//System.setProperty("webdriver.edge.driver", "C://Softwares/MicrosoftWebDriver(1).exe");
		}
		
		@BeforeTest
		public void setDriver() throws MalformedURLException
		{
			File file = new File("E://Softwares//Softwares//MicrosoftWebDriver.exe");
			System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
			cap = DesiredCapabilities.edge();//internetExplorer();
			cap.setBrowserName("MicrosoftEdge");
			cap.setPlatform(Platform.WINDOWS);
			driver2 = new RemoteWebDriver(new URL("http://192.168.56.1:5566/wd/hub"),cap);
			appURL = "http://www.themoneyhans.com";
		}
		
		@Test
		public void verifyOnMicrosoftEdge() throws InterruptedException
		{
			/*File file = new File("E://Softwares//Softwares//MicrosoftWebDriver.exe");
			System.setProperty("webdriver.edge.driver", file.getAbsolutePath());*/
			//DesiredCapabilities capabilities = new DesiredCapabilities("MicrosoftEdge", "", Platform.WINDOWS);
		    driver2 = new EdgeDriver(cap);
			//driver2 = new EdgeDriver();
			driver2.get(appURL);
			Thread.sleep(10000);
			String expTitle = "-The Money Hans";
			String actTitle = driver2.getTitle();
			Assert.assertEquals(expTitle,actTitle);	
			
			Thread.sleep(5000);
			ft.navigateFunMoneyPage(driver2);
			ft.validateBlogDiscussions(driver2);
			ft.clickCommentsLink(driver2);
			ft.validateSocialMediaLinks(driver2);
		}
			
		@AfterTest
		public void afterTest() 
		{
			driver2.close();
		}

}

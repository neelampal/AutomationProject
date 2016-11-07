/*package testScripts;

import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.Assert;

public class webApplication 
{

	WebDriver driver, driver1, driver2;
	String appURL, nodeURL, nodeURL1;
	
	@BeforeTest
	public void setUp() throws MalformedURLException 
	{
		appURL = "http://www.themoneyhans.com";
		nodeURL = "http://192.168.56.1:5566/wd/hub";
		nodeURL1 = "http://192.168.56.1:5566/wd/hub";
		
		//Firefox
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WIN10);
		System.out.println("11111");
		//driver = new RemoteWebDriver(new URL(nodeURL), cap);
		
		 * 11111
Nov 06, 2016 10:24:15 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Attempting bi-dialect session, assuming Postel's Law holds true on the remote end


		 
		driver = new RemoteWebDriver(new URL(nodeURL1), cap);
		
		System.out.println("22222");
		
		//Chrome
		DesiredCapabilities cap1 = DesiredCapabilities.chrome();//firefox();
		System.out.println("333333");

		cap1.setBrowserName("chrome");
		cap1.setPlatform(Platform.WIN10);
		System.out.println("44444");

		//driver1 = new RemoteWebDriver(new URL(nodeURL), cap1);
		driver1 = new RemoteWebDriver(new URL(nodeURL1), cap1);
		System.out.println("6666");

		//Edge
		DesiredCapabilities cap2 = DesiredCapabilities.edge();
		cap2.setBrowserName("edge");
		System.out.println("77777");

		cap2.setPlatform(Platform.WINDOWS);
		System.out.println("88888");

		driver2 = new RemoteWebDriver(new URL(nodeURL), cap2);
		System.out.println("9999");

		//driver2 = new RemoteWebDriver(new URL(nodeURL1), cap2);
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}
	
	@Test
	public void moneyHansTestCase()
	{
		//Step 1: Navigate to website
		//driver.get(appURL);
		System.out.println("101010");
		driver1.get(appURL);
		System.out.println("111111");

		driver2.get(appURL);
		Assert.assertEquals("-The Money Hans", driver.getTitle());
		
		//Step 2: 
		
	}
}	









package testScripts;


import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;

import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.util.Strings;
import org.testng.Assert;

public class webApplication 
{
	WebDriver driver, driver1, driver2;
	Strings appURL, nodeURL, nodeURL1;
	
	@BeforeTest
	public void setUp() throws MalformedURLException 
	{
		appURL = "http://www.themoneyhans.com";
		nodeURL = "http://192.168.56.1:5566/wd/hub";
		nodeURL1 = "http://192.168.56.1:5566/wd/hub";
		
		//Firefox
		/*DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WIN10);
		System.out.println("11111");
		//driver = new RemoteWebDriver(new URL(nodeURL), cap);
		
		 * 11111
Nov 06, 2016 10:24:15 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Attempting bi-dialect session, assuming Postel's Law holds true on the remote end


		 
		driver = new RemoteWebDriver(new URL(nodeURL1), cap);
		
		System.out.println("22222");
		
		//Chrome
		DesiredCapabilities cap1 = DesiredCapabilities.chrome();//firefox();
		System.out.println("333333");

		cap1.setBrowserName("chrome");
		cap1.setPlatform(Platform.WIN10);
		System.out.println("44444");

		//driver1 = new RemoteWebDriver(new URL(nodeURL), cap1);
		driver1 = new RemoteWebDriver(new URL(nodeURL1), cap1);
		System.out.println("6666");

		//Edge
		DesiredCapabilities cap2 = DesiredCapabilities.edge();
		cap2.setBrowserName("edge");
		System.out.println("77777");

		cap2.setPlatform(Platform.WINDOWS);
		System.out.println("88888");

		driver2 = new RemoteWebDriver(new URL(nodeURL), cap2);
		System.out.println("9999");

		//driver2 = new RemoteWebDriver(new URL(nodeURL1), cap2);
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}
	
	@Test
	public void moneyHansTestCase()
	{
		//Step 1: Navigate to website
		//driver.get(appURL);
		System.out.println("101010");
		driver1.get(appURL);
		System.out.println("111111");

		driver2.get(appURL);
		Assert.assertEquals("-The Money Hans", driver.getTitle());
		
		//Step 2: 
		
	}
}

}
*/
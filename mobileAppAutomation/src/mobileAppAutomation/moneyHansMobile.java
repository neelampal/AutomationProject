package mobileAppAutomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class moneyHansMobile {

 WebDriver driver;

 @BeforeTest
 public void setUp() throws MalformedURLException {
	 
	 String apkpath = "E:\\Softwares\\Softwares\\com.android.chrome.apk";
	    File app = new File (apkpath);
	    
  // Created object of DesiredCapabilities class.
  DesiredCapabilities capabilities = new DesiredCapabilities();

  // Set android deviceName desired capability. Set your device name.
  capabilities.setCapability("deviceName", "FA48KMZ02127");

  // Set BROWSER_NAME desired capability. It's Android in our case here.
  capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

  System.out.println("12344");
  // Set android VERSION desired capability. Set your mobile device's OS version.
  capabilities.setCapability(CapabilityType.VERSION, "6.0");
// 1 min.... connecting through skype 1 min .. 
  // Set android platformName desired capability. It's Android in our case here.
  capabilities.setCapability("platformName", "Android");
  
  capabilities.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());

  // Set androrkwoid appPackage desired capability. It is
  // com.android.calculator2 for calculator application.
  // Set your application's appPackage if you are using any other app.
  capabilities.setCapability("appPackage", "com.android.chrome");

  // Set android appActivity desired capability. It is
  // com.android.calculator2.Calculator for calculator application.
  // Set your application's appPackage if you are using any other app.
  //capabilities.setCapability("appActivity", "com.android.chrome");
  capabilities.setCapability("appActivity", "org.chromium.chrome.browser.ChromeTabbedActivity");

  // Created object of RemoteWebDriver will all set capabilities.
  // Set appium server address and port number in URL string.
  // It will launch calculator app in android device.
  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4727/wd/hub"), capabilities);
  //driver = new AppiumDriver(new URL("http://127.0.0.1:4727/wd/hub"), capabilities);
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 }

 @Test
 public void mobileTest() throws InterruptedException {
	 
	System.out.println("AAAA"); 
  // Click on DELETE/CLR button to clear result text box before running test.
  driver.get("http://www.themoneyhans.com");
  System.out.println("BBBB");
  String expTitle = "-The Money Hans";
  String actTitle = driver.getTitle();
  System.out.println(actTitle);
  //Assert.assertEquals(expTitle,actTitle);	
  Thread.sleep(3000);
  System.out.println("CCCC");
  driver.get("http://www.themoneyhans.com/category/fun-money-roof");
  Thread.sleep(3000);
  driver.get("http://www.themoneyhans.com/articles/fun-money-roof/put-your-eggs-in-one-basket...");
  System.out.println("Mobile App Tested");
  driver.close();
  
 }

@AfterTest
 public void End() {
  driver.quit();
 }
}



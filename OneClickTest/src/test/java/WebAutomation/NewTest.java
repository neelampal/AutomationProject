package WebAutomation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import WebAutomation.WebServicesMethods;
import WebAutomation.appSpecificMethods;

public class NewTest
{
	public WebDriver driver;
	String appURL = "heep://www.themoneyhans.com";
	appSpecificMethods ft = new appSpecificMethods();
	WebServicesMethods ws = new WebServicesMethods();
	
	  @Test
	  public void firefoxBrowser() throws Exception 
	  {
		
		  beforeTest("firefox");		  
		  String expTitle = "-The Money Hans";
		  String actTitle = driver.getTitle();
		  AssertJUnit.assertEquals(expTitle,actTitle);	
			
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
			
		  AssertJUnit.assertEquals(expPage, sURL);
	  }
	  
	  @Test
	  public void ChromeBrowser() throws Exception 
	  {
		
		  beforeTest("chrome");		  
		  String expTitle = "-The Money Hans";
		  String actTitle = driver.getTitle();
		  AssertJUnit.assertEquals(expTitle,actTitle);	
			
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
			
		  AssertJUnit.assertEquals(expPage, sURL);
	  }
  
	  @Test
	  public void edgeBrowser() throws Exception 
	  {
		
		  beforeTest("edge");		  
		  String expTitle = "-The Money Hans";
		  String actTitle = driver.getTitle();
		  AssertJUnit.assertEquals(expTitle,actTitle);	
			
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
			
		  AssertJUnit.assertEquals(expPage, sURL);
	  }
	  
	  //@Parameters("browser")	
	  @BeforeTest
	  public void beforeTest(String browser) 
	  {
		  // If the browser is Firefox, then do this
	 	  if(browser.equalsIgnoreCase("firefox"))
	 	  {
	 		  driver = new FirefoxDriver();
	 	  // If browser is Edge, then do this	  
	 	  }
	 	  else if (browser.equalsIgnoreCase("edge")) 
	 	  { 
	 		  // Here I am setting up the path for my IEDriver
	 		  System.setProperty("webdriver.edge.driver", "E://Softwares//Softwares//MicrosoftWebDriver.exe");
	 		  driver = new EdgeDriver();
	 	  }
	 	 else if (browser.equalsIgnoreCase("chrome")) 
	 	  { 
	 		  // Here I am setting up the path for my IEDriver
	 		  System.setProperty("webdriver.chrome.driver", "E://chromedriver_win32//chromedriver.exe");
	 		  driver = new ChromeDriver();
	 	  }
	 	  driver.get(appURL);
	  }
  
	  @AfterTest
	  public void afterTest() 
	  {
		  driver.quit();
	  }
}

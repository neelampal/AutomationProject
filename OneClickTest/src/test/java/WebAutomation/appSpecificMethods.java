package WebAutomation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class appSpecificMethods 
{
	/* Step1: Navigate to Fun-Money Roof Page */
	public void navigateFunMoneyPage(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		//Navigate to fun-money roof page
		driver.findElement(By.cssSelector("#nav > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")).click();
        // Validate Title of the fun money roof page
        WebDriverWait waitVar = new WebDriverWait(driver, 30);
        waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#discussion-nav > h2")));
        String actTitle = driver.findElement(By.cssSelector("h1.ng-binding")).getText();
        System.out.println(actTitle);
        Assert.assertEquals("Fun Money Roof", actTitle);
	}
	
	/*Step2: Validate Blog and Discussions section*/
	public void validateBlogDiscussions(WebDriver driver)
	{
		String actBlog = driver.findElement(By.cssSelector("h2")).getText();
        System.out.println(actBlog);
        Assert.assertEquals("Blog", actBlog);
        //Validate Discussions Section
        String actDiscussions = driver.findElement(By.cssSelector("#discussion-nav > h2")).getText();
        System.out.println(actDiscussions);
        Assert.assertEquals("Discussions", actDiscussions);
	}
	
	/*Step3: Validate "Put your eggs in one basket" section is displayed with comments link. Click on arrow buttons for comments*/
	public void clickCommentsLink(WebDriver driver) throws InterruptedException
	{
		String actEggs = driver.findElement(By.cssSelector("h3")).getText();
	    System.out.println(actEggs);
	    actEggs = actEggs.trim();
	    Assert.assertEquals("WANT TO GET REALLY RICH? PUT YOUR EGGS IN ONE BASKET...", actEggs);
	    //Click on Comments section
        driver.findElement(By.cssSelector(".arrow-articale > a:nth-child(1) > img:nth-child(1)")).click();
        Thread.sleep(5000);
	}
	
	/*Step4: Validate Twitter, linked in, google plus and mail box options are available*/
	public void validateSocialMediaLinks(WebDriver driver)
	{
		Boolean actTwitter1 = driver.findElement(By.cssSelector("a.twitter")).isDisplayed();
        System.out.println("Twitter is displayed or not: "+actTwitter1);
	}	
}

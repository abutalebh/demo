package com.wwatchers.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class weightwatchers {

	public WebDriver driver;
	@BeforeTest
	public void openApplication()
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	  String url = "https://www.weightwatchers.com/us/";
	 
	    driver.manage().window().maximize();
	    driver.get(url);
	}
	@Test(priority=0)
	  public void WeightLossProgram() {
	  
		String sExpected = "Weight Loss Program, Recipes & Help | Weight Watchers";
	String actualresult = driver.getTitle();
	org.testng.Assert.assertEquals(actualresult, sExpected);
	  }
	
	@Test(priority=1)
	  public void FindaMeeting() throws InterruptedException {
		
		String sExpected = "Get Schedules & Times Near You";
		driver.findElement(By.className("find-a-meeting")).click();
	String actualresult = driver.getTitle();
	org.testng.Assert.assertTrue(actualresult.contains(sExpected));
	
	WebElement zip =driver.findElement(By.id("meetingSearch"));
	zip.sendKeys("10011");
	zip.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	WebElement firstlocation =driver.findElement(By.className("location__top"));
	System.out.println(firstlocation.getText());
	
	driver.findElement(By.className("meeting-location")).click();
	
	Thread.sleep(2000);
	WebElement firstlocationverify =driver.findElement(By.className("location__top"));
	System.out.println(firstlocationverify.getText());
	
	//WebElement hours =driver.findElement(By.className("schedule-detailed-day"));
	WebElement hours =driver.findElement(By.xpath(".//*[@id='content']/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[1]/div/div/schedule-detailed/div/div[3]"));
	System.out.println(hours.getText());
	

	
	
	}
}

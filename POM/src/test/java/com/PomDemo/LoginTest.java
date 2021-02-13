package com.PomDemo;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {
	Logger log= Logger.getLogger(LoginTest.class);
	WebDriver driver;
	LoginPage lp=null;
	DashBoard dd=null;
	
	@BeforeMethod
	public void setUp() {
		
		log.info("intialize browser");
		System.setProperty("webdriver.chrome.drive", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		log.info("chrome browser opened");
		driver.get("C:/Users/Akshata-PC/Downloads/Offline%20Website/Offline%20Website/index.html");
		log.info("JBK offline app launched");
		lp=new LoginPage(driver);
		dd=new DashBoard(driver);
		log.info("closing the browser");
	}
	@AfterMethod
     	public void tearDown() {
		log.info("closing the browser");
		driver.close();
    }
	
	@Test// tester working login page
	public void validLoginTest() {
		log.info("logging into the application");
		lp.enterUname("mangesh@gmail.com");
		lp.enterPass("123456");
		lp.clickLogin();
		log.info("entering into the application");
	}
	
	@Test// tester working on Dashboard page
	public void test02() {
		log.info("dashboard displayed");
		lp.ValidLogin();
		dd.getCourses();
		Assert.assertEquals(driver.getTitle(),lp.getTitle());
	}
}

package testNG;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
public class EchoTrackParam 
{
	WebDriver driver;
	String exp="Invalid Username/Password",act;
	@Parameters({"un","pwd"})
	@Test
	public void echoTrakLogin(String un, String pwd) 
	{  
		driver.findElement(By.id("txtCustomerID")).sendKeys(un);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("Butsub")).click();
	}
	@AfterMethod
	public void afterMethod() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		act = driver.findElement(By.id("lblMsg")).getText();
		Assert.assertEquals(act, exp);
		driver.findElement(By.id("txtCustomerID")).clear();
		driver.findElement(By.id("txtPassword")).clear();
	}
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.echotrak.com");
	}
	@AfterTest
	public void afterTest() {
		driver.close();
	}
}

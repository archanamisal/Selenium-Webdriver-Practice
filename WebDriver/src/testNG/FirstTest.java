package testNG;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class FirstTest

{


	private WebDriver driver;


	@Test(priority=2)

	public void visitGoogle() {

		driver.get("http://www.google.com");

		System.out.println("Title: "+driver.getTitle());

	}

	@Test(priority=1)

	public void visitYahoo(){

		driver.get("http://www.yahoo.com");

		System.out.println("Title: "+driver.getTitle());

	}


	@Test(priority=3)

	public void visitLive(){

		driver.get("http://www.live.com");

		System.out.println("Title: "+driver.getTitle());

	}

	@BeforeTest

	public void beforeTest()
	{
		System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().window().maximize();

	}


	@AfterTest

	public void afterTest(){

		driver.close();

	}

}
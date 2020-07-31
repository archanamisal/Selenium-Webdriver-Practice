package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch {


	public static void main(String[] args) /*throws InterruptedException*/ {
		System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.findElement(By.id("lst-ib")).sendKeys("seed");
		/*FluentWait<WebDriver> fw = new FluentWait<WebDriver>(driver);
		fw.withTimeout(20, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class)
		.pollingEvery(1, TimeUnit.NANOSECONDS)
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='sbse0']/div[2]"))).click();
		//Thread.sleep(2000);*/
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='sbse0']/div[2]"))).click();
		//driver.findElement(By.xpath("//*[@id='sbse0']/div[2]")).click();
	}
}
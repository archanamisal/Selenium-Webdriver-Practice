package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchingFireFox {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		//System.out.println("URL: "+driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		System.out.println("Title: "+driver.getTitle());
		//driver.close();
		driver.quit();
	}

}

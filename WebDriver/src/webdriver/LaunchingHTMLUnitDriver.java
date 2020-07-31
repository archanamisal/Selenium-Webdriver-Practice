package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class LaunchingHTMLUnitDriver {

	public static void main(String[] args) {
	
		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.close();
	}

}

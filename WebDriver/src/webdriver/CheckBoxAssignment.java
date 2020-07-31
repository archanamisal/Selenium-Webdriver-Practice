package webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBoxAssignment {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.echoecho.com/htmlforms09.htm");
		List<WebElement> cbs = driver.findElements(By.xpath("//td[@class='table5']/input"));
		System.out.println("Default Status:");
		for(WebElement we : cbs){
			System.out.println(we.getAttribute("value"));
			System.out.println("IsDisplayed: "+we.isDisplayed());
			System.out.println("IsEnabled: "+we.isEnabled());
			System.out.println("IsSelected: "+we.isSelected());
			System.out.println("-----------------------------------------");
		}
		for(WebElement we : cbs){
			we.click();
		}
		System.out.println("Status after clicking:");
		for(WebElement we : cbs){
			System.out.println(we.getAttribute("value"));
			System.out.println("IsDisplayed: "+we.isDisplayed());
			System.out.println("IsEnabled: "+we.isEnabled());
			System.out.println("IsSelected: "+we.isSelected());
			System.out.println("-----------------------------------------");
		}
		driver.close();
	}

}

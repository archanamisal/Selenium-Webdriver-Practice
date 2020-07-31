package webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioAssignment {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.echoecho.com/htmlforms10.htm");
	List<WebElement> radios = driver.findElements(By.name("group1"));
		System.out.println("Default Status");
		for(WebElement we : radios){
			System.out.println(we.getAttribute("value"));
			System.out.println("Is Displayed: "+we.isDisplayed());
			System.out.println("Is Enabled: "+we.isEnabled());
			System.out.println("Is Selected: "+we.isSelected());
			System.out.println("-------------------------------------");
		}
		radios.get(0).click();
		System.out.println("After clicking:");
		for(WebElement we : radios){
			System.out.println(we.getAttribute("value"));
			System.out.println("Is Displayed: "+we.isDisplayed());
			System.out.println("Is Enabled: "+we.isEnabled());
			System.out.println("Is Selected: "+we.isSelected());
			System.out.println("-------------------------------------");
		}
		driver.close();
	}
}
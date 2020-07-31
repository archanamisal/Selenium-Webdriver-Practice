package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingRadios {


	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		WebElement radio =driver.findElement(By.xpath(".//*[@id='wrapper']/table[2]/tbody/tr[26]/td[3]/input[1]"));
		System.out.println(((JavascriptExecutor)driver).executeScript("return arguments[0].value",radio).toString());
		//System.out.println(driver.findElement(By.xpath(".//*[@id='wrapper']/table[2]/tbody/tr[26]/td[3]/input[1]")).getText());
		/*WebElement radio = driver.findElement(By.cssSelector("input[name^='gender']"));
		System.out.println("WebElement: "+radio.getAttribute("value"));
		System.out.println("Is Displayed: "+radio.isDisplayed());
		System.out.println("Is Enabled: "+radio.isEnabled());
		System.out.println("Is Selected: "+radio.isSelected());*/
		driver.close();
	}
}
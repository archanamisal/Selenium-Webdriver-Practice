package webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingListBox {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("D:\\MultiSelect.html");
		WebElement lb = driver.findElement(By.name("cars"));
		Select cars = new Select(lb);
		System.out.println("Is Multiple: "+cars.isMultiple());
		cars.selectByIndex(3);
		cars.selectByIndex(0);
		List<WebElement> selOps = cars.getAllSelectedOptions();
		for(WebElement we : selOps){
			System.out.println(we.getText());
		}
		System.out.println("First Selected Option: "+cars.getFirstSelectedOption().getText());
		driver.close();
	}
}

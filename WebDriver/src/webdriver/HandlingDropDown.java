package webdriver;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropDown {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		WebElement dd = driver.findElement(By.id("country"));
		Select country = new Select(dd);
		System.out.println("Is Multiple: "+country.isMultiple());
		System.out.println("Default Option: "+country.getFirstSelectedOption().getText());
		//country.selectByIndex(3);
		//country.selectByValue("5");
		country.selectByVisibleText("Angola");
		System.out.println("Selected Option: "+country.getFirstSelectedOption().getText());
		/*List<WebElement> options=country.getOptions();
		int i=1;
		for(WebElement we : options){
			System.out.println(i+". "+we.getText());
			i++;
		}*/
		driver.close();
	}

}

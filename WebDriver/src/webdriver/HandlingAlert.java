package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingAlert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "Please enter a valid user name";
		System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		//driver.findElement(By.name("proceed")).click();
		
		driver.findElement(By.name("proceed")).sendKeys(Keys.RETURN);
		
		Alert a = driver.switchTo().alert();
		if(a.getText().equals(exp)){
			System.out.println("Pass");
		}
		else{
			System.out.println("Fail");
		}
		a.accept();
		//a.dismiss();
		driver.switchTo().defaultContent();
		driver.close();
	}
}

package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AmericanGolf {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.americangolf.co.uk/");
		WebElement gc = driver.findElement(By.linkText("Golf Clubs"));
		Actions act = new Actions(driver);
		act.moveToElement(gc).perform();
		WebElement mens = driver.findElement(By.linkText("Mens"));
		act.moveToElement(mens).perform();
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='CLUBS_2']/div[1]/ul[2]/li/ul/li[2]/ul/li/a"));
		System.out.println("No. of links: "+links.size());
		for(WebElement we : links){
			System.out.println(we.getText());
		}
	}
}
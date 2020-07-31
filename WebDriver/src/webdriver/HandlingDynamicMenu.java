package webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingDynamicMenu {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Random r = new Random();
		int x = r.nextInt(1000); // 0 - 999
		System.out.println(x);*/
		System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.istqb.in/");
		Actions act = new Actions(driver);
		WebElement foundation = driver.findElement(By.xpath("//*[@id='menu640']/span"));
		act.moveToElement(foundation).perform();
		List<WebElement> items = driver.findElements(By.xpath("//div[@id='ja-megamenu']/ul/li[3]/div/div/div/div/ul/li/a"));
		for(WebElement we : items){
			System.out.println(we.getAttribute("title"));
		}
		Random r = new Random();
		int x = r.nextInt(items.size());
		items.get(x).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		driver.close();
	}
}

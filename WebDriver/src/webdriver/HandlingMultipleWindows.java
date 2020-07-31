package webdriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingMultipleWindows {

	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.jobserve.com");
		System.out.println("Window Handle: "+driver.getWindowHandle());
		driver.findElement(By.id("SPBApplyBtn")).click();
		Set<String> winIds = driver.getWindowHandles();
		Iterator<String> itr = winIds.iterator();
		System.out.println("First Window Handle: "+itr.next());
		System.out.println("Second Window Handle: "+itr.next());
		itr=winIds.iterator();
		String firstWindow = itr.next();
		String secondWindow = itr.next();
		driver.switchTo().window(secondWindow);
		System.out.println("Title of second window: "+driver.getTitle());
		
		driver.findElement(By.id("filCV")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
		Thread.sleep(2000);
		
		driver.switchTo().window(firstWindow);
		System.out.println("Title of first window: "+driver.getTitle());
		driver.quit();
	}
}

package webdriver;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.gmail.com");
		//String h1=driver.findElement(By.xpath("html/body/div/div[2]/div[1]/h1")).getText();
		String h1=driver.findElement(By.xpath("//div[@class='banner']/h1")).getText();
		System.out.println(h1);
		driver.close();
		/*CSSSelector other special symbols
		 * ^ = starts with
		 * $ = Ends with
		 * * = Contains
		 */
		//driver.findElement(By.cssSelector("input[id^='lst']")).sendKeys("seed");
		/*driver.findElement(By.cssSelector("input[id$='ib']")).sendKeys("seed");
		driver.findElement(By.cssSelector("input[id*='t-i']")).sendKeys("seed");*/
		/* CSSSelector Special Symbols:
		 * . for class
		 * # for ID 
		/
		driver.findElement(By.cssSelector("input#lst-ib")).sendKeys("seed");
		driver.findElement(By.cssSelector("#lst-ib")).sendKeys("seed");*/
		/*driver.findElement(By.cssSelector("input.gsfi")).sendKeys("seed");
		driver.findElement(By.cssSelector("input.lst-d-f")).sendKeys("seed");
		driver.findElement(By.cssSelector("input.gsfi.lst-d-f")).sendKeys("seed");
		driver.findElement(By.cssSelector("input.lst-d-f.gsfi")).sendKeys("seed");
		driver.findElement(By.cssSelector(".gsfi")).sendKeys("seed");
		driver.findElement(By.cssSelector(".lst-d-f")).sendKeys("seed");
		driver.findElement(By.cssSelector(".gsfi.lst-d-f")).sendKeys("seed");
		driver.findElement(By.cssSelector(".lst-d-f.gsfi")).sendKeys("seed");*/
		  /*CSSSelector Multiple attributes
		 tagname[attribute='value'][attribute='value']
		 */
		//driver.findElement(By.cssSelector("input[type='text'][title='Search']")).sendKeys("seed");
		/*CSSSelector Syntax:
		 * Single attribute
		 tagname[attribute='value']
		//driver.findElement(By.cssSelector("input[title='Search']")).sendKeys("seed");
		
		/*List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No. of links: "+links.size());
		for(WebElement we : links){
			System.out.println(we.getText());
		}
		for(int i=0;i<links.size();i++){
			System.out.println(links.get(i).getText());
		}*/
		//driver.findElement(By.partialLinkText("mag")).click();
		//driver.findElement(By.linkText("Gmail")).click();
		//driver.findElement(By.id("lst-ib")).sendKeys("seed");
		//driver.findElement(By.name("q")).sendKeys("seed");
		//driver.findElement(By.className("gsfi")).sendKeys("seed");
		//driver.findElement(By.className("lst-d-f")).sendKeys("seed");
		
	}

}

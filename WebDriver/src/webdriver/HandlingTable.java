package webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingTable {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		String exp="PTC India";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		List<WebElement> cnames=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]/a"));
		int i;
		for(i=0;i<cnames.size();i++){
			if(cnames.get(i).getText().equalsIgnoreCase(exp)){
				System.out.println(exp+" found at "+(i+1)+" position");
				System.out.println(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+(i+1)+"]")).getText());
				break;
			}
			i++;
		}
		if(i>=cnames.size()){
			System.out.println("Company not found.");
		}
		/*List<WebElement> headings = driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
		System.out.println("Table Headings:");
		for(WebElement we : headings){
			System.out.println(we.getText());
		}*/
		driver.close();
	}
}

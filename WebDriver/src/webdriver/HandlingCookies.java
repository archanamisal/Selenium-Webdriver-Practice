package webdriver;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingCookies {


	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.flipkart.com");
		Cookie myck = new Cookie("SEED","Infotech");
		driver.manage().addCookie(myck);
		//driver.manage().deleteCookieNamed("T");
		/*Cookie ck = driver.manage().getCookieNamed("T");
		System.out.println(ck);*/
		/*driver.manage().deleteAllCookies();*/
		Set<Cookie> allCookies = driver.manage().getCookies();
		System.out.println("No. of cookies: "+allCookies.size());
		for(Cookie ck : allCookies){
			System.out.println("Name: "+ck.getName());
			System.out.println("Domain: "+ck.getDomain());
			System.out.println("Expiry: "+ck.getExpiry());
			System.out.println("Path: "+ck.getPath());
			System.out.println("Value: "+ck.getValue());
			System.out.println("Is HTTP Only: "+ck.isHttpOnly());
			System.out.println("Is Secured: "+ck.isSecure());
			System.out.println("------------------------------------------------");
		}
		driver.close();
	}
}

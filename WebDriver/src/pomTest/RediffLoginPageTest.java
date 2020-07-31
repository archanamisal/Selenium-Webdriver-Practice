package pomTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import pomPage.RediffLoginPage;

public class RediffLoginPageTest {
	private WebDriver driver;
	private RediffLoginPage rlp;
  @Test
  public void checkAlert() {
	  rlp.setUname("seed");
	  rlp.clickOnGo();
	  rlp.validateAlert();
  }
  @Test
  public void checkStatus(){
	  rlp.checkStatusofcb();
  }
  @Test
  public void checkCreateAcLink(){
	  rlp.newAccount();
	  System.out.println("Title: "+driver.getTitle());
	  System.out.println("URL: "+driver.getCurrentUrl());
	  driver.navigate().back();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	  rlp = new RediffLoginPage(driver);
  }
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}

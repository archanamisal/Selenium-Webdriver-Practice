package google;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
public class GoogleLinks {
	private WebDriver driver;
  @Test(groups="Bottom")
  public void Business() {
	  driver.findElement(By.linkText("Business")).click();
  }
  @Test(groups="Bottom")
  public void Advertising() {
	  driver.findElement(By.linkText("Advertising")).click();
  }
  @Test(groups="Bottom")
  public void About() {
	  driver.findElement(By.linkText("About")).click();
  }
  @Test(groups="Top")
  public void Gmail() {
	  driver.findElement(By.linkText("Gmail")).click();
  }
  @Test(groups="Top")
  public void Images() {
	  driver.findElement(By.xpath("//*[@id='gbw']/div/div/div[1]/div[2]/a")).click();
  }
  @BeforeMethod(alwaysRun=true)
  public void beforeMethod(){
	  System.out.println("Title: "+driver.getTitle());
  }
  @AfterMethod(alwaysRun=true)
  public void afterMethod(){
	  System.out.println("Title: "+driver.getTitle());
	  driver.navigate().back();
  }
  @BeforeTest(alwaysRun=true)
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("http://www.google.com");
  }
  @AfterTest(alwaysRun=true)
  public void afterTest() {
	  driver.close();
  }

}

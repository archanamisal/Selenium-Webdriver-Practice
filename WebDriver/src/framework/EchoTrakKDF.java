package framework;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EchoTrakKDF {
	private WebDriver driver;
	private Properties p;
	private File file;
	private FileInputStream fis;
	private String exp="Invalid Username/Password", act;
  @Test
  public void echoTrakLogin() {
	  driver.findElement(By.id(p.getProperty("txt_un_id"))).sendKeys("seed");
	  driver.findElement(By.id(p.getProperty("txt_pwd_id"))).sendKeys("seed");
	  driver.findElement(By.id(p.getProperty("btn_login_id"))).click();
  }
  @AfterMethod
  public void afterMethod(){
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  act = driver.findElement(By.id(p.getProperty("lbl_errmsg_id"))).getText();
	  Assert.assertEquals(act, exp);
  }
  @BeforeTest
  public void beforeTest() throws IOException{
	  file = new File("D:\\Seed\\Selenium Webdrivers\\AdvancedSelenium25\\WebDriver\\EchoTrak.properties");
	  fis = new FileInputStream(file);
	  p = new Properties();
	  p.load(fis);
	  System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get(p.getProperty("url"));
  }
  @AfterTest
  public void afterTest(){
	  driver.close();
  }
}

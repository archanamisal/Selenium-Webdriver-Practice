package grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class UsingGrid {
	public WebDriver driver;
	public String URL, Node;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;
  @Test
  public void checkAlertMessage(){
	  	 String exp="Please enter a valid user name";
	  	 Alert a=null;
	  	 try{
	  		 driver.findElement(By.name("proceed")).click();
	  		 a = driver.switchTo().alert();
	  		 String msg = a.getText();
	  		 Assert.assertTrue(exp.equalsIgnoreCase(msg));
	  	 }catch(Exception e){
	  		 System.out.println("Message is wrong.");
	  		 e.printStackTrace();
	  	 }
	  	 finally{
	  		 a.accept();
	  		 driver.switchTo().defaultContent();
	  	 }
  }
  @Parameters("browser")
  @BeforeTest
  public void launchApp(String browser) throws MalformedURLException {
	  String URL = "https://mail.rediff.com/cgi-bin/login.cgi";
	  if(browser.equalsIgnoreCase("firefox")){
		  System.out.println("Executing on Firefox");
		  Node = "http://192.168.1.50:5555/wd/hub";
		  DesiredCapabilities cap = DesiredCapabilities.firefox();
		  cap.setBrowserName("firefox");
		  driver = new RemoteWebDriver(new URL(Node),cap);
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.navigate().to(URL);
		  driver.manage().window().maximize();
	  }
	  else if(browser.equalsIgnoreCase("chrome")){
		  System.out.println("Executiing on Chrome");
		  new DesiredCapabilities();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		  cap.setBrowserName("chrome");
		   Node = "http://192.168.1.50:5557/wd/hub";
		  driver = new RemoteWebDriver(new URL(Node), cap);
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.navigate().to(URL);
		  driver.manage().window().maximize();
	  }
	  else if(browser.endsWith("ie")){
		  System.out.println("Executiing on Internet Explorer");
		  new DesiredCapabilities();
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		  //cap.setBrowserName("ie");
		   Node = "http://192.168.1.50:5558/wd/hub";
		  driver = new RemoteWebDriver(new URL(Node), cap);
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.navigate().to(URL);
		  driver.manage().window().maximize();
	  }
	  else{
		  throw new IllegalArgumentException("The Browser Type Is Undefined");
	  }
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
}
package pomPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RediffLoginPage {
	private By userName = By.id("login1");
	private By password = By.id("password");
	private By cb = By.id("remember");
	private By go = By.name("proceed");
	private By newAc =By.partialLinkText("Create a");
	private WebDriver driver;
	private Alert alt;
	String exp ="Please enter your password",act;
	
	//Constructor
	public RediffLoginPage(WebDriver driver){
		this.driver = driver;
	}
	public void setUname(String un){
		driver.findElement(userName).sendKeys(un);
	}
	public void setPassword(String pwd){
		driver.findElement(password).sendKeys(pwd);
	}
	public void clickOnGo(){
		driver.findElement(go).click();
	}
	public void validateAlert(){
		alt = driver.switchTo().alert();
		act = alt.getText();
		if(act.equals(exp)){
			System.out.println("Pass");
		}
		else{
			System.out.println("Fail");
		}
		alt.accept();
		driver.switchTo().defaultContent();
	}
	public void testMsg(String un){
		this.setUname(un);
		this.clickOnGo();
		this.validateAlert();
	}
	public void newAccount(){
		driver.findElement(newAc).click();
	}
	public void checkStatusofcb(){
		System.out.println(driver.findElement(cb).isDisplayed());
		System.out.println(driver.findElement(cb).isEnabled());
		System.out.println(driver.findElement(cb).isSelected());
	}
}

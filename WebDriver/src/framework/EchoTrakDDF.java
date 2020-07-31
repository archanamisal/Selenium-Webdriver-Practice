package framework;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class EchoTrakDDF {
	private File file;
	private FileInputStream fis;
	private FileOutputStream fos;
	private HSSFWorkbook wb;
	private HSSFSheet sh;
	private HSSFRow rw;
	private HSSFCell cl;
	private WebDriver driver;
	private String exp="Invalid Username/Password", act, shNm;
	private int rowCount, colCount, row, col, i=1, j=2;
	private HSSFFont ifPass, ifFail;
	private HSSFCellStyle style;
  @Test(dataProvider = "getData")
  public void EchoTrakLogin(String un, String pwd) throws IOException {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.id("txtCustomerID")).sendKeys(un);
	  driver.findElement(By.id("txtPassword")).sendKeys(pwd);
	  driver.findElement(By.id("Butsub")).click();
	  act = driver.findElement(By.id("lblMsg")).getText();
	  fos = new FileOutputStream(file);
	  rw = sh.getRow(i);
	  cl = rw.createCell(j);
	  
	  style = wb.createCellStyle();
	  
	  ifPass = wb.createFont();
	  ifPass.setBold(true);
	  //ifPass.setColor(HSSFColor.GREEN.index);
	  
	  ifFail = wb.createFont();
	  ifFail.setBold(true);
	  //ifFail.setColor(HSSFColor.RED.index);
	  
	  if(act.equals(exp)){
		  cl.setCellValue("Pass");
		  style.setFont(ifPass);
		  cl.setCellStyle(style);
	  }
	  else{
		  cl.setCellValue("Fail");
		  style.setFont(ifFail);
		  cl.setCellStyle(style);
	  }
	  i++;
	  wb.write(fos);
	  fos.close();
  }
  @AfterMethod
  public void afterMethod() {
	  driver.findElement(By.id("txtCustomerID")).clear();
	  driver.findElement(By.id("txtPassword")).clear();
  }
  @DataProvider
  public Object[][] getData() {
	  rowCount = sh.getPhysicalNumberOfRows();//4
	  colCount = sh.getRow(0).getPhysicalNumberOfCells();//3
	  Object [][]data = new Object[rowCount-1][colCount-1];
	  for(row=0; row<rowCount-1; row++){
		  rw = sh.getRow(row+1);//row+1 as we want data from 1st row and not from 0th row.
		  for(col=0;col<colCount-1;col++){//colcount-1 as we want data from 0th & 1st column.
			  cl = rw.getCell(col);
			  data[row][col]= cl.getStringCellValue();
		  }
	  }
	  return data;
  }
  @BeforeTest
  public void beforeTest() throws IOException {
	  file = new File("D:\\Archana Data\\Seed_VN\\Selenium Webdrivers\\Workspace\\src\\Frameworks\\Echo_Login_Data.xls");
	  fis = new FileInputStream(file);
	  wb = new HSSFWorkbook(fis);
	  shNm = wb.getSheetName(0);
	  sh = wb.getSheet(shNm);
	  System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("http://www.echotrak.com");
  }

  @AfterTest
  public void afterTest() throws IOException {
	  driver.close();
	  wb.close();
	  fis.close();
  }

}

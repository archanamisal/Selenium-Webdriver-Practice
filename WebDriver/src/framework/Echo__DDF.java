package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Echo__DDF {
	WebDriver driver;
	File file;
	FileInputStream fis;
	FileOutputStream fos;
	String fpath="D:\\Archana Data\\Seed_VN\\Selenium Webdrivers\\Workspace\\src\\Frameworks";
	String fnm="Echo_Login_Data.xls";
	String sheetnm;
	HSSFWorkbook wb;
	HSSFSheet sh;
	HSSFRow rw;
	HSSFCell cl;
	int rCount,cCount,row,col,r=1,c=2;
	HSSFCellStyle style;
	HSSFFont ifPass,ifFail;
	String exp="Invalid Username/Password",act;

	@BeforeTest
	public void beforeTest() throws IOException {
		file=new File(fpath+"\\"+fnm);
		fis=new FileInputStream(file);
		wb=new HSSFWorkbook(fis);
		sheetnm=wb.getSheetName(0);
		System.out.println("Sheet name is :"+sheetnm);
		sh=wb.getSheet(sheetnm);
		
		System.setProperty("webdriver.gecko.driver","D:\\Archana Data\\Browsers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");

	}
	@BeforeMethod
	public void beforeMethod() {
		driver.findElement(By.id("txtCustomerID")).clear();
		driver.findElement(By.id("txtPassword")).clear();
	}

	@Test(dataProvider = "dp")
	public void f(String un ,String psw) throws IOException {
		driver.findElement(By.id("txtCustomerID")).sendKeys(un);
		driver.findElement(By.id("txtPassword")).sendKeys(psw);
		driver.findElement(By.id("Butsub")).click();
		act=driver.findElement(By.id("lblMsg")).getText();
		fos=new FileOutputStream(file);
		rw=sh.getRow(r);
		cl=rw.createCell(c);
		
		style=wb.createCellStyle();
		ifPass=wb.createFont();
		ifPass.setBold(true);
		//ifPass.setColor(HSSFColor.GREEN.index);
		
		ifFail=wb.createFont();
		ifFail.setBold(true);
		ifFail.setItalic(true);
		//ifFail.setColor(HSSFColor.RED.index);
		
		
		if(act.equals(exp))
		{
			cl.setCellValue("PASS");
			style.setFont(ifPass);
			cl.setCellStyle(style);

		} 
		else
		{
			cl.setCellValue("FAIL");
			style.setFont(ifFail);
			cl.setCellStyle(style);
		}
		wb.write(fos);
		fos.close();
		r++;
	}



	@DataProvider
	public Object[][] dp() {
		rCount=sh.getPhysicalNumberOfRows(); //4
		cCount=sh.getRow(0).getPhysicalNumberOfCells(); //3
		System.out.println("Total Rows :"+rCount);
		System.out.println("Total Colums :"+cCount);
		Object[][] lData= new Object[rCount-1][cCount-1]; //3by2
		for(row=0;row<rCount-1;row++)
		{
			rw=sh.getRow(row+1); //as we want data from 1st index row
			
			for(col=0;col<cCount-1;col++)
			{
				cl=rw.getCell(col); //as we want data from 0th column & 1st index row
				lData[row][col]=cl.getStringCellValue();
			}
		}
		return lData;	

	}


	@AfterTest
	public void afterTest() throws IOException {
		wb.close();
		fis.close();
		driver.close();
		System.out.println("Done data driven framework ..!!!");
	}

}

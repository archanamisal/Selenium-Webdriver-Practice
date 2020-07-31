package excel;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ExcelDP {
	private File file;
	private String fpath="D:\\EmpDetails.xls";
	private FileOutputStream fos;
	private HSSFWorkbook wb;
	private HSSFSheet sh;
	private HSSFRow rw;
	private HSSFCell cl;
	int row=0, col;
  @Test(dataProvider = "getData")
  public void WriteToExcel(String nm, String cmp, String loc) {
	  col = 0;
	   
	  rw = sh.createRow(row);
	  
	  cl = rw.createCell(col);
	  cl.setCellValue(nm);
	  
	  cl = rw.createCell(col+1);
	  cl.setCellValue(cmp);
	  
	  cl = rw.createCell(col+2);
	  cl.setCellValue(loc);
	  
	  row++;
  }
  @DataProvider
  public Object[][] getData() {
	  Object [][] data = new Object[3][3];
	  
	  data[0][0]="NAME";
	  data[0][1]="COMPANY";
	  data[0][2]="LOCATION";
	  
	  data[1][0]="Diwakar";
	  data[1][1]="HSBC";
	  data[1][2]="Mumbai";
	  
	  data[2][0]="Pravin";
	  data[2][1]="Asus";
	  data[2][2]="Pune";
	  
	  return data;
  }
  @BeforeTest
  public void beforeTest() throws IOException {
	  file = new File(fpath);
	  fos = new FileOutputStream(file);
	  wb = new HSSFWorkbook();
	  sh = wb.createSheet("Details");
  }

  @AfterTest
  public void afterTest() throws IOException {
	  wb.write(fos);
	  wb.close();
	  fos.close();
	  System.out.println("Done!!!");
  }

}

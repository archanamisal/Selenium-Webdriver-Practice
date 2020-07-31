package excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
public class WriteToExcel {
	private String fname="MyExcel.xls";
	private String fpath="Z:\\WenDriver Related\\Adv_Selenium_Merge\\ExcelDemo";
	private File file;
	private FileOutputStream fos;
	private HSSFWorkbook wb;
	private HSSFSheet sh;
	private HSSFRow rw;
	private HSSFCell cl;
  @Test
  public void WriteToCell() {
	  sh = wb.createSheet("My Sheet");
	  rw = sh.createRow(0);
	  cl = rw.createCell(0);
	  cl.setCellValue("My Cell");
  }
  @BeforeTest
  public void beforeTest() throws FileNotFoundException {
	  file = new File(fpath+"\\"+fname);
	  fos = new FileOutputStream(file);
	  wb = new HSSFWorkbook();
  }
  @AfterTest
  public void afterTest() throws IOException {
	  wb.write(fos);
	  wb.close();
	  fos.close();
	  System.out.println("Done!!!");
  }

}

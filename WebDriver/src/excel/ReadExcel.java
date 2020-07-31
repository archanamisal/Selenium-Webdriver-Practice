package excel;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ReadExcel {
	private File file;
	private HSSFWorkbook wb;
	private HSSFSheet sh;
	private HSSFRow rw;
	private HSSFCell cl;
	private FileInputStream fis;
	private String fpath="Z:\\Expert_4\\Emp_Details.xls";
	private String shNm, data;
	private int rowCount, colCount, row, col;
  @Test
  public void ReadFromExcel() {
	  rowCount = sh.getPhysicalNumberOfRows();
	  colCount = sh.getRow(0).getPhysicalNumberOfCells();
	  System.out.println("Row Count: "+rowCount+"\tColumn Count: "+colCount);
	  for(row = 0; row < rowCount; row++){
		  rw = sh.getRow(row);
		  for(col = 0; col < colCount; col++){
			  cl = rw.getCell(col);
			  //System.out.println(cl.getStringCellValue()+"\t");
			  data = cl.getStringCellValue();
			  System.out.print(data+"\t");
		  }
		  System.out.println();
	  }
  }
  @BeforeTest
  public void beforeTest() throws IOException {
	  file = new File(fpath);
	  fis = new FileInputStream(file);
	  wb = new HSSFWorkbook(fis);
	  shNm = wb.getSheetName(0);
	  sh = wb.getSheet(shNm);
  }

  @AfterTest
  public void afterTest() throws IOException {
	  wb.close();
	  fis.close();
  }

}

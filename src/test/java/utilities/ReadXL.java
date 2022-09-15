package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXL {
	public static String readExcelSheet() throws IOException {
		File f=new File("C:\\Users\\Admin\\Downloads.xlsx");
		FileInputStream fil=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fil);
		Sheet sh=w.getSheet("sheet");
		Row r=sh.getRow(1);
		Cell c=r.getCell(0);
		String value=c.getStringCellValue();
		
		return value;
		
		
	}

}

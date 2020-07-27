package Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readingDataFromExcel {
	public static void main(String[] args) throws IOException {
		
		readFile();
	}

	public static void readFile() throws IOException, FileNotFoundException {
		String path = System.getProperty("user_dir");

		FileInputStream file = new FileInputStream("C:\\Users\\SaiMadhav\\eclipse-workspace\\Assignment1\\src\\main\\java\\resources\\testdata.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		
		for(int i=0;i<rowcount;i++) {
			XSSFRow currentrow = sheet.getRow(i);
			
			for(int j=0;j<colcount;j++) {
				String value = currentrow.getCell(j).toString();
				System.out.print(" "+value);
				
			}
			System.out.println();
		}
		
		
		workbook.close();
	}
}

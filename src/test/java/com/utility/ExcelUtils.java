package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {
	private static HSSFWorkbook ExcelWBook;
	private static HSSFSheet ExcelWSheet;
	private static HSSFCell Cell;
	private static HSSFRow Row;
	private static ExcelUtils INSTANCE;
	
	private ExcelUtils() {
		
	}
	public void setExcelFile (String FileName, String SheetName) {
		
		FileInputStream ExcelFile;
		try {
			ExcelFile = new FileInputStream(Constant.Path_TestData+FileName);
			ExcelWBook = new HSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	
	
	public String getCellData(int RowNum, int ColNum) {
		
		try {
			
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			
			return "";
		}
	}
	
	public void setCellData(String Result, int RowNum, int ColNum) throws IOException {
		
		FileOutputStream FileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData_Migration);
		ExcelWBook.write(FileOut);
		Row = ExcelWSheet.getRow(RowNum);
		Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
		
		if (Cell == null) {
			
			Cell = Row.createCell(ColNum);
			Cell.setCellValue(Result);
		} else {
			
			Cell.setCellValue(Result);
		}
		FileOut.flush();
		FileOut.close();
	}

	public static ExcelUtils getInstance() {
		
		if( INSTANCE == null) {
			
			INSTANCE = new ExcelUtils();
		}
		return INSTANCE;
	}
}
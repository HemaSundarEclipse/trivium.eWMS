package com.samplePractice;



import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.Test;

public class ExcelTest
{
	@Test
	public void test() throws BiffException, IOException
	{
		FileInputStream fs = new FileInputStream("E:\\WebKeys\\Payments.xls");
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet ws = wb.getSheet("Foreign");
		for(int r=0;r<ws.getRows();r++)
		{
			for(int c=0;c<ws.getColumns();c++)
			{
				System.out.println(ws.getCell(c, r).getContents());
			}
		}
	}
	
	
}

package com.automation.testng;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ReadingExcelData {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook=new XSSFWorkbook("src/test/resources/data/credential.xlsx");
        XSSFSheet sheet= workbook.getSheet("PositiveData");

        for (Row row:sheet)
        {
            for (Cell cell:row)
            {
                System.out.print(cell.toString()+ " ");
            }
            System.out.println();
        }

        //XSSFRow row= sheet.getRow(1);
        //XSSFCell cell= row.getCell(0);

        /*
        int rowNum= sheet.getLastRowNum();
        for (int i=1; i<=rowNum; i++)
        {
            XSSFRow row= sheet.getRow(i);
            for(int j=0; j<row.getLastCellNum();j++)
            {
                XSSFCell cell= row.getCell(j);
                System.out.println(cell.getStringCellValue()+ " ");
            }
            System.out.println();
        }

         */
    }
}

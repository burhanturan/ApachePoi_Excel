package com.apache.tests;

import com.apache.utilities.ExcelReader;
import org.junit.Test;

public class TestExcelUtil {

    @Test
    public void test() {
        ExcelReader reader = new ExcelReader("SampleData.xlsx");

        System.out.println(reader.getCellData("Employees", "FirstName", 5));

        int rowCOunt = reader.getRowCount("Employees");
        System.out.println("total rows: " + rowCOunt);

        if (!reader.isSheetExist("DenemeSheet")) {
            reader.addSheet("DenemeSheet");
        }


        reader.setCellData("Employees", "LastName", 2, "Snowwww");

        System.out.println(reader.getCellData("Employees", "LastName", 2));

        System.out.println(reader.getColumnCount("Employees"));

    }
}

package com.apache.tests;

import com.apache.utilities.ExcelReader;
import org.junit.Test;

public class TestExcelUtil {

    @Test
    public void test() {

        ExcelReader reader = new ExcelReader("C:\\Users\\Turan\\Desktop\\DDTTesting.xlsx");

        System.out.println(reader.getCellData("dataStudent", "username", 1));

        int rowCOunt = reader.getRowCount("dataStudent");
        System.out.println("total rows: " + rowCOunt);

        if (!reader.isSheetExist("DenemeSheet")) {
            reader.addSheet("DenemeSheet");
        }


        reader.setCellData("dataStudent", "password", 2, "Snowwww");

        System.out.println(reader.getCellData("dataStudent", "result", 2));

        System.out.println(reader.getColumnCount("dataStudent"));

        reader.removeSheet("DenemeSheet");

        for (int i = 2; i <= reader.getRowCount("dataStudent"); i++) {

            reader.setCellData("dataStudent", "Result", i, "Snowwww");

        }

    }
}

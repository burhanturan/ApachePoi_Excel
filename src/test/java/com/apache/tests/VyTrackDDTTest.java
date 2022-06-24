package com.apache.tests;

import com.apache.pages.VyTrackDashboardPage;
import com.apache.pages.VyTrackLoginPage;
import com.apache.utilities.ConfigurationReader;
import com.apache.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackDDTTest {

    VyTrackLoginPage loginPage = new VyTrackLoginPage();
    VyTrackDashboardPage dashboardPage = new VyTrackDashboardPage();

    @Before
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void loginDDTTest() throws IOException {
        String filePath = "VyTrackUserQA2.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("data");

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            String username = sheet.getRow(i).getCell(0).toString();
            String password = sheet.getRow(i).getCell(1).toString();

            String firstname = sheet.getRow(i).getCell(2).toString();
            String lastname = sheet.getRow(i).getCell(3).toString();

            loginPage.login(username,password);

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);

            WebElement loaderMask =Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));

            wait.until(ExpectedConditions.invisibilityOf(loaderMask));

            String actualFullName = dashboardPage.fullName.getText();

            XSSFCell resultCell = sheet.getRow(i).getCell(4);
            if (actualFullName.contains(firstname) && actualFullName.contains(lastname)){
                System.out.println("PASS");
                resultCell.setCellValue("PASS");
            }else {
                System.out.println("FAIL");
                resultCell.setCellValue("FAIL");
            }
            dashboardPage.logout();


        }
        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);

        fileInputStream.close();
        out.close();
        workbook.close();


    }

}

package ApachePOI;

import Pages.DialogContent;
import Utilities.ExcelUtilities;
import Utilities.MyMethods2;
import Utilities.ParameterDriver;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class _03_Combined {
    DialogContent dialogContent = new DialogContent();
    String fileName = "";

    @Test
    public void loginAndNavigate() {
        try {
            ParameterDriver.getDriver().get("https://test.mersys.io/");
            dialogContent.sendKeysMethod(dialogContent.usernameInbox, "turkeyts");
            dialogContent.sendKeysMethod(dialogContent.passwordInbox, "TechnoStudy123");
            dialogContent.loginButton.click();
            MyMethods2.myWait(3);
            ParameterDriver.getDriver().navigate().to("https://test.mersys.io/countries/list");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(dependsOnMethods = "loginAndNavigate")
    public void iWriteIntoExcel() {
        try {
            MyMethods2.myWait(3);
            List<WebElement> listOfNames = ParameterDriver.getDriver().findElements(By.xpath("//tbody[@role=\"rowgroup\"]//td[@class=\"mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-name mat-column-name ng-tns-c3483967859-42 ng-star-inserted\"]"));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String dateTime = dateFormat.format(new Date());
            fileName = "WriteModelNumbers" + dateTime + ".xlsx";
            String path = "C:/ProgramData/Jenkins/.jenkins/workspace/_08_/src/test/java/ApachePOI/recources/" + fileName;

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sheet1");

            int rowCount = 0;
            for (WebElement name : listOfNames) {
                Row row = sheet.createRow(rowCount++);
                Cell cell = row.createCell(0);
                cell.setCellValue(name.getText());
            }
            try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
                workbook.write(fileOutputStream);
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test(dependsOnMethods = "iWriteIntoExcel")
    public void iReadFromExcelAndDeleteModelNumbers() {

        try {
            MyMethods2.myWait(3);
            List<List<String>> countries = ExcelUtilities.getDataFromExcel("C:/ProgramData/Jenkins/.jenkins/workspace/_08_/src/test/java/ApachePOI/recources/" + fileName, "Sheet1");

            System.out.println("C:/ProgramData/Jenkins/.jenkins/workspace/_08_/src/test/java/ApachePOI/recources/" + fileName);

            for (List<String> data : countries) {
                dialogContent.sendKeysMethod(dialogContent.nameInboxSearchInboxSearch1, data.get(0));
                dialogContent.clickMethod(dialogContent.searchButton);
                MyMethods2.myWait(1);
                dialogContent.clickMethod(dialogContent.deleteButton);
                dialogContent.clickMethod(dialogContent.deleteConfirmButton);
                MyMethods2.myWait(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

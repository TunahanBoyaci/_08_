package StepDefinitions;

import Utilities.MyMethods2;
import Utilities.ParameterDriver;
import io.cucumber.java.en.And;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class _07_ {


    @And("I write into excel")
    public void iWriteIntoExcel() throws IOException {

        MyMethods2.myWait(3);

        List<WebElement> listOfNames = ParameterDriver.getDriver().findElements(By.xpath("//tbody[@role=\"rowgroup\"]//td[@class=\"mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-name mat-column-name ng-tns-c3483967859-42 ng-star-inserted\"]"));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String dateTime = dateFormat.format(new Date());
        String path = "src/test/java/ApachePOI/recources/WriteModeNumbers" + dateTime + ".xlsx";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        int rowCount = 0;
        for (int i = 0; i < listOfNames.size(); i++) {
            Row row = sheet.createRow(rowCount++);
            Cell cell = row.createCell(0);
            cell.setCellValue(listOfNames.get(i).getText());
        }

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
    }
}


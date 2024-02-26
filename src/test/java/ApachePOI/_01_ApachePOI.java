package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class _01_ApachePOI {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/recources/ApacheExcel2.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet1");

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                System.out.print(sheet.getRow(i).getCell(j) + " ");
            }
            System.out.println();
            System.out.println("-----------------------");
        }
    }
}
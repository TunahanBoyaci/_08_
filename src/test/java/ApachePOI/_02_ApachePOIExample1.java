package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _02_ApachePOIExample1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What would you like to get?");
            System.out.println("Username\n" +
                    "Password\n" +
                    "Address\n" +
                    "Zipcode\n" +
                    "City\n" +
                    "State\n" +
                    "Type 'quit' to exit.");
            String userResponse = scanner.nextLine();

            if (userResponse.equalsIgnoreCase("quit")) {
                System.out.println("Exiting the program.");
                break;
            }

            System.out.println(getResult(userResponse));
        }
    }

    public static String getResult(String userResponse) throws IOException {
        String path = "src/test/java/ApachePOI/recources/LoginData.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Login");

        String returnString = "";
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            if (sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(userResponse)) {
                for (int j = 1; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                    returnString += sheet.getRow(i).getCell(j);
                }
            }
        }

        return returnString;
    }
}


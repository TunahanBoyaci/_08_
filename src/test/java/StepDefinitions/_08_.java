package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtilities;
import Utilities.MyMethods2;
import Utilities.ParameterDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class _08_ {
    DialogContent dialogContent = new DialogContent();


    @Given("Navigate to Campus")
    public void navigateToCampus() {
        ParameterDriver.getDriver().get("https://test.mersys.io/");
    }

    @And("Enter username and password")
    public void enterUsernameAndPassword() {
        dialogContent.sendKeysMethod(dialogContent.usernameInbox,"turkeyts");
        dialogContent.sendKeysMethod(dialogContent.passwordInbox,"TechnoStudy123");
    }

    @And("Click on login Button")
    public void clickOnLoginButton() {
        dialogContent.loginButton.click();

    }

    @And("Navigate to Citizenship page")
    public void navigateToCitizenshipPage() {
        MyMethods2.myWait(3);
        ParameterDriver.getDriver().navigate().to("https://test.mersys.io/citizenships/list");
    }


    List<List<String>> citizenshipData = ExcelUtilities.getDataFromExcel("src/test/java/ApachePOI/recources/ApacheExcel3.xlsx","testCitizen",2);

    @And("Create a citizenship with Apache POI")
    public void createACitizenshipWithApachePOI() {
        for (int i = 0; i < citizenshipData.size(); i++) {
            dialogContent.clickMethod(dialogContent.addButton);
            dialogContent.sendKeysMethod(dialogContent.nameInboxSearchInboxAdd2, citizenshipData.get(i).get(0));
            dialogContent.sendKeysMethod(dialogContent.shortNameAdd2, citizenshipData.get(i).get(1));
            dialogContent.clickMethod(dialogContent.saveButton);
            dialogContent.assertText(dialogContent.successMessage,"successfully");
            dialogContent.wait.until(ExpectedConditions.invisibilityOf(dialogContent.successMessage));
        }
    }

    @And("Delete a citizenship with Apache POI")
    public void deleteACitizenshipWithApachePOI() {
        for (int i = 0; i < citizenshipData.size(); i++){
            dialogContent.sendKeysMethod(dialogContent.shortNameSearchInboxSearch1,citizenshipData.get(i).get(1));
            dialogContent.clickMethod(dialogContent.searchButton);
            MyMethods2.myWait(1);
            dialogContent.clickMethod(dialogContent.deleteButton);
            dialogContent.clickMethod(dialogContent.deleteConfirmButton);
            dialogContent.assertText(dialogContent.successMessage,"successfully");
            dialogContent.wait.until(ExpectedConditions.invisibilityOf(dialogContent.successMessage));
        }
    }
}

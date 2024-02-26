package Pages;

import Utilities.MyMethods;
import Utilities.ParameterDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class DialogContent extends MyMethods {

    public DialogContent() {
        PageFactory.initElements(ParameterDriver.getDriver(), this);
    }


    @FindBy(xpath = "//ms-add-button[@tooltip=\"CITIZENSHIP.TITLE.ADD\"]")
    public WebElement addButton;

    @FindBy(xpath = "//input[@placeholder=\"Username\"]")
    public WebElement usernameInbox;

    @FindBy(xpath = "//input[@placeholder=\"Password\"]")
    public WebElement passwordInbox;

    @FindBy(xpath = "//button[@aria-label=\"LOGIN\"]")
    public WebElement loginButton;

    @FindBy(xpath = "(//input[@data-placeholder='Name'])[2]")
    public WebElement nameInbox;

    @FindBy(xpath = "(//input[@data-placeholder='Code'])[2]")
    public WebElement codeInbox;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[text()='Save & New']")
    public WebElement saveAndNewButton;

    @FindBy(xpath = "//span[text()='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;

    @FindBy(xpath = "(//button[@color='warn'])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//span[normalize-space()='Delete']")
    public WebElement deleteConfirmButton;

    @FindBy(xpath = "(//input[@data-placeholder='Short Name'])[2]")
    public WebElement shortNameAdd2;

    @FindBy(xpath = "(//input[@data-placeholder='Name'])[1]")
    public WebElement nameInboxSearchInboxSearch1;

    @FindBy(xpath = "(//input[@data-placeholder='Name'])[2]")
    public WebElement nameInboxSearchInboxAdd2;

    @FindBy(xpath = "(//input[@data-placeholder='Short Name'])[1]")
    public WebElement shortNameSearchInboxSearch1;

    @FindBy(xpath = "(//input[@data-placeholder=\"Name\"])[2]")
    public WebElement nameFeeType;

    @FindBy(xpath = "(//input[@data-placeholder=\"Code\"])[2]")
    public WebElement codeFeeType;

    @FindBy(xpath = "(//input[@data-placeholder=\"Code\"])[1]")
    public WebElement codeInboxSearchInboxSearch;

    @FindBy(xpath = "(//input[@data-placeholder=\"Integration Code\"])[1]")
    public WebElement IntegrationFeeType;

    @FindBy(xpath = "(//input[@data-placeholder=\"Priority\"])[2]")
    public WebElement prioirityFeeType;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement createExamName;

    @FindBy(xpath = "(//span[.='Academic Period'])[1]")
    public WebElement academicPeriod;

    @FindBy(xpath = "//span[normalize-space()='Test 2024']")
    public WebElement academicPeriodOption;

    @FindBy(xpath = "(//span[.='Grade Level'])[1]")
    public WebElement gradeLevel;

    @FindBy(xpath = "//span[text()=' 9 ']")
    public WebElement gradeLevelOption;

    @FindBy(xpath = "//span[text()='Description']")
    public WebElement examDescription;

    @FindBy(xpath = "//span[text()='Notes']")
    public WebElement examNotes;

    @FindBy(css = "body[id='tinymce']>p")
    public WebElement descriptionAndNotesText;

    @FindBy(css = "iframe[class=\"tox-edit-area__iframe\"]")
    public WebElement iFrame;

    @FindBy(xpath = "//tbody[@role='rowgroup']//td[2]")
    public List<WebElement> statesList;

}

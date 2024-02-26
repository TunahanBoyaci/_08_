package Pages;

import Utilities.MyMethods;
import Utilities.ParameterDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNavBar extends MyMethods {
    public LeftNavBar(){
        PageFactory.initElements(ParameterDriver.getDriver(),this);
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    public WebElement setupButton;

    @FindBy(xpath = "(//span[text()='Parameters'])[1]")
    public WebElement parametersButton;

    @FindBy(xpath = "(//span[text()='Countries'])[1]")
    public WebElement countriesButton;

    @FindBy(xpath = "(//span[text()='Citizenships'])[1]")
    public WebElement citizenshipButton;

    @FindBy(xpath = "(//span[text()='Fees'])[1]")
    public WebElement feesButton;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[1]")
    public WebElement entranceExamsButton;

    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    public WebElement entranceExamsSetupButton;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    public WebElement entranceExams2Button;

    @FindBy(xpath = "(//span[text()='States'])[1]")
    public WebElement statesButton;


}

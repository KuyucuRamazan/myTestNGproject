package techproed.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;
public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText = "Login")
    public WebElement homeLoginButton;
    @FindBy(id = "dropdown-basic-button")
    public WebElement userID;
    @FindBy(linkText = "Logout")
    public WebElement logoutLink;
    @FindBy(xpath = "//button[text()='OK']")
    public WebElement OK;
    @FindBy(xpath = "//*[@name='car']")
    public WebElement selectACar;


    @FindBy(xpath = "//select")
    public WebElement SelectButton;

    @FindBy(name = "pickUpLocation")
    public WebElement picUpLocationBox;


    @FindBy(name = "dropOfLocation")
    public WebElement dropOfLocationBox;

    @FindBy(name = "pickUpDate")
    public WebElement pickUpDateBox;

    @FindBy(name = "pickUpTime")
    public WebElement pickUpTimeBox;

    @FindBy(name = "dropOffDate")
    public WebElement dropOffDateBox;

    @FindBy(name = "dropOffTime")
    public WebElement dropOffTimeBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueReservationBotton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement firstSignInAlert;


    @FindBy(xpath = "//div[@class='Toastify']")
    public WebElement toastifyAlert;
}
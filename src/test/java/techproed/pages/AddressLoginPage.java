package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class AddressLoginPage {
    public AddressLoginPage(){
 //     PageFactory is used to initialize the page objects
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "session_email")
    public WebElement username;
    //session_password
    @FindBy(id="session_password")
    public WebElement password;
    //commit
    @FindBy(name="commit")
    public WebElement logInButton;
}

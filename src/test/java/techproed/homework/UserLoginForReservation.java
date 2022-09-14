package techproed.homework;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserLoginForReservation {
    /*
    Name:
Require user to login for reservation
Description:
User should see a message when user tries to book a car while not logged in
Acceptance Criteria:
As customer, I should be able to see error message, when I try to book a car while not logged in
Message: Please first login
Given user is on the login page
And tries to book a car
And click continue reservation
Then user see the warning message: Please first login
     */

    HomePage homePage;
    Faker faker = new Faker();

    @Test
    public void userLoginForReservation() throws InterruptedException, IOException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage = new HomePage();

        // Fill the fields and try to book a car
        Select select = new Select(homePage.SelectButton);
        select.selectByIndex(2);  // Select a car

        homePage.picUpLocationBox.sendKeys(faker.address().state());
        //Driver.getDriver().findElement(By.xpath("(//ul)[2]//li")).click(); // Select Pick up location

        homePage.dropOfLocationBox.sendKeys(faker.address().state());
        //Driver.getDriver().findElement(By.xpath("(//ul)[3]//li")).click(); // Select Drop up location

        String currentDate = new SimpleDateFormat("ddMMYYYY").format(new Date());
        String currentTime = new SimpleDateFormat("hhmm").format(new Date());
        homePage.pickUpDateBox.sendKeys(currentDate);
        homePage.pickUpTimeBox.sendKeys(currentTime);

        homePage.dropOffDateBox.sendKeys(ConfigReader.getProperty("app_drop_date"));
        homePage.dropOffTimeBox.sendKeys(ConfigReader.getProperty("aap_drop_time"));

        Thread.sleep(1000);
        homePage.continueReservationBotton.click();
        String signInAlert ="";
        ReusableMethods.waitForVisibility(homePage.firstSignInAlert, 5);
        ReusableMethods.verifyElementDisplayed(homePage.firstSignInAlert);
        ReusableMethods.getScreenshot(signInAlert);
        Assert.assertEquals("Please first login", homePage.firstSignInAlert.getText());


    }
}
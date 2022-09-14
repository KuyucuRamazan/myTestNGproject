package techproed.homework;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
//import techproed.pages.ReservationPage;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReserveCarAsCustomerServiceProfile {

    /*
    Name:
User should be able to reserve a car
Description:
User should be able to reserve a car as customer service profile
Acceptance Criteria:
Given user is on the home page
And select a car
And enter pick up field
And enter drop off field
And click continue reservation
And verify complete reservation screen pops up
And enter card number
And enter name on the card
And enter expire date and CVC
And checks the agreement
And click complete reservation
Then verify ‘Reservation created successfully’ pop up
And naviaged to Reservations screen
And verify the last reservation is created
When you click on the last reservation
Then verify reservation detail page is displayed
And verify the table has the following fields: Model, Doors, Seats, Luggage, Transmission, Air Conditioning, Fuel Type, Age
And click on bath to reservations
And verify Reservations page is displayed
And click on Home link
Then verify the home page is displayed
     */
    private HomePage homePage;
    private Faker faker;
    private LoginPage loginPage;
    //private ReservationPage reservationPage;

    @Test
    public void reserveACarTest() throws InterruptedException {
        loginPage = new LoginPage();
        homePage = new HomePage();

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        homePage.homeLoginButton.click();

        loginPage.username.sendKeys(ConfigReader.getProperty("app_customer_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("app_customer_password"));
        loginPage.loginButton.click();

        // User is logged In the homepage

        // AND select a
        Select select = new Select(homePage.SelectButton);
        select.selectByIndex(9);


        String currentDate = new SimpleDateFormat("ddMMYYYY").format(new Date());
        String currentTime = new SimpleDateFormat("hhmm").format(new Date());


        faker = new Faker();
        //And enter pick up field
        homePage.picUpLocationBox.sendKeys(faker.address().state());
        //      Driver.getDriver().findElement(By.xpath("(//ul)[2]//li")).click();
        homePage.pickUpDateBox.sendKeys(currentDate);
        homePage.pickUpTimeBox.sendKeys(currentTime);


        //And enter drop off field
        homePage.dropOfLocationBox.sendKeys(faker.address().state());
        //     Driver.getDriver().findElement(By.xpath("(//ul)[3]//li")).click();
        homePage.dropOffDateBox.sendKeys(ConfigReader.getProperty("app_drop_date"));
        homePage.dropOffTimeBox.sendKeys(ConfigReader.getProperty("aap_drop_time"));

        //And click continue reservation
        Thread.sleep(1000);
        homePage.continueReservationBotton.click();

        //And verify complete reservation screen pops up
        Thread.sleep(2000);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("app_creditcard_no")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("app_customer_name")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("app_creditcard_expiry")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("app_creditcard_cvc")).
                sendKeys(Keys.TAB).
                sendKeys(Keys.SPACE).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                build().perform();

        ReusableMethods.waitForVisibility(homePage.toastifyAlert, 2);
        ReusableMethods.verifyElementDisplayed(homePage.toastifyAlert);


    }
}
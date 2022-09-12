package techproed.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day14_TechproedTitle {

    @Test
    public void titleTest(){

        //  WebDriver driver = Driver.getDriver();

        Driver.getDriver().get(ConfigReader.getProperty("url_techproed"));
        String actualTitle = Driver.getDriver().getTitle();
        boolean isTrue =actualTitle.contains(ConfigReader.getProperty("page_title"));
        Assert.assertTrue(isTrue);
        Driver.closeDriver();

    }


}
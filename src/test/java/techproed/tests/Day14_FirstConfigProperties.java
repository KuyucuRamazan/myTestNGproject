package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import techproed.utilities.Driver;
import techproed.utilities.ConfigReader;

public class Day14_FirstConfigProperties {

    @Test
    public void firstConfigTest(){

        //Driver.getDriver().get("https://www.techproeducation.com");

        Driver.getDriver().get(ConfigReader.getProperty("url_techproed"));
        Assert.assertTrue(false);
        Driver.closeDriver();

    }


}








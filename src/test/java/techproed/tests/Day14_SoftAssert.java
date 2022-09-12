package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day14_SoftAssert {
    @Test
            public void softAssertTest(){
        //Soft Assert is used to do multiple assertion in the same class

        //Hard Assertion is more common
        //When do you use soft assert: when you are testing the first time. when I do stratch test case
        //To see all of the steps on my test cases
        SoftAssert sa = new SoftAssert();
        System.out.println("Line A");
        sa.assertEquals("Hello", "HelloX");
        System.out.println("Line B");
        sa.assertTrue(false);
        System.out.println("Line C");
        Assert.assertEquals(1, 1);

        sa.assertAll();
    }

}

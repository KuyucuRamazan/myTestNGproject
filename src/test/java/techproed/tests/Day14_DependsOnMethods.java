package techproed.tests;

import org.testng.annotations.Test;

public class Day14_DependsOnMethods {
    @Test
    public void homePage(){
        System.out.println("Home Page");
    }
    @Test
    public void loginPage(){
        System.out.println("Login Page");
        /*
        dependsOnMethods connects checkOutPage to loginPage
        if checkOutPage method executes, then loginPage runs first
        if the  loginPage passes then checkOutPage will execute.
        if the  loginPage fails then checkOutPage will not execute.
        */
    }
    @Test(dependsOnMethods = "loginPage")
    public void checkOutPage(){
        System.out.println("Check Out Page");
    }
}

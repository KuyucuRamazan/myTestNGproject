package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day17_DataProvider1 {
    /*
    what is data provider?
    -Data provider is a testNG annotation
    -It is used to get list of test data
    -With data provider, we can get data from excel or json
    -In my project, I used data provider to get data from excel sheet.

   -----------
   How do you pass a data from a method to a Test Method
    -In the data provider method, I use @DataProvider annotation
    -In the test method, I use dataProvider parameter and pass the method name
   -----------
   Use "name" parameter to give custom name
   Use "parallel" parameter to do parallel testing

     */

    // DATA PROVIDER METHOD
    @DataProvider
    public Object[][] customerData(){

        Object [][] customerCredentials = {
                {"customer@bluerentalcars.com","12345"},
                {"customer1@bluerentalcars.com","12346"},
                {"customer2@bluerentalcars.com","12347"},
                {"customer3@bluerentalcars.com","12348"}
        };


        return customerCredentials;
    }


    // DATA PROVIDER METHOD
    @DataProvider(name = "adminLoginCredentials", parallel = false)
    public Object[][] adminData(){

        Object [][] customerCredentials = {
                {"admin@bluerentalcars.com","12345"},
                {"admin1@bluerentalcars.com","12346"},
                {"admin2@bluerentalcars.com","12347"},
                {"admin3@bluerentalcars.com","12348"}
        };


        return customerCredentials;
    }



    //TEST METHOD
    @Test(dataProvider = "customerData")
    public void dataProviderTest(String userName, String passWord){

        System.out.println("Username: "+userName+" Password: "+passWord);

    }

    //TEST METHOD
    @Test(dataProvider = "adminLoginCredentials")
    public void adminLoginTest(String userName, String passWord){

        System.out.println("Username: "+userName+" Password: "+passWord);

    }

}

























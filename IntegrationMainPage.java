package test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.APIClient;
import test.APIException;
public class testgoogle {
/*
    public static String TEST_RUN_ID                   = R1;
    public static String TESTRAIL_USERNAME          = "Your userID";
    public static String TESTRAIL_PASSWORD          = "Your APIKey";
    public static String RAILS_ENGINE_URL           = <Test Rail URL>;*/
    public static final int TEST_CASE_PASSED_STATUS = 1;
    public static final int TEST_CASE_FAILED_STATUS = 5;
    WebDriver driver;
    
    @Test(description = "Verify that Title appearing on the webpage is as expected. TC_ID=C2")
    public void verifyTitle() throws Exception, APIException {
        /*driver= new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
        driver.get("https://www.google.co.in");*/
        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
  	  driver = new ChromeDriver();
  	//driver.get("https://www.google.co.in");
  	  driver.get("Link that you want to test for");
  	  driver.manage().window().maximize();
  	  Thread.sleep(1000);
        String actualTilte = driver.getTitle();
        if (actualTilte.contains("Google")) {
            Assert.assertTrue(actualTilte.contains("Google"));
            testgoogle.addResultForTestCase("3", TEST_CASE_PASSED_STATUS, "");
            //testgoogle.addResultForTestCase("1", TEST_CASE_PASSED_STATUS, "");
        }
else{
		testgoogle.addResultForTestCase("3", TEST_CASE_FAILED_STATUS, "");
	}

        driver.quit();
    }

    public static void addResultForTestCase(String string, int status, String error) throws IOException, Exception, APIException {
    //public static void addResultForTestCase(String string, int status,
//            String error) throws IOException, APIException {

        int testRunId = 1;

        APIClient client = new APIClient("Your Test Rail Link");
        client.setUser("your userID");
        client.setPassword("Your API Key/Password");
        JSONObject c = (JSONObject) client.sendGet("get_case/1");
       // Map data = new HashMap();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("status_id", status);
        data.put("comment", "Test Executed - Page open Successfully");
        client.sendPost("add_result_for_case/"+testRunId+"/"+string+"",data );
        

    }

}

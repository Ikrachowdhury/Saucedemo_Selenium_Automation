package Util;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class SetUp {
    public WebDriver driver;
    @BeforeTest
    public void setup (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @AfterTest
    public void closeDriver() {
        driver.close();
    }

    @AfterMethod
    public void RecordFailure(ITestResult result){
        if(ITestResult.FAILURE==result.getStatus()){
            var camera =(TakesScreenshot)driver;
            File screenshot=camera.getScreenshotAs(OutputType.FILE);
            File destination = new File("D:\\SeleniumBasic\\src\\test\\screenshot\\"+result.getName()+".png");
            try{
                Files.move(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        // System.out.println("Screenshot taken: "+screenshot.getAbsolutePath();
    }
}

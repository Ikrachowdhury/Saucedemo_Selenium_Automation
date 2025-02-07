package Util;

import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class TestAction {
    public  void CheckResultString(String ActualResult,String Expected){
        try{
            Assert.assertEquals(ActualResult,Expected);
            Thread.sleep(1000);
        }catch(Exception ex){
            System.out.println(ex);

        }
    }
    public  void CheckResultInt(int ActualResult,int Expected) {
        try {
            Assert.assertEquals(ActualResult, Expected);
            Thread.sleep(1000);
        } catch (Exception ex) {
            System.out.println(ex);

        }
    }

    public void CheckResultList(List<String> actualResult, List<String> expected) {
        try {
            // Compare lists using assertEquals
            Assert.assertEquals(actualResult, expected);
            Thread.sleep(1000);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}

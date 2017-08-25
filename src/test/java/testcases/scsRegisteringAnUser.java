package testcases;

import PageObjects.General;
import org.testng.annotations.Test;

public class scsRegisteringAnUser extends General {

    @Test

    public void testScSRegisteringAnUser(){

        driver.get(General.URL);
        driver.manage().window().maximize();


    }
}

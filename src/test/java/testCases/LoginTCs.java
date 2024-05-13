package testCases;

import base.Setup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFunctions.LoginFunctions;
import pageFunctions.NonBLECommonFunctions;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LoginTCs extends Setup {

    private LoginFunctions func;
    private NonBLECommonFunctions nonBLEfunctions;

    @BeforeClass
    public void init(){
        func = new LoginFunctions();
        nonBLEfunctions = new NonBLECommonFunctions();
    }

    /*@Test(priority = 1)
    public void testIntroScreen() throws InterruptedException {
        func.skipIntro();
    }*/

    @Test(priority = 2)
    public void testLogin() throws InterruptedException {
            func.loginFlow();
    }

   @Test(priority = 3)
    public void testSkipOnboarding()  {
       // testCaseID = "29754";
        nonBLEfunctions.skipOnboarding();
    }
   /* @Test(priority = 3)
    public void testLogout(){
        func.logout();
    }*/
}

package pageFunctions;

import base.Setup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import pageObjects.AddDeviceObjects;
import pageObjects.LoginObjects;

import java.time.Duration;


public class LoginFunctions extends Setup {

    private LoginObjects obj;
    private AddDeviceObjects deviceObj;
   // private static final Object lock = new Object();

    public static Logger log = LogManager.getLogger(LoginFunctions.class);

    public LoginFunctions() {
        obj = new LoginObjects();
        deviceObj = new AddDeviceObjects();
    }


    // Skip intro screens and navigate to Login screen
    public void skipIntro() throws InterruptedException {
        waitForElementClickAbility(obj.introSkip1);
    }


    //Perform Login
    public void loginFlow() throws InterruptedException {
        clickLoginLink();
        try {
            obj.login_email.sendKeys(email_param);
            obj.login_password.sendKeys("Test@123");
            obj.login_continue.click();
            Thread.sleep(17000);

           /* if(email_param.equalsIgnoreCase("karishma.barot+paired@techholding.co")) {
                if (platform_param.equalsIgnoreCase("Android")) {
                    Assert.assertTrue(deviceObj.deviceDropDown.isEnabled());
                    System.out.println("Login success!");
                    log.info("Login success!");
                } else {
                    Assert.assertTrue(deviceObj.enableNotification.isEnabled());
                    System.out.println("Login success!");
                    log.info("Login success!");
                }
            }else {*/
                Assert.assertTrue(deviceObj.theragun.isDisplayed());
                System.out.println("Login success!");
                log.info("Login success!");
          /*  }*/


        } catch (NoSuchElementException e) {
            e.printStackTrace();

            System.out.println("Re-trying Login!");
            log.info("Re-trying Login!");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(obj.login_continue));
            obj.login_continue.click();
            ExpectedCondition<Boolean> anyElementClickable = ExpectedConditions.or(
                    ExpectedConditions.elementToBeClickable(deviceObj.deviceDropDown),
                    ExpectedConditions.elementToBeClickable(deviceObj.enableNotification),
                    ExpectedConditions.elementToBeClickable(deviceObj.theragun)
            );

            wait.until(anyElementClickable);
            System.out.println("Login success on Retry!");
            log.info("Login success on Retry!");
        }


    }


    public void clickLoginLink() throws InterruptedException {
        //synchronized (lock){
        //co-ordinates for Android
        int x_android = 798;
        int y_android = 2234;

        //co-ordinates for iOS
        int x_ios = 285;
        int y_ios = 636;


            if (platform_param.equalsIgnoreCase("iOS")) {
                action_clickOnPosition(x_ios, y_ios);
            } else if (platform_param.equalsIgnoreCase("Android")) {
                Thread.sleep(2000);
                action_clickOnPosition(x_android, y_android);
            }

    }
   // }

    public void logout(){
        waitForElementClickAbility(obj.profileTab);
        utilityMethods.scroll(obj.logout, "Log out");
        waitForElementClickAbility(obj.logout);
        waitForElementClickAbility(obj.logoutConfirm);
    }
}

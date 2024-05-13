package utilities;

import base.Setup;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import pageObjects.WaveSeriesSoloObjects;

import java.util.HashMap;

public class UtilityMethods extends Setup {


    public UtilityMethods(){

    }
    // Method to get the toggle switch status (ON/OFF)
    public String getToggleSwitchStatus(WebElement element) {
        if(platform_param.equalsIgnoreCase("iOS")) {
            String switchStatus = element.getAttribute("value");
            if (switchStatus != null && switchStatus.equals("1")) {
                return "ON";
            } else {
                return "OFF";
            }
        }
        else{
            String switchStatus = element.getAttribute("checked");
            if (switchStatus != null && switchStatus.equals("true")) {
                return "ON";
            } else {
                return "OFF";
            }
        }
    }

    //Method to toggle switch OFF
    public void toggleSwitchIfOff(WebElement element) {
        String currentStatus = getToggleSwitchStatus(element);

        if (currentStatus.equals("ON")) {
            clickElementWithRetry(element);
            System.out.println("Toggled the switch to OFF");
        } else {
            System.out.println("Switch is already OFF. No action needed.");
        }
    }

    //Method to toggle switch ON
    public void toggleSwitchIfOn(WebElement element) {
        String currentStatus = getToggleSwitchStatus(element);

        if (!(currentStatus.equals("ON"))) {
            clickElementWithRetry(element);
            System.out.println("Toggled the switch to ON");
        } else {
            System.out.println("Switch is already ON. No action needed.");
        }
    }

   public void scroll(WebElement refEle, String element){
        if(platform_param.equalsIgnoreCase("Android")){
            driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + element + "\").instance(0))"));
        }else{
            while (!refEle.isDisplayed()) {
                Dimension size = driver.manage().window().getSize();
                int startX = size.width / 2;
                int startY = (int) (size.height * 0.8);
                int endY = (int) (size.height * 0.2);
                new TouchAction((PerformsTouchActions) driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();
            }
        }
   }


}

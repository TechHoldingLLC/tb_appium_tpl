package pageFunctions;

import base.Setup;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.testng.Assert;
import pageObjects.*;

import java.time.Duration;

public class WaveSeriesOtherRollerFunctions extends Setup {

    public WaveSeriesOtherRollerObjects waveRollerObjects;
    public AddDeviceObjects addDeviceObjects;
    public WaveSeriesSoloObjects waveSoloObjects;
    public WaveSeriesSoloFunctions waveSoloFunctions;
    public PrimeDeviceObjects primeObj;
    public NonBLECommonObjects nonBLECommonObjects;
    public String routineName = "Bedtime Ritual - FOR QA ONLY";

    public WaveSeriesOtherRollerFunctions(){
        waveRollerObjects = new WaveSeriesOtherRollerObjects();
       addDeviceObjects = new AddDeviceObjects();
       waveSoloObjects = new WaveSeriesSoloObjects();
       waveSoloFunctions = new WaveSeriesSoloFunctions();
        primeObj = new PrimeDeviceObjects();
        nonBLECommonObjects = new NonBLECommonObjects();
    }

   /* public void pairOtherRoller(){
        waitForElementClickAbility(addDeviceObjects.deviceDropDown);
        waitForElementClickAbility(waveRollerObjects.waveSeriesCategory);
        waitForElementClickAbility(waveRollerObjects.otherRoller);
        waitForElementVisibility(waveRollerObjects.pairedOtherRoller);
        Assert.assertTrue(waveRollerObjects.pairedOtherRoller.isDisplayed());
        waitForElementClickAbility(waveSoloObjects.closeDeviceManager);
    }*/

    public void selectRoutine() throws InterruptedException {
        /*if(device_param.equalsIgnoreCase("Roller")){
            routineName = "Run Recovery";
        } else if (device_param.equalsIgnoreCase("Theragun Mini")) {
            routineName = "Bedtime Ritual";
        }*/
        /*try{
            waitForElementClickAbility(waveRollerObjects.getRoutineName(routineName));
        }catch (NoSuchElementException e){
            System.out.println("Trying by index...");
            waitForElementClickAbility(waveRollerObjects.alternateRoutine);
        }*/
        try {
            waitForElementClickAbility(waveRollerObjects.getRoutineName(routineName));
        }catch (NoSuchElementException e){
            System.out.println("Loader took longer. Retrying...");
            waitForElementVisibility(addDeviceObjects.deviceDropDown);
            waitForElementClickAbility(waveRollerObjects.getRoutineName(routineName));
        }catch (TimeoutException e){
            e.printStackTrace();
            if(nonBLECommonObjects.retryBTN.isDisplayed()){
                System.out.println("Error loading content - page appeared, retrying...");
                log.info("Error loading content - page appeared, retrying...");
                waitForElementClickAbility(nonBLECommonObjects.retryBTN);
                Thread.sleep(3000);
                waitForElementClickAbility(waveRollerObjects.getRoutineName(routineName));
            }
        }
    }

    public void notConnectedMode() throws InterruptedException {
        selectRoutine();
        Point prefBTN = getCenterCoordinates(waveSoloObjects.preferencesBTN);
        action_clickOnPosition(prefBTN.getX(), prefBTN.getY());
        /*try {*/
            waitForElementClickAbility(waveRollerObjects.bluetoothMode);
        /*}catch (TimeoutException e){
            System.out.println("Click didn't work. Trying alternative way...");
            if (platform_param.equalsIgnoreCase("iOS")) {
                if(deviceName.equalsIgnoreCase("Roller")) {
                    action_clickOnPosition(148, 513);
                }else {
                    action_clickOnPosition(156, 619);
                }
            }
        }*/

            Assert.assertTrue(waveRollerObjects.notConnectedText.isDisplayed());


        System.out.println("\"'Not Connected' state can't be changed!\"");
        log.info("\"'Not Connected' state can't be changed!\"");
        waitForElementClickAbility(waveSoloObjects.backBTN);
        waitForElementClickAbility(waveSoloObjects.backBTN);
        System.out.println("Welcome to Routine Overview Screen!");
        log.info("Welcome to Routine Overview Screen!");
        waitForElementClickAbility(waveSoloObjects.backToHomepage);
        System.out.println("Welcome back to Home Page!");
        log.info("Welcome back to Home Page!");
    }

    public void preferencesOnProfile() throws InterruptedException {
        waitForElementClickAbility(waveRollerObjects.profileTab);
        waitForElementClickAbility(waveRollerObjects.profileRoutinePreference);


            Assert.assertEquals(utilityMethods.getToggleSwitchStatus(waveSoloObjects.stretchingToggle), "ON", "Preferences for Stretching toggle doesn't match with Profile preference");

        System.out.println("Preferences for Stretching toggle is same on Profile as Routine preference setting page.");
        log.info("Preferences for Stretching toggle is same on Profile as Routine preference setting page.");


        Thread.sleep(1000);
        /*try {*/
            clickElementWithRetry(waveSoloObjects.breaks);
       /* }catch (TimeoutException e){
            System.out.println("Breaks option is not clickable. Trying alternative way...");
            log.info("Breaks option is not clickable. Trying alternative way...");
            if(platform_param.equalsIgnoreCase("iOS")) {
                if(deviceName.equalsIgnoreCase("Roller")) {
                    action_clickOnPosition(140, 182);
                }else {
                    action_clickOnPosition(153, 278);

                }
            }
        }*/
       /* try {*/
            waitForElementVisibility(waveSoloObjects.setBreakPeriodToggle);
       /* }catch (StaleElementReferenceException e){
            waitForElementClickAbility(waveSoloObjects.backBTN);
            clickElementWithRetry(waveSoloObjects.breaks);

        }catch (TimeoutException e){
            System.out.println("Break toggle value is not accessible.");
        }*/

            Assert.assertEquals(utilityMethods.getToggleSwitchStatus(waveSoloObjects.setBreakPeriodToggle), "OFF", "Preferences for Break toggle doesn't match with Profile preference");

        System.out.println("Preferences for Break toggle is same on Profile as Routine preference setting page.");
        log.info("Preferences for Break toggle is same on Profile as Routine preference setting page.");

        waitForElementClickAbility(waveSoloObjects.backBTN);
       /* try {*/
            waitForElementClickAbility(waveRollerObjects.bluetoothMode);
       /* }catch (TimeoutException e){
            System.out.println("Click didn't work. Trying alternative way...");
            if (platform_param.equalsIgnoreCase("iOS")) {
                action_clickOnPosition(148,513);
            }
        }*/

            Assert.assertTrue(waveRollerObjects.notConnectedText.isDisplayed());

        System.out.println("Preferences for Bluetooth Mode is same on Profile as Routine preference setting page.");
        log.info("Preferences for Bluetooth Mode is same on Profile as Routine preference setting page.");
        waitForElementClickAbility(waveSoloObjects.backBTN);
        waitForElementClickAbility(waveSoloObjects.backBTN);
        waitForElementClickAbility(waveSoloObjects.homeTab);
        System.out.println("Welcome back to Home Page!");
        log.info("Welcome back to Home Page!");
    }

    public void tipForNonBLE() throws InterruptedException {
        selectRoutine();
        waitForElementClickAbility(waveSoloObjects.startRoutine);
        Thread.sleep(3000);
        if(platform_param.equalsIgnoreCase("iOS")) {
            waitForElementClickAbility(waveRollerObjects.expandController);
        }
        Assert.assertTrue(waveRollerObjects.tipHeader.isDisplayed(),"Tip didn't display!");
        System.out.println("\'TIP' is displayed instead of any routine player controls when Non BLE device is connected");
        log.info("\'TIP' is displayed instead of any routine player controls when Non BLE device is connected");
        /*waitForElementClickAbility(waveSoloObjects.closeBTN);
        waitForElementClickAbility(waveSoloObjects.endRoutine);
        System.out.println("back to Routine Overview screen!");
        log.info("back to Routine Overview screen!");*/
    }
    public void routineCompletionForNonBLE() throws InterruptedException {
        Point nextBTN = getCenterCoordinates(waveSoloObjects.nextBTN);
        for(int i=0;i<14;i++){
            Thread.sleep(4000);
            action_clickOnPosition(nextBTN.getX(), nextBTN.getY());
        }
        waitForElementDisplayed(waveSoloObjects.routineCompleteDone);
        Assert.assertTrue(waveSoloObjects.routineCompleteDone.isEnabled());
        System.out.println("Routine completion screen displayed!");
        log.info("Routine completion screen displayed!");
        /*waitForElementClickAbility(waveSoloObjects.routineCompleteDone);
        System.out.println("Back to Routine Overview screen!");
        log.info("Back to Routine Overview screen!");*/
    }

    public void saveRoutineFromCompletionScreen(){
        Point saveCTA = getCenterCoordinates(waveSoloObjects.routineCompleteSave);
        action_clickOnPosition(saveCTA.getX(), saveCTA.getY());
        waitForElementDisplayed(waveSoloObjects.savedTooltip);
        Assert.assertTrue(waveSoloObjects.savedTooltip.isDisplayed());
        System.out.println("Routine saved!!");
        log.info("Routine saved!!");
        waitForElementClickAbility(waveSoloObjects.routineCompleteDone);
        waitForElementClickAbility(waveSoloObjects.backToHomepage);
        waitForElementClickAbility(waveSoloObjects.savedTab);
        Assert.assertTrue(waveRollerObjects.getRoutineName(routineName).isDisplayed());
        System.out.println(waveRollerObjects.getRoutineName(routineName).getText() +" routine is present on Saved tab");
        log.info(waveRollerObjects.getRoutineName(routineName).getText() +" routine is present on Saved tab");
    }

    public void unSaveRoutineFromRoutineCompletionScreen() throws InterruptedException {
        waitForElementClickAbility(waveSoloObjects.moreOptions);
        Point centrePoint = getCenterCoordinates(waveSoloObjects.viewRoutine);
        action_clickOnPosition(centrePoint.getX(),centrePoint.getY());

       /* try {
            WebElement buttonElement;
            if (platform_param.equalsIgnoreCase("iOS")) {
                buttonElement = new WebDriverWait(driver, Duration.ofSeconds(30))
                        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//XCUIElementTypeButton")))
                        .get(0);
            } else {
                buttonElement = new WebDriverWait(driver, Duration.ofSeconds(30))
                        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.Button")))
                        .get(2);
            }
            // Get the text of the button
            String buttonText = buttonElement.getAttribute("name");
            System.out.println("Button status: " + buttonText);

            // Check the state of the device
            if (!(buttonText.equals("START ROUTINE"))) {
                // Device is OFF
                System.out.println("Device is OFF. Please turn it ON. System will wait for 15 seconds!");
                log.info("Device is OFF. Please turn it ON. System will wait for 15 seconds!");
                Thread.sleep(15000);
            }*/
            waitForElementClickAbility(waveSoloObjects.startRoutine);
            Thread.sleep(3000);
            Point nextBTN = getCenterCoordinates(waveSoloObjects.nextBTN);
            for(int i=0;i<14;i++){
                Thread.sleep(4000);
                action_clickOnPosition(nextBTN.getX(), nextBTN.getY());
            }

        /*} catch (Exception e) {
            System.out.println("System waited for device to be turned ON, but didn't get so!");
            log.info("System waited for device to be turned ON, but didn't get so!");
        }*/
        Assert.assertTrue(waveSoloObjects.routineCompleteSaved.isEnabled());
        System.out.println("Routine is shown 'saved' on Routine Completion Screen");
        log.info("Routine is shown 'saved' on Routine Completion Screen");
        //waitForElementClickAbility(waveSeriesSoloObject.routineCompleteSave);
        Point savePoint = getCenterCoordinates(waveSoloObjects.routineCompleteSaved);
        action_clickOnPosition(savePoint.getX(), savePoint.getY());
        waitForElementClickAbility(waveSoloObjects.routineCompleteRemoveSaved);
        Thread.sleep(2000);
        try {
            //waitForElementDisplayed(waveSoloObjects.getRemovedFromSavedToast(routineName));
            Assert.assertTrue(waveSoloObjects.getRemovedFromSavedToast(routineName).isEnabled());
        }catch (NoSuchElementException e){
            System.out.println("Loader took longer. Retrying...");
            /*waitForElementVisibility(waveSoloObjects.routineCompleteDone);
            Assert.assertTrue(waveSoloObjects.getRemovedFromSavedToast(routineName).isEnabled());*/
            System.out.println("Routine unsaved.");
        }
        System.out.println("Removed saved routine from Routine Completion screen");
        log.info("Removed saved routine from Routine Completion screen");
        waitForElementClickAbility(waveSoloObjects.routineCompleteDone);
        System.out.println("Back to Routine Overview Screen");
        log.info("Back to Routine Overview Screen");
        //waitForElementClickAbility(waveSeriesSoloObject.backBTN);

        //waitForElementClickAbility(primeObj.backHomePageFromRoutine);
        Point backPoint = getCenterCoordinates(primeObj.backHomePagefromRoutine);
        action_clickOnPosition(backPoint.getX(), backPoint.getY());
        System.out.println("Back to Saved tab");
        log.info("Back to Saved tab");
        try{
        Assert.assertFalse(waveRollerObjects.getRoutineName(routineName).isDisplayed(), "Unsaved routine is still listed on Saved tab");
        }
        catch (NoSuchElementException e){
            System.out.println("Unsaved routine got removed from list of Saved routines");
            log.info("Unsaved routine got removed from list of Saved routines");
        }
        waitForElementClickAbility(waveSoloObjects.homeTab);
        System.out.println("Welcome back to Homepage");
        log.info("Welcome back to Homepage");
    }

    public void saveRoutineFromOverviewScreen() throws InterruptedException {
        selectRoutine();
        waveSoloFunctions.saveRoutine();
    }

    public void unSaveRoutineFromSavedTab(){
        waitForElementClickAbility(waveSoloObjects.moreOptions);
        //waitForElementClickAbility(waveRollerObjects.unSaveOptionOnSavedTab);
        Point unSave = getCenterCoordinates(waveRollerObjects.unSaveOptionOnSavedTab);
        action_clickOnPosition(unSave.getX(), unSave.getY());
        System.out.println("Clicked on Removed from saved button");
        try {
            //waitForElementDisplayed(waveSoloObjects.getRemovedFromSavedToast(routineName));
            Thread.sleep(2000);
            Assert.assertTrue(waveSoloObjects.getRemovedFromSavedToast(routineName).isEnabled());
            System.out.println("Tooltip verified");
        }catch (NoSuchElementException e){
            System.out.println("Loader took longer. Retrying...");
            waitForElementVisibility(waveSoloObjects.savedTab);
            Assert.assertTrue(waveSoloObjects.getRemovedFromSavedToast(routineName).isEnabled());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Removed saved routine from Saved tab");
        log.info("Removed saved routine from Saved tab");
        waitForElementClickAbility(waveSoloObjects.homeTab);
        System.out.println("Welcome back to HomePage!");
        log.info("Welcome back to HomePage!");
    }

    public void backHomePage(){
        waitForElementClickAbility(primeObj.homeTab);
        System.out.println("Welcome back to Homepage");
        log.info("Welcome back to Homepage");
    }

    public void horizontalScroll(){
        TouchAction horizontalScroll = new TouchAction((PerformsTouchActions) driver);
        Dimension size = driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;
        int startXCoordinate = (int) (width * 0.7); // Start from the right side of the screen
        int endXCoordinate = (int) (width * 0.2); // End on the left side of the screen
        int middleOfY = height / 2;

        horizontalScroll.press(PointOption.point(startXCoordinate, middleOfY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(endXCoordinate, middleOfY)).release().perform();
    }

    public void verticalScroll(){
        TouchAction verticalScroll =new TouchAction((PerformsTouchActions) driver);
        Dimension size	=driver.manage().window().getSize();
        int width=size.width;
        int height=size.height;
        int middleOfX=width/2;
        int startYCoordinate= (int)(height*.7);
        int endYCoordinate= (int)(height*.2);

        verticalScroll.press(PointOption.point(middleOfX, startYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
    }
}

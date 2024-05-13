package pageFunctions;

import base.Setup;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import pageObjects.*;


public class NonBLECommonFunctions extends Setup {

    public NonBLECommonObjects nonBLECommonObjects;
    public AddDeviceObjects addDeviceObjects;
    public WaveSeriesOtherRollerObjects waveRollerObjects;
    public WaveSeriesSoloObjects waveSoloObjects;
    public TheragunMiniObjects miniObjects;


    public NonBLECommonFunctions() {
        nonBLECommonObjects = new NonBLECommonObjects();
        addDeviceObjects = new AddDeviceObjects();
        waveRollerObjects = new WaveSeriesOtherRollerObjects();
        waveSoloObjects = new WaveSeriesSoloObjects();
        miniObjects = new TheragunMiniObjects();
    }

    public void skipOnboarding(){
        try {
            waitForElementClickAbility(nonBLECommonObjects.skipDeviceCategory);
        }catch (TimeoutException e){
            System.out.println("Page didn't appear!");
        }


        if(platform_param.equalsIgnoreCase("iOS")){

            try{
                waitForElementClickAbility(addDeviceObjects.enableNotification);
                acceptAlert();
            }catch (NoSuchElementException e){
                System.out.println("Notification permission screen appears only after fresh app launch.");
            }catch (TimeoutException e){
                System.out.println("Notification permission screen appears only after fresh app launch.");
            }

        }else {
            System.out.println("Notification permission screen : N/A for Android");
        }


    }

    public void openDeviceManager() {
        waitForElementClickAbility(addDeviceObjects.deviceDropDown);
    }


    public void pairGivenDevice(String device) throws InterruptedException {
        if (device.equalsIgnoreCase("Roller")) {
            pairOtherRoller();
        } else if (device.equalsIgnoreCase("Theragun Mini")) {
            pairMiniGeneration1();
        } else if (device.equalsIgnoreCase("Theragun Relief")) {
            pairRelief();
        } else if (device.equalsIgnoreCase("Theragun G3")) {
            pairG3();
        } else if (device.equalsIgnoreCase("Theragun G2PROG1")) {
            pairG2PROG1();
        } else if (device.equalsIgnoreCase("Theragun Liv")) {
            pairLiv();
        } else if (device.equalsIgnoreCase("Theragun G3PRO")) {
            pairG3PRO();
        } else {
            System.out.println("Please enter valid device name");
        }
    }

    public void pairOtherRoller() {
        //waitForElementClickAbility(addDeviceObjects.deviceDropDown);
        waitForElementClickAbility(waveRollerObjects.waveSeriesCategory);
        waitForElementClickAbility(waveRollerObjects.otherRoller);
        try {
            waitForElementVisibility(waveRollerObjects.pairedOtherRoller);
            Assert.assertTrue(waveRollerObjects.pairedOtherRoller.isDisplayed());
        }catch (NoSuchElementException e){
            Assert.assertTrue(waveSoloObjects.closeDeviceManager.isDisplayed());
        }catch (StaleElementReferenceException e){
            System.out.println("Device has been paired.");
        }

        waitForElementClickAbility(waveSoloObjects.closeDeviceManager);
    }

    public void pairMiniGeneration1() {
        waitForElementClickAbility(addDeviceObjects.theragun);
        utilityMethods.scroll(nonBLECommonObjects.G3PRO, "Generation 1");
        if (platform_param.equalsIgnoreCase("iOS")) {
            Point mini = getCenterCoordinates(miniObjects.miniGeneration1);
            action_clickOnPosition(mini.getX(), mini.getY());
        } else {
            waitForElementClickAbility(miniObjects.miniGeneration1);
        }
        waitForElementClickAbility(miniObjects.continueBTN);
        waitForElementClickAbility(miniObjects.continueBTN);
        waitForElementClickAbility(miniObjects.getStartedBTN);
        waitForElementClickAbility(waveSoloObjects.closeDeviceManager);
    }

    public void pairRelief() throws InterruptedException {
        waitForElementClickAbility(addDeviceObjects.theragun);
        waitForElementClickAbility(nonBLECommonObjects.relief);
        waitForElementClickAbility(nonBLECommonObjects.reliefOnboarding1);
        Thread.sleep(5000);
        if (platform_param.equalsIgnoreCase("Android")) {
            waitForElementClickAbility(nonBLECommonObjects.xIcon);
        } else {
            waveSoloObjects.closeBTN.click();
        }
        waitForElementClickAbility(waveSoloObjects.endRoutine);
        waitForElementClickAbility(nonBLECommonObjects.reliefOnboarding2);
        Thread.sleep(5000);
        if (platform_param.equalsIgnoreCase("Android")) {
            waitForElementClickAbility(nonBLECommonObjects.xIcon);
        } else {
            waveSoloObjects.closeBTN.click();
        }
        waitForElementClickAbility(waveSoloObjects.endRoutine);
        waitForElementClickAbility(nonBLECommonObjects.reliefOnboarding3);
        Thread.sleep(5000);
        if (platform_param.equalsIgnoreCase("Android")) {
            waitForElementClickAbility(nonBLECommonObjects.xIcon);
        } else {
            waveSoloObjects.closeBTN.click();
        }
        waitForElementClickAbility(waveSoloObjects.endRoutine);
        waitForElementClickAbility(waveSoloObjects.closeDeviceManager);
    }

    public void pairG3() {
        waitForElementClickAbility(addDeviceObjects.theragun);
        utilityMethods.scroll(nonBLECommonObjects.G3PRO, "G3");
        waitForElementClickAbility(nonBLECommonObjects.G3);
        waitForElementClickAbility(miniObjects.getStartedBTN);
        waitForElementClickAbility(waveSoloObjects.closeDeviceManager);
    }

    public void pairG2PROG1() {
        waitForElementClickAbility(addDeviceObjects.theragun);
        utilityMethods.scroll(nonBLECommonObjects.G3PRO, "G2PRO/G1");
        waitForElementClickAbility(nonBLECommonObjects.G2PROG1);
        waitForElementClickAbility(miniObjects.getStartedBTN);
        waitForElementClickAbility(waveSoloObjects.closeDeviceManager);

    }

    public void pairLiv() {
        waitForElementClickAbility(addDeviceObjects.theragun);
        utilityMethods.scroll(nonBLECommonObjects.G3PRO, "liv");
        waitForElementClickAbility(nonBLECommonObjects.liv);
        waitForElementClickAbility(miniObjects.getStartedBTN);
        waitForElementClickAbility(waveSoloObjects.closeDeviceManager);

    }

    public void pairG3PRO() {
        waitForElementClickAbility(addDeviceObjects.theragun);
        utilityMethods.scroll(nonBLECommonObjects.G3PRO, "G3PRO");
        waitForElementClickAbility(nonBLECommonObjects.G3PRO);
        waitForElementClickAbility(miniObjects.getStartedBTN);
        waitForElementClickAbility(waveSoloObjects.closeDeviceManager);
    }


}

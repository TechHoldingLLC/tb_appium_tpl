package testCases;

import base.Setup;
import org.testng.annotations.*;
import pageFunctions.*;
import utilities.RetryAnalyzer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NonBLECommanTCs extends Setup {
    public NonBLECommonFunctions nonBLEfunctions;
    public WaveSeriesOtherRollerFunctions waveRollerFunctions;
    public WaveSeriesSoloFunctions waveSoloFunctions;
    public PrimeDeviceFunctions primeDeviceFunctions;
    public LoginFunctions loginFunctions;
    public String device_param;
    @BeforeClass
    public void init(){
            waveRollerFunctions = new WaveSeriesOtherRollerFunctions();
            waveSoloFunctions = new WaveSeriesSoloFunctions();
            primeDeviceFunctions = new PrimeDeviceFunctions();
            nonBLEfunctions = new NonBLECommonFunctions();
    }


    @BeforeTest
    public void testInitialization() throws InterruptedException {
        loginFunctions = new LoginFunctions();

        loginFunctions.loginFlow();
    }


    @Test(priority = 1)
    public void testSkipOnboarding()  {
        testCaseID = "29754";
        nonBLEfunctions.skipOnboarding();
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void testOpenDeviceManager(){
        testCaseID = "29755";
        nonBLEfunctions.openDeviceManager();
    }

    @Parameters({"device"})
    @Test(priority = 3, dependsOnMethods = "testOpenDeviceManager")
    public void testPairDevice(String device) throws InterruptedException {
        testCaseID = "29756";
        device_param = device;
        nonBLEfunctions.pairGivenDevice(device_param);
    }

    @Test(priority = 4, dependsOnMethods = "testPairDevice" )
    public void testSelectRoutine() throws InterruptedException {
        testCaseID = "29757";
        waveRollerFunctions.selectRoutine();
    }

    @Test(priority = 5,dependsOnMethods = "testSelectRoutine")
    public void testStretchingStep() throws InterruptedException {
        waveSoloFunctions.routineStepStretching();
    }

    @Test(priority = 6, dependsOnMethods = "testSelectRoutine")
    public void testBreakToggle() throws InterruptedException {
        waveSoloFunctions.addBreak();
    }


    @Test(priority = 7)
    public void testNotConnectedMode() throws InterruptedException {
        waveRollerFunctions.notConnectedMode();
    }


    @Test(priority = 8)
    public void testPreferencesOnProfile() throws InterruptedException {
        waveRollerFunctions.preferencesOnProfile();
    }
    @Test(priority = 9, retryAnalyzer = RetryAnalyzer.class)
    public void testTipForNonBLE() throws InterruptedException {
        waveRollerFunctions.tipForNonBLE();
    }
    @Test(priority = 10, dependsOnMethods = "testSelectRoutine")
    public void testRoutineCompletionForNonBLE() throws InterruptedException {
        waveRollerFunctions.routineCompletionForNonBLE();
    }

    @Test(priority = 11, dependsOnMethods = {"testSelectRoutine", "testRoutineCompletionForNonBLE"})
    public void testSaveRoutineFromCompletionScreen(){
        waveRollerFunctions.saveRoutineFromCompletionScreen();
    }

    @Test(priority = 12,dependsOnMethods="testSaveRoutineFromCompletionScreen")
    public void testUnSaveRoutineFromRoutineCompletionScreen() throws InterruptedException {
        waveRollerFunctions.unSaveRoutineFromRoutineCompletionScreen();
    }

    @Test(priority = 13)
    public void testSaveRoutineFromOverviewScreen() throws InterruptedException {
        waveRollerFunctions.saveRoutineFromOverviewScreen();
    }

    @Test(priority = 14, dependsOnMethods = "testSaveRoutineFromOverviewScreen")
    public void testUnSaveRoutineFromSavedTab(){
        waveRollerFunctions.unSaveRoutineFromSavedTab();
    }
    @Test(priority = 15)
    public void testForgetDevice(){
        // waveRollerFunctions.backHomePage();
        primeDeviceFunctions.forgetDevice();
    }

    @AfterTest
    public void testLogout(){
        loginFunctions.logout();
    }
}

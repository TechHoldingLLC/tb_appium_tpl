package testCases;

import base.Setup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageFunctions.OnboardingFlowFunctions;
import pageFunctions.PrimeDeviceFunctions;
import pageFunctions.WaveSeriesOtherRollerFunctions;
import pageFunctions.WaveSeriesSoloFunctions;
import pageObjects.PrimeDeviceObjects;
import utilities.RetryAnalyzer;

public class PrimeDeviceTCs extends Setup {

    private WaveSeriesOtherRollerFunctions waveRollerFunctions;
    private WaveSeriesSoloFunctions waveSoloFunctions;
    private PrimeDeviceFunctions primeDeviceFunctions;
    public WaveSeriesSoloFunctions wave;

    @BeforeClass
    public void init(){
        waveRollerFunctions = new WaveSeriesOtherRollerFunctions();
        waveSoloFunctions = new WaveSeriesSoloFunctions();
        primeDeviceFunctions = new PrimeDeviceFunctions();
        wave = new WaveSeriesSoloFunctions();
    }
  /*  //Demo testcases: 1 & 4
    @Test(priority = 1)
    public void testOpenAndSaveRoutine(){
        primeObject.openAndSaveRoutine();
    }

   @Test(priority = 2)
    public void testRemoveSavedRoutineFromRoutineCompletionScreen() throws InterruptedException {
        primeObject.unSaveRoutineFromRoutineCompletionScreen();
    }*/

    @Test(priority = 3)
    public void testQuickStart() throws InterruptedException {
        primeDeviceFunctions.quickStart();
    }

   /* @Test(priority = 2)
    public void testOnboardingCard() throws InterruptedException {
        onboardingObject.onboardingCard();
    }*/

   /* @Test(priority = 4)
    public void testForgetDevice(){
        primeObject.forgetDevice();
    }*/


    @Test(priority = 4)
    public void testSelectRoutine() throws InterruptedException {
       // testCaseID = "29757";
        waveRollerFunctions.selectRoutine();
    }
    @Test(priority = 5)
    public void testRoutinePlayerBehaviour() throws InterruptedException {
        wave.routinePlayerBehaviour();
    }

    @Test(priority = 6)
    public void testStretchingStep() throws InterruptedException {
        waveSoloFunctions.routineStepStretching();
    }
    @Test(priority = 7)
    public void testSkipStretching() throws InterruptedException {
        wave.removeStretchingStep();

    }

    @Test(priority = 8)
    public void testBreakToggle() throws InterruptedException {
        waveSoloFunctions.addBreak();
    }




   /* @Test(priority = 9)
    public void testUnSaveRoutineFromRoutineCompletionScreen() throws InterruptedException {
        waveRollerFunctions.unSaveRoutineFromRoutineCompletionScreen();
    }*/

    @Test(priority = 10)
    public void testSaveRoutineFromOverviewScreen() throws InterruptedException {
        waveRollerFunctions.saveRoutineFromOverviewScreen();
    }

    @Test(priority = 11, dependsOnMethods = "testSaveRoutineFromOverviewScreen")
    public void testUnSaveRoutineFromSavedTab(){
        waveRollerFunctions.unSaveRoutineFromSavedTab();
    }
    @Test(priority = 12)
    public void testForgetDevice(){
        // waveRollerFunctions.backHomePage();
        primeDeviceFunctions.forgetDevice();
    }
}

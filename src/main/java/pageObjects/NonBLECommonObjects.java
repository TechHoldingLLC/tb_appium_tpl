package pageObjects;

import base.Setup;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NonBLECommonObjects extends Setup {

    public NonBLECommonObjects(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SKIP\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SKIP']")
    public WebElement skipDeviceCategory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Relief\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Relief']")
    public WebElement relief;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Therabody\"]/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    public WebElement reliefOnboarding1;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Therabody\"]/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
    public WebElement reliefOnboarding2;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Therabody\"]/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]")
    public WebElement reliefOnboarding3;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView[2]")
    public WebElement xIcon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"G3\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='G3']")
    public WebElement G3;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"G2PRO/G1\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='G2PRO/G1']")
    public WebElement G2PROG1;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"liv\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='liv']")
    public WebElement liv;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"G3PRO\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='G3PRO']")
    public WebElement G3PRO;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"RETRY\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='RETRY']")
    public WebElement retryBTN;
}

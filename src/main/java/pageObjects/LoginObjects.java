package pageObjects;

import base.Setup;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjects extends Setup {
    public LoginObjects(){

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"SKIP\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SKIP\"]")
    public WebElement introSkip1;

    @iOSXCUITFindBy(accessibility = "UIA.Therabody.Welcome.SigninButton")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Already have an account? Log in\"]")
    public WebElement loginbtn;

    @iOSXCUITFindBy(accessibility = "UIA.Therabody.Signin.TitleLabel")
    public WebElement loginTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"UIA.Therabody.Signin.EmailTextField\"]")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Email address']")
    public WebElement login_email;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"UIA.Therabody.Signin.PasswordTextField\"]")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
    public WebElement login_password;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"UIA.Therabody.Signin.SigninButton\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"CONTINUE\"]")
    public WebElement login_continue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"UIA.Therabody.TabBar.ProfileTab\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Profile']")
    public WebElement profileTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Log out\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log out']")
    public WebElement logout;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Log out\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='LOG OUT']")
    public WebElement logoutConfirm;

}

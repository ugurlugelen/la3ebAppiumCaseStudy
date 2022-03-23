package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class ElementsPage {

    public ElementsPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(15)),this);
    }

    @AndroidFindBy(xpath = "//*[@text='Hesabım']")
    public MobileElement myAccountButton;

    public MobileElement desiredAndroidElement(String name){
        return (MobileElement) Driver.getAppiumDriver().findElementByXPath("//*[@text='"+name+"']");
    }



    @AndroidFindBy(id = "com.dmall.mfandroid:id/myAccountFragmentLogInBtn")
    public AndroidElement loginButton;

    @AndroidFindBy(id = "com.dmall.mfandroid:id/createAccountTxt")
    public AndroidElement creteAccountButton;

    @AndroidFindBy(id = "com.dmall.mfandroid:id/registerNameET")
    public AndroidElement nameTextbox;

    @AndroidFindBy(id = "com.dmall.mfandroid:id/registerSurnameET")
    public AndroidElement surNameTextbox;

    @AndroidFindBy(id = "com.dmall.mfandroid:id/registerEmailET")
    public AndroidElement emailTextbox;

    @AndroidFindBy(id = "com.dmall.mfandroid:id/registerPassET")
    public AndroidElement passwordTextBox;

    @AndroidFindBy(id = "com.dmall.mfandroid:id/genderTET")
    public AndroidElement genderTextBox;

    @AndroidFindBy(xpath = "//*[@text='Erkek']")
    public AndroidElement menTextBox;

    @AndroidFindBy(id = "com.dmall.mfandroid:id/loginFragmentRegisterAgreementCB")
    public AndroidElement userAgrementCheckBox;

    @AndroidFindBy(id = "com.dmall.mfandroid:id/permissionCB")
    public AndroidElement mailPermissionCheckBox;

    @AndroidFindBy(id = "com.dmall.mfandroid:id/RegisterBtn")
    public AndroidElement completeRegistrationButton;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.dmall.mfandroid:id/tvTitle'])[1]")
    public AndroidElement firstProductAtPLP;

    @AndroidFindBy(id = "com.dmall.mfandroid:id/pdpAddToCartButton")
    public AndroidElement addToCartButton;

    @AndroidFindBy(id="com.dmall.mfandroid:id/ab_basket")
    public AndroidElement basketButton;

   @AndroidFindBy(id = "com.dmall.mfandroid:id/basketItemTitleTV")
   public AndroidElement productNameAtBasket;

   @AndroidFindBy(id = "com.dmall.mfandroid:id/productDetailsCommentCountTV")
    public AndroidElement allCommentsButton;

   @AndroidFindBy(id = "com.dmall.mfandroid:id/titleTV")
    public AndroidElement productCommentPageTitle;

   @AndroidFindBy(id = "com.dmall.mfandroid:id/fbLoginBtn")
    public AndroidElement facebookLoginButton;

   @AndroidFindBy(id = "m_login_email")
    public AndroidElement facebookEmailTextBox;

   @AndroidFindBy(id = "m_login_password")
    public AndroidElement facebookPasswordTextbox;

   @FindBy(xpath = "//input[@name='email']")
    public WebElement nativeChromeEmailTextBox;

    @FindBy(xpath = "//input[@name='pass']")
    public WebElement nativeChromePasswordTextBox;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement nativeChromeFacebookLoginButton;

    @AndroidFindBy(id = "com.dmall.mfandroid:id/myAccountUserMailTV")
    public AndroidElement registeredEmail;





















}

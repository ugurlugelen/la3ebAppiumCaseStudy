package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import utilities.BaseTest;
import utilities.ReusableMethods;

public class CaseStudy extends BaseTest {

    ElementsPage pages;

    @Test(testName = "Register  New Account")
    void case001() {
        pages = new ElementsPage();
        extentTest.info("User navigates to my account page");
        pages.myAccountButton.click();
        extentTest.info("User clicks on login button");
        pages.loginButton.click();
        extentTest.info("User clicks on create account button");
        pages.creteAccountButton.click();
        extentTest.info("User starts to fill mandatory sections");
        pages.nameTextbox.sendKeys("Adem");
        pages.surNameTextbox.sendKeys("Ugurrr");
        pages.emailTextbox.sendKeys("ademmail23@gmail.com");
        pages.passwordTextBox.sendKeys("Qwe12345.");
        pages.genderTextBox.click();
        pages.menTextBox.click();
        pages.userAgrementCheckBox.click();
        pages.mailPermissionCheckBox.click();
        extentTest.info("User completed filling areas");
        extentTest.info("User clicks on register button");
        pages.completeRegistrationButton.click();
        try {
            Assert.assertEquals(pages.registeredEmail.getText(), "ademmail23@gmail.com");
            extentTest.pass("Registration is completed succesfully");
        } catch (Exception e) {
            Assert.fail("Registration failed");
        }
    }

    @Test(testName = "Facebook Login",enabled = false)
    void case002() {
        pages = new ElementsPage();
        pages.myAccountButton.click();
        pages.loginButton.click();
        pages.facebookLoginButton.click();
        ReusableMethods.setContext("WEBVIEW_chrome");
        ReusableMethods.waitFor(3000);
        pages.nativeChromeEmailTextBox.sendKeys("adursun10@yaani.com");
        pages.nativeChromePasswordTextBox.sendKeys("Gantep27");
    }

    @Test(testName = "Add a product to cart")
    void case003() throws InterruptedException {
        pages = new ElementsPage();
        extentTest.info("User selects categories tab from buttom menu");
        pages.desiredAndroidElement("Kategoriler").click();
        extentTest.info("User navigates Electronics categories");
        pages.desiredAndroidElement("Elektronik").click();
        extentTest.info("User navigates Phones & Accessories submenu");
        pages.desiredAndroidElement("Telefon & Aksesuarları").click();
        extentTest.info("User navigates Mobile Phones");
        pages.desiredAndroidElement("Cep Telefonu").click();
        extentTest.info("User selects first product from page");
        String expectedProduct = pages.firstProductAtPLP.getText();
        pages.firstProductAtPLP.click();
        extentTest.info("User adds product to cart");
        pages.addToCartButton.click();
        extentTest.info("User clicks on basket button");
        Thread.sleep(2000);
        pages.basketButton.click();
        String addedProduct = pages.productNameAtBasket.getText();
        try {
            Assert.assertEquals(addedProduct, expectedProduct);
            extentTest.pass("Correct product is added to cart");
        } catch (AssertionError error) {
            extentTest.fail("Test failed, wwrong product is added to cart");
        }
    }

    @Test(testName = "Make a review to a product")
    void case004() {
        pages = new ElementsPage();
        extentTest.info("User selects categories tab from buttom menu");
        pages.desiredAndroidElement("Kategoriler").click();
        extentTest.info("User navigates Electronics categories");
        pages.desiredAndroidElement("Elektronik").click();
        extentTest.info("User navigates Phones & Accessories submenu");
        pages.desiredAndroidElement("Telefon & Aksesuarları").click();
        extentTest.info("User navigates Mobile Phones");
        pages.desiredAndroidElement("Cep Telefonu").click();
        extentTest.info("User selects first product from page");
        pages.firstProductAtPLP.click();
        extentTest.info("User navigates review page of product");
        pages.allCommentsButton.click();
        Assert.assertEquals(pages.productCommentPageTitle.getText(), "Ürün Yorumları", "Review page title is wrong");
    }
}

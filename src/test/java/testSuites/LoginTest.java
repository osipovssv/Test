package testSuites;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
public class LoginTest extends BaseTest {
    @Test
    public void login_suspiciousActivity() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.getSuspiciousActivity());
    }

    @Test
    public void login_incorrectPassword_error() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, password + "4");
        Assert.assertTrue(loginPage.getErrorMessage());
    }

    @Test
    public void forgotPassword_incorrectName_error() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.forgotPassword(username);
        Assert.assertTrue(loginPage.getHeadingText());
    }
}

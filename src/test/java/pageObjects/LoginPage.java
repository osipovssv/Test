package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testSuites.BaseTest;

public class LoginPage extends BasePage {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://gmail.com");
    }

    private WebElement getEmailField() {
        By getEmailFieldLocator = By.name("identifier");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getEmailFieldLocator));
        return driver.findElement(getEmailFieldLocator);
    }

    private WebElement getPasswordField() {
        By getPasswordFieldLocator = By.xpath("//*[@type=\"password\"]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getPasswordFieldLocator));
        return driver.findElement(getPasswordFieldLocator);
    }

    private WebElement getNextBtn() {
        By getNextBtnLocator = By.xpath("//*[text()=\"Далее\"]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getNextBtnLocator));
        return driver.findElement(getNextBtnLocator);
    }

    private WebElement getForgotPasswordBtn() {
        By getForgotPasswordBtnLocator = By.xpath("//*[contains(text(), \"Забыли\")]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getForgotPasswordBtnLocator));
        return driver.findElement(getForgotPasswordBtnLocator);
    }

    private WebElement getFirstNameField() {
        By getFirstNameFieldLocator = By.name("firstName");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getFirstNameFieldLocator));
        return driver.findElement(getFirstNameFieldLocator);
    }

    private WebElement getLastNameField() {
        By getLastNameFieldLocator = By.name("lastName");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLastNameFieldLocator));
        return driver.findElement(getLastNameFieldLocator);
    }

    public boolean getErrorMessage() {
        By getErrorMessageLocator = By.xpath("//*[@class=\"EjBTad\"]//following-sibling::div");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getErrorMessageLocator));
        return true;
    }

    public boolean getSuspiciousActivity() {
        By getSuspiciousActivityLocator = By.id("next-button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getSuspiciousActivityLocator));
        return true;
    }

    public boolean getHeadingText() {
        By getHeadingTextLocator = By.xpath("//*[text()=\"Аккаунт не найден\"]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getHeadingTextLocator));
        return true;
    }

    public void login(String username, String password) {
        getEmailField().sendKeys(username);
        getNextBtn().click();
        getPasswordField().sendKeys(password);
        getNextBtn().click();
    }

    public void forgotPassword(String username) {
        getForgotPasswordBtn().click();
        getEmailField().sendKeys(username);
        getNextBtn().click();
        getFirstNameField().sendKeys("Тестовый");
        getLastNameField().sendKeys("Аккаунт");
        getNextBtn().click();
    }
}

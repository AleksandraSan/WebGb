package gb;

import gb.BaseView;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseView {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Username']/following-sibling::input")
    private WebElement loginField;

    @FindBy(xpath = "//span[.='Password']/following-sibling::input")
    private WebElement passwordField;

    @FindBy(xpath = "//span[@class='mdc-button__label']")
    public WebElement loginButton;


    public MyAccountPage authorizedUser(String username, String password) throws InterruptedException {
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        Thread.sleep(5000);
        return new MyAccountPage(driver);
    }

    public ErrorBlock authorizedNeValidParam(String username, String password){
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        return new ErrorBlock(driver);
    }


}

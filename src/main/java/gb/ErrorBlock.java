package gb;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ErrorBlock extends BaseView {

    public ErrorBlock(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "//div[@class=\"container svelte-1pbgeyl\"]//p[contains(., '500')]")
    public WebElement errorArgIsNotAByteString;

    @FindBy(xpath = "error-block svelte-uwkxn9")
    public WebElement blockErrorAuhozitaion;

    public void checkIncorrectLoginError() throws InterruptedException {
        Assertions.assertTrue(errorArgIsNotAByteString.isDisplayed());
    }

    public void checkErrorBlock(){
        ExpectedConditions.visibilityOfElementLocated((By) blockErrorAuhozitaion);
        Assertions.assertTrue(blockErrorAuhozitaion.isDisplayed());
    }
}


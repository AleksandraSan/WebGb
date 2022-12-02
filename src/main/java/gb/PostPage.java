package gb;

import gb.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends BaseView {

    public PostPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Home']")
    public WebElement buttonHome;

    public MyAccountPage goToAccountPage(){
        buttonHome.click();
        return new MyAccountPage(driver);
    }
}

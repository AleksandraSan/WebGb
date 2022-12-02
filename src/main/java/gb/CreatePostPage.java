package gb;

import gb.BaseView;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreatePostPage extends BaseView {

    public CreatePostPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"field\"]//input[@type=\"text\"]")
    public WebElement title;

    @FindBy(xpath = "//div[@class='submit']/button")
    public WebElement buttonSave;


    public PostPage postInfo(String titleForPost){
        title.sendKeys(titleForPost);
        buttonSave.click();
        return new PostPage(driver);
    }






}

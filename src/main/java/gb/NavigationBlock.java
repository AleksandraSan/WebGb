package gb;

import gb.BaseView;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationBlock extends BaseView {
    public NavigationBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"mdc-form-field\"]//span[text ()= \"Order\"]/parent::label/preceding-sibling::button")
    public WebElement iconSort;

    @FindBy(xpath = "//div[@class=\"mdc-form-field\"]//span[text ()= \"Not my Posts\"]/parent::label/preceding-sibling::button")
    private WebElement swithNotMyPost;

    @FindBy(xpath = "//div[@class=\"button-block svelte-1e9zcmy\"]//button")
    private WebElement buttonCreatePost;


    //order - desc
    public MyAccountPage sortedPostByDESC() {
        iconSort.click();
        return new MyAccountPage(driver);
    }

    public CreatePostPage createPost() throws InterruptedException {
        buttonCreatePost.click();
        return new CreatePostPage(driver);
    }

    public NotMyPostPage geyNotMyPost(){
        ExpectedConditions.elementToBeClickable(swithNotMyPost);
        swithNotMyPost.click();
        return new NotMyPostPage(driver);
    }

}

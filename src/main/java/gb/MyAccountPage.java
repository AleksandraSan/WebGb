package gb;

import gb.BaseView;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MyAccountPage extends BaseView {
    public NavigationBlock navigationBlock;

    @FindBy(xpath = "//span[.='Home']")
    public WebElement blog;

    @FindBy(xpath = "//div[@class=\"content\"]//a[.=\"Next Page\"]")
    public WebElement nextPageButton;

    @FindBy(xpath = "//div[@class=\"content\"]//a[.=\"Previous Page\"]")
    public WebElement previousPage;

    @FindBy(xpath = "//div[@class = \"content\"]/div/a[1]/div")
    public WebElement firstPost;

    @FindBy(xpath = "//div[@class=\"posts svelte-127jg4t\"]/a")
    public List<WebElement> listMyPosts;

    @FindBy(xpath = "//div[@class = \"content\"]/div/a[1]/img")
    public WebElement img;

    @FindBy(xpath = "//h2[1]")
    public WebElement headerPost;

    @FindBy(xpath = "//div[@class = \"content\"]/div/a[1]/div")
    public WebElement description;


    public MyAccountPage(WebDriver driver) {
        super(driver);
        navigationBlock = new NavigationBlock(driver);
    }

    public MyAccountPage nextPageMyPost(){
        actions.scrollToElement(nextPageButton).click();
        ExpectedConditions.elementToBeClickable(previousPage);
        previousPage.click();
        return new MyAccountPage(driver);
    }

    void successAuthorization() throws InterruptedException {
        Assertions.assertEquals("https://test-stand.gb.ru/", driver.getCurrentUrl());
    }

    public void successSort(){
        Assertions.assertTrue(firstPost.isDisplayed());
    }

    public void successCreatePost(String title){
        Assertions.assertEquals(headerPost.getText(), title);
    }

    public void postContentAssert(){
        Assertions.assertTrue(description.isEnabled());
        Assertions.assertTrue(headerPost.isEnabled());
        Assertions.assertTrue(img.isEnabled());
    }

    public void successNavigationPage(){
        //в ссылке указан номер следующей страницы
        Assertions.assertEquals(nextPageButton.getAttribute("href"), "https://test-stand.gb.ru/?page=2");
    }
}

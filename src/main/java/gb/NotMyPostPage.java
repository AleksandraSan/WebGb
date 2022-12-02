package gb;

import gb.BaseView;
import gb.NavigationBlock;
import javafx.geometry.Pos;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NotMyPostPage extends BaseView {
    public NavigationBlock navigationBlock;

    public NotMyPostPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='posts svelte-127jg4t']/a")
    public List<WebElement> notMyPostsList;


    //переход к чужому посту
    public PostPage goToNotMyPostInfo(String title){
        notMyPostsList.stream().filter(d -> d.getText().contains(title)).findFirst().get().click();
        Assertions.assertEquals("https://test-stand.gb.ru/posts/2", driver.getCurrentUrl());
        return new PostPage(driver);
    }


}

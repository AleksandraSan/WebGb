package gb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class TestStandGBTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://test-stand.gb.ru/");
    }


    @DisplayName("ТЕСТ 1:Успешная авторизация пользователя с 20 символами в логине - граница")
    @Test
    void authorizationTest() throws InterruptedException {
        loginPage.authorizedUser("ztknrglonuwvdnhasyah","d49e6d2180")
                .successAuthorization();
        //+проверка успешной авторизации
    }


    @Test
    @DisplayName("ТЕСТ 2:Количество символов в логине не должно быть больше 20, проверка с 21 символом - баг номер 11")
    /*в данном случае проверка падает , потому что авторизация прошла успешно.
    Но исходя из требований система не должна пропускать пользователя с логином более 20 символов
    и должна выдавать соответсвующую ошибку!
     */
    void authorizedNeValidTest(){
        loginPage.authorizedNeValidParam("21simvolvlogineneval", "57376c0977")
                .checkErrorBlock();
    }


    @Test
    /*в данном случае проверка падает , потому что авторизация прошла успешно.
    Но исходя из требований система не должна пропускать пользователя с логином менее 3 символов
    и должна выдавать соответсвующую ошибку!
     */
    @DisplayName("ТЕСТ 3:Количество символов в логине не должно быть менее 3, проверка с 2 символами")
    void authrizedWith3SimbolTest(){
        loginPage.authorizedNeValidParam("Im", "d0fa7c3b59")
                .checkErrorBlock();
    }


    @DisplayName("ТЕСТ 4: Создание логина с кириллическими символами НЕВАЛИДНЫЙ ПАРАМЕТР")
    @Test
    void negativeAuthTest() throws InterruptedException {
        loginPage.authorizedNeValidParam("СашаТест","4514b04330")
                .checkIncorrectLoginError();
    }

    @DisplayName("ТЕСТ 5:Создание поста с заголовком")
    @Test
    void createPostTest() throws InterruptedException {
        loginPage.authorizedUser("alex_san_qa", "6a5cd2f12b")
                .navigationBlock
                .createPost()
                .postInfo("My first post auto!")
                .goToAccountPage()
                .successCreatePost("My first post auto!");
    }

    @DisplayName("ТЕСТ 6: Навигация между страницами")
    @Test
    /*Проверяем корректность переключения между страничками с постами,
    проверяем что при клике на кнопку "previous page" мы снова возвращаемся на
    предыдущую страницу*/

    void myPostPageCliksTest() throws InterruptedException {
        loginPage.authorizedUser("alex_san_qa", "6a5cd2f12b")
                .nextPageMyPost()
                .successNavigationPage();
    }

    @DisplayName("ТЕСТ 7: Сортировка по параметру Desc(убывание)")
    @Test
    void sortByDescParamTest() throws InterruptedException {
        loginPage.authorizedUser("alex_san_qa", "6a5cd2f12b")
                .navigationBlock
                .sortedPostByDESC()
                .successSort();
    }


    /*проверяем, что пост содержит заголовок, описание и картинку
     которые доступы для редактирования. */
    @DisplayName("ТЕСТ 8: Содеражание собственного поста: заголовок, описание, картинка")
    @Test
    void myPostTest() throws InterruptedException {
        loginPage.authorizedUser("alex_san_qa", "6a5cd2f12b")
                .postContentAssert();
    }



    //Проверяем: Получаем список всех чужих постов и ищем по заголовку нужный
    @DisplayName("ТЕСТ 9: Получение списка чужих постов, и поиск по заголовку")
    @Test
    void notMyPostTest() throws InterruptedException {
        loginPage.authorizedUser("alex_san_qa", "6a5cd2f12b")
                .navigationBlock
                .geyNotMyPost()
                .goToNotMyPostInfo("Русские пельмени");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}

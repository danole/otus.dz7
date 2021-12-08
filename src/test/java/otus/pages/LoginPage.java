package otus.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BasePage {

    protected Logger logger = LogManager.getLogger(LoginPage.class.getName());
    private final String registrationModalWindow = "//button[@class='header2__auth js-open-modal']";
    private final String email = "//input[@type='text' and @name='email' and @autocomplete='off']";
    private final String password = "//input[@name='password']";
    private final String submit = "//button[@class='new-button new-button_full new-button_blue new-button_md']";

    public LoginPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }

    public MainPage signUp() {
        driver.get("https://otus.ru");
        logger.info("Открылся браузер, перешли на сайт");

        waitToClickableButton(registrationModalWindow).click();
        logger.info("Открылось модальное окно для регистрации ");

//        String passwordProp = System.getProperty("password");
//        String loginProp = System.getProperty("login");
        waitToVisibleElement(email).sendKeys("1990boot1990@gmail.com");
        waitToVisibleElement(password).sendKeys("test1234");
        waitToVisibleElement(submit).submit();
        logger.info("Вошли в личный кабинет");
        return new MainPage(driver, actions);
    }

}

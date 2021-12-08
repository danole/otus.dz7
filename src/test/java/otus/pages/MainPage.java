package otus.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends BasePage {

    protected Logger logger = LogManager.getLogger(MainPage.class.getName());
    private String headerRight = "//div[@class='header2-menu__item" +
            " header2-menu__item_small" +
            " header2-menu__item_dropdown" +
            " header2-menu__item_dropdown_no-border']";

    private String myProfile = "//a[@href='/lk/biography/personal/']";

    public MainPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }


    public AboutMePage beLoggedIn() {

        actions.moveToElement(waitToClickableButton(headerRight)).perform();
        logger.info("Открыли меню профиля");

        waitToVisibleElement(myProfile).click();
        logger.info("Нажали на кнопку \"Мой профиль\"");

        return new AboutMePage(driver, actions);
    }

}

package otus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import otus.webDriverFactory.WebDriverFactory;


public class BaseTest {

    protected WebDriver driver;
    protected Actions actions;

    //Создает WebElement c явным ожиданием на видимость элемента в DOM дереве
    protected WebElement waitToVisibleElement(String xpath) {
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }

    @BeforeEach
    protected void startUp() {
        String webDriverName = System.getProperty("wd").toLowerCase();
        String options = System.getProperty("options");
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        if(options==null){
            driver = webDriverFactory.create(webDriverName);
        }else {
            driver = webDriverFactory.create(webDriverName,options);
        }
        actions = new Actions(driver);
    }

    @AfterEach
    protected void end() {
        if (driver != null) {
            driver.quit();
        }
    }
}



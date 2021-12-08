package otus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import otus.pages.AboutMePage;
import otus.pages.LoginPage;


public class OtusTest extends BaseTest {

    protected Logger logger = LogManager.getLogger(OtusTest.class.getName());

    @Test
    public void writeAboutMeTest() {

        LoginPage loginPage = new LoginPage(driver, actions);
        loginPage.signUp().beLoggedIn().writeAboutMeAndAssert();

        driver.quit();

        startUp();

        LoginPage loginPage2 = new LoginPage(driver, actions);

        loginPage2.signUp().beLoggedIn();

        AboutMePage aboutMePage = new AboutMePage(driver, actions);
        Assertions.assertEquals("Тест", aboutMePage.name.getAttribute("value"), "Имя не совпадает!");
        Assertions.assertEquals("Test", aboutMePage.nameEng.getAttribute("value"), "Имя на латинице не совпадает!");
        Assertions.assertEquals("Тестович", aboutMePage.surname.getAttribute("value"), "Фамилия не совпадает!");
        Assertions.assertEquals("Test", aboutMePage.blogName.getAttribute("value"), "blogName не совпадает!");
        Assertions.assertEquals("Testovich", aboutMePage.surnameEng.getAttribute("value"), "Фамилия на латинице не совпадает!");
        Assertions.assertEquals("11.09.1990", aboutMePage.dateOfBirth.getAttribute("value"), "Дата рождения не совпадает!");
        Assertions.assertEquals("Россия", aboutMePage.country.getText(), "Страна не совпадает!");
        Assertions.assertEquals("Санкт-Петербург", aboutMePage.city.getText(), "Город не совпадает!");
        Assertions.assertTrue(aboutMePage.readyToMovingSecond.isEnabled(), "Готовность к переезду- не нажато да");
        Assertions.assertTrue(aboutMePage.workFormatSelect, "Формат работы - полный день, не включена");
        Assertions.assertTrue(aboutMePage.flexibleScheduleSelect, "Формат работы - гибкий график, не включена");
        Assertions.assertTrue(aboutMePage.remotelySelect, "Формат работы - удаленно, не включена");
        Assertions.assertEquals("https://vk.com/id1", aboutMePage.communicationMethodTextFirst.getAttribute("value"), "Контакт ВК не совпадает!");
        Assertions.assertEquals("whatsappContact", aboutMePage.communicationMethodTextSecond.getAttribute("value"), "Контакт WhatsApp не совпадает!");
        Assertions.assertTrue(aboutMePage.genderM.isSelected(), "Пол мужской не выбран!");
        Assertions.assertEquals("Otus", aboutMePage.company.getAttribute("value"), "Компания не совпадает!");
        Assertions.assertEquals("qa engineer", aboutMePage.position.getAttribute("value"), "Должность не совпадает!");
        Assertions.assertTrue(waitToVisibleElement(aboutMePage.phpSelectNew).isSelected(), "Опыт разработки- PHP, не выбран!");
        Assertions.assertTrue(waitToVisibleElement(aboutMePage.expLevelSelectNew).isSelected(), "Опыт разработки- 1 год, не выбран!");
        logger.info("Все Assert'ы совпали ");

    }
}

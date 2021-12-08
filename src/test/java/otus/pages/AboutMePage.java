package otus.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AboutMePage extends BasePage {

    public AboutMePage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }

    protected Logger logger = LogManager.getLogger(AboutMePage.class.getName());
    public WebElement name = driver.findElement(By.xpath("//input[@name='fname']"));
    public WebElement nameEng = waitToVisibleElement("//input[@name='fname_latin']");
    public WebElement surname = waitToVisibleElement("//input[@name='lname']");
    public WebElement surnameEng = waitToVisibleElement("//input[@name='lname_latin']");
    public WebElement blogName = waitToVisibleElement("//input[@name='blog_name']");
    public WebElement dateOfBirth = waitToVisibleElement("//input[@name='date_of_birth']");
    public WebElement country = waitToVisibleElement("//div[@class='select" +
            " lk-cv-block__input " +
            "lk-cv-block__input_full " +
            "js-lk-cv-dependent-master" +
            " js-lk-cv-custom-select']/*/*[2]");
    public WebElement city = waitToClickableButton("//div[@class='select" +
            " lk-cv-block__input" +
            " lk-cv-block__input_full " +
            "js-lk-cv-dependent-slave-city" +
            " js-lk-cv-custom-select']/*[1]/*[2]");
    public WebElement readyToMovingSecond = waitToVisibleElement("//label[@class='radio" +
            " radio_light4" +
            " radio_size-sm" +
            " radio_vertical-center" +
            " lk-cv-block__radio'][2]");
    public WebElement workFormatHide = driver.findElement(By.xpath("//input[@title='Полный день']"));
    public boolean workFormatSelect = workFormatHide.isSelected();
    public WebElement flexibleScheduleHide = driver.findElement(By.xpath("//input[@title='Гибкий график']"));
    public boolean flexibleScheduleSelect = flexibleScheduleHide.isSelected();
    public WebElement remotelyHide = driver.findElement(By.xpath("//input[@title='Удаленно']"));
    public boolean remotelySelect = remotelyHide.isSelected();
    public WebElement communicationMethodTextFirst = driver.findElement(By.xpath("//input[@id='id_contact-0-value']"));
    public WebElement communicationMethodTextSecond = driver.findElement(By.xpath("//input[@id='id_contact-1-value']"));
    public WebElement genderM = waitToClickableButton("//option[@value='m']");
    public WebElement company = waitToVisibleElement("//input[@name='company']");
    public WebElement position = waitToVisibleElement("//input[@name='work']");
    public String phpSelect = "//select[@name='experience-1-experience']/*[11]";
    public String phpSelectNew = "//select[@name='experience-0-experience']/*[11]";
    public String expLevelSelect = "//select[@name='experience-1-level']/*[2]";
    public String expLevelSelectNew = "//select[@name='experience-0-level']/*[2]";


    public void writeAboutMeAndAssert() {

        name.clear();
        name.sendKeys("Тест");
        logger.info("Очистили меню \"Имя\" и ввели значение заново");

        nameEng.clear();
        nameEng.sendKeys("Test");
        logger.info("Очистили меню \"Имя на латинице\" и ввели значение заново");

        surname.clear();
        surname.sendKeys("Тестович");
        logger.info("Очистили меню \"Фамилия\" и ввели значение заново");

        surnameEng.clear();
        surnameEng.sendKeys("Testovich");
        logger.info("Очистили меню \"Фамилия на латинице\" и ввели значение заново");

        blogName.clear();
        blogName.sendKeys("Test");
        logger.info("Очистили меню \"Имя в блоге\" и ввели значение заново");

        dateOfBirth.clear();
        dateOfBirth.sendKeys("11.09.1990");
        logger.info("Очистили меню \"Дата рождения\" и ввели значение заново");

        country.click();
        logger.info("Нажали на кнопку \"Страна\" ");

        WebElement countryButton = waitToClickableButton("//button[@title='Россия']");
        countryButton.click();
        logger.info("Выбрали страну");

        driver.manage().window().maximize();

        actions.moveToElement(city).click().perform();
        logger.info("Нажали на кнопку \"Город\"");

        WebElement cityButton = waitToClickableButton("//div[@class='lk-cv-block__select-options js-custom-select-options-container']/*/*[3]");
        actions.moveToElement(cityButton).click().perform();
        logger.info("Выбрали город");

        WebElement engLevel = waitToVisibleElement("//div[@class='select" +
                " lk-cv-block__input" +
                " lk-cv-block__input_full" +
                " js-lk-cv-custom-select']");
        engLevel.click();
        logger.info("Нажали на кнопку \"Уровень английского\"");

        WebElement engLevelButton = waitToClickableButton("//button[@title='Элементарный уровень (Elementary)']");
        engLevelButton.click();
        logger.info("Выбрали уровень английского");

        WebElement readyToMovingFirst = waitToVisibleElement("//label[@class='radio" +
                " radio_light4" +
                " radio_size-sm" +
                " radio_vertical-center" +
                " lk-cv-block__radio'][1]");
        readyToMovingFirst.click();
        logger.info("Нажали на кнопку \"Готовность к переезду - нет\"");

        readyToMovingSecond.click();
        logger.info("Нажали на кнопку \"Готовность к переезду - да\"");

        WebElement workFormat = waitToVisibleElement("//input[@title='Полный день']/..");
        movingTheCheckboxToThePressedPosition(workFormatSelect, workFormat);
        logger.info("Выключили и включили кнопку \"Формат работы - полный день\"");

        WebElement FlexibleSchedule = waitToVisibleElement("//input[@title='Гибкий график']/..");
        movingTheCheckboxToThePressedPosition(flexibleScheduleSelect, FlexibleSchedule);
        logger.info("Выключили и включили кнопку \"Формат работы - гибкий график\"");

        WebElement remotely = waitToVisibleElement("//input[@title='Удаленно']/..");
        movingTheCheckboxToThePressedPosition(remotelySelect, remotely);
        logger.info("Выключили и включили кнопку \"Формат работы - удаленно\"");

        List<WebElement> communicationMethod = driver.findElements(By.xpath("//div[@class='container__col container__col_12 container__col_middle']"));
        WebElement communicationMethodButton = waitToVisibleElement("//button[@class='lk-cv-block__action " +
                "lk-cv-block__action_md-no-spacing js-formset-add" +
                " js-lk-cv-custom-select-add']");

        if (communicationMethod.size() < 2) {   //Если полей "Способ связи" меньше двух, то добавляет еще одно
            communicationMethodButton.click();
        }

        List<WebElement> communicationMethodInputs = driver.findElements(By.xpath("//div[@class='input " +
                "input_full" +
                " lk-cv-block__input " +
                "input_straight-bottom-right" +
                " input_straight-top-right" +
                " input_no-border-right " +
                "lk-cv-block__input_fake" +
                " lk-cv-block__input_select-fake" +
                " js-custom-select-presentation']"));

        WebElement communicationMethodInputFirst = communicationMethodInputs.get(0);
        communicationMethodInputFirst.click();
        logger.info("Нажали на первую кнопку \"Способ связи\"");

        List<WebElement> vkButton = driver.findElements(By.xpath("//button[@title='VK']"));
        WebElement vkButtonFirst = vkButton.get(0);
        vkButtonFirst.click();
        logger.info("Выбрали ВК в первой кнопке \"Способ связи\"");

        communicationMethodTextFirst.clear();
        communicationMethodTextFirst.sendKeys("https://vk.com/id1");
        logger.info("Очистили первое поле ввода \"Способ связи\" и заполнили данные ");

        WebElement communicationMethodInputSecond = communicationMethodInputs.get(1);
        communicationMethodInputSecond.click();
        List<WebElement> whatsappButton = driver.findElements(By.xpath("//button[@title='WhatsApp']"));
        WebElement whatsappButtonSecond = whatsappButton.get(1);
        whatsappButtonSecond.click();
        logger.info("Выбрали whatsapp во второй кнопке \"Способ связи\"");

        communicationMethodTextSecond.clear();
        communicationMethodTextSecond.sendKeys("whatsappContact");
        logger.info("Очистили второе поле ввода \"Способ связи\" и заполнили данные ");

        WebElement gender = waitToClickableButton("//select[@name='gender']");
        gender.click();
        logger.info("Нажали на кнопку \"Пол\"");

        genderM.click();
        logger.info("Выбрали мужской пол");

        company.clear();
        company.sendKeys("Otus");
        logger.info("Очистили поле ввода \"Компания\" и заполнили данные ");

        position.clear();
        position.sendKeys("qa engineer");
        logger.info("Очистили поле ввода \"Должность\" и заполнили данные ");

        WebElement developmentAdd = waitToClickableButton("//a[@title='Добавить']");
        developmentAdd.click();
        logger.info("Добавили поле \"Опыт разработки\" ");

        List<WebElement> experienceRow = driver.findElements(By.xpath("//div[@class='experience-row js-formset-row']"));

        WebElement expSelect = waitToClickableButton("//select[@name='experience-1-experience']");
        expSelect.click();

        waitToVisibleElement(phpSelect).click();
        logger.info("Выбрали PHP в \"Опыт разработки\" ");

        WebElement expLevel = waitToClickableButton("//select[@name='experience-1-level']");
        expLevel.click();

        waitToClickableButton(expLevelSelect).click();
        logger.info("Выбрали 1 год в \"Опыт разработки\" ");

        if (experienceRow.size() > 1) {                        // Удаляет первую строку "Опыт разработки"
            List<WebElement> deleteExpRow = driver.findElements(By.xpath("//div[@class='experience-row__remove ic-close js-formset-delete']"));
            WebElement deleteExpRowSecond = deleteExpRow.get(0);
            deleteExpRowSecond.click();
        }

        WebElement saveAndContinue = waitToClickableButton("//button[@title='Сохранить и продолжить']");
        saveAndContinue.click();
        logger.info("Сохранили ");
    }

}

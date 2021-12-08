# otus.dz7

ДЗ 7

Цель:
В результате выполнения дз вы реализуете автоматический тест, используя Java + Selenium

Создайте класс WebDriverFactory со статическим методом create();

Метод create() принимает обязательный параметр webDriverName и необязтельный параметр options, а возвращает соответствующий имени вебдрайвер с заданными (если были) options

Примеры использования
WebDriver wd = WebDriverFactory.createNewDriver("chrome"); 
или 
FirefoxOptions options = new FirefoxOptions();
WebDriver wd = WebDriverFactory.createNewDriver("firefox", options);

Шаги теста:

Открыть https://otus.ru
Авторизоваться на сайте
Войти в личный кабинет
В разделе "О себе" заполнить все поля "Личные данные" и добавить не менее двух контактов
Нажать сохранить
Открыть https://otus.ru в "чистом браузере"
Авторизоваться на сайте
Войти в личный кабинет
Проверить, что в разделе "О себе" отображаются указанные ранее данные

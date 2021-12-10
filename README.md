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

  1.Открыть https://otus.ru
  2.Авторизоваться на сайте
  3.Войти в личный кабинет
  4.В разделе "О себе" заполнить все поля "Личные данные" и добавить не менее двух контактов
  5.Нажать сохранить
  6.Открыть https://otus.ru в "чистом браузере"
  7.Авторизоваться на сайте
  8.Войти в личный кабинет
  9.Проверить, что в разделе "О себе" отображаются указанные ранее данные

Запуск:

  gradle clean test -Dlogin="login" -Dpassword="Dpassword" -Dwd="browser" -Doptions="option"
  gradle clean test -Dlogin="login" -Dpassword="Dpassword" -Dwd="browser" 

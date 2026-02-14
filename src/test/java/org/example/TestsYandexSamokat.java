package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pageobjects.MethodsImportantQuestions;
import org.example.pageobjects.MethodsOrderingAScooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.example.pageobjects.MainPage;
import org.example.pageobjects.OrderPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.time.Duration;

@RunWith(Parameterized.class)
public class TestsYandexSamokat {
    private final String stationName;//Моя станция
    private final String myComment;//Комментарий курьеру
    private final String myName;//Мое имя
    private final String myLastName;//Моя фамилия
    private final String myAddress;//Мой адрес
    private final String myPhoneNumber;//Мой номер телефона
    private final String myDate;//Дата доставки
    private final String myPeriod;// Доступные варианты: "сутки","двое суток","трое суток","четверо суток","пятеро суток","шестеро суток","семеро суток"
    private final String myColor;//Доступные варианты: "чёрный жемчуг", "серая безысходность"

    public TestsYandexSamokat(String stationName, String myComment, String myName, String myLastName, String myAddress, String myPhoneNumber, String myDate, String myPeriod, String myColor) {
        this.stationName = stationName;
        this.myComment = myComment;
        this.myName = myName;
        this.myLastName = myLastName;
        this.myAddress = myAddress;
        this.myPhoneNumber = myPhoneNumber;
        this.myDate = myDate;
        this.myPeriod = myPeriod;
        this.myColor = myColor;
    }

    @Parameterized.Parameters
    public static Object[][] orderInformation() {
        return new Object[][] {
                {"Комсомольская", "Код от калитки: 123", "Ольга", "Скоросуева", "ул. Пушкина", "+78912345678", "11.11.2026", "сутки", "чёрный жемчуг"},
                {"Сокольники", "Если не найдете вход - позвоните", "Петр", "Первый", "Октябрьская 98, д. 4", "+71233211232", "31.12.2026", "двое суток", "серая безысходность"},
        };
    }
    WebDriver driver;
    MainPage mainPage;
    OrderPage orderPage;

    @Before
    public void startUp(){
        String browser = System.getProperty("browser", "firefox");
        if (browser.equals("chrome")){
            startBrowserChrome();
        } else if(browser.equals("firefox")){
            startBrowserFirefox();
        }
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    }
    public void startBrowserFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    public void startBrowserChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testImportantQuestions() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        // Открой страницу тестового стенда
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MethodsImportantQuestions testTheList = new MethodsImportantQuestions(driver);

        testTheList.checkTheList();
    }

    @Test
    public void testOrderingAScooter1() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        // Открой страницу тестового стенда
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MethodsOrderingAScooter testTheList = new MethodsOrderingAScooter(driver);
        //Тут вызов метода
        testTheList.clickOrder1();//Переход по верхней кнопке "Заказать"

    }

    @Test
    public void testOrderingAScooter2() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        // Открой страницу тестового стенда
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MethodsOrderingAScooter testTheList = new MethodsOrderingAScooter(driver);
        testTheList.clickOrder2();//Переход по кнопке "Заказать" в центре страницы
        testTheList.orderFormation(stationName, myDate, myPeriod, myColor, myComment, myName, myLastName, myAddress, myPhoneNumber);
    }

}
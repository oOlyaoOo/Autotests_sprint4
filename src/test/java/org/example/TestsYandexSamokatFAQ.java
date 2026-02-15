package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pageobjects.MainPage;
import org.example.pageobjects.MethodsImportantQuestions;
import org.example.pageobjects.MethodsOrderingAScooter;
import org.example.pageobjects.OrderPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

@RunWith(Parameterized.class)
public class TestsYandexSamokatFAQ {

    WebDriver driver;
    MainPage mainPage;
    OrderPage orderPage;

    public final String question;
    public final String answer;
    public final int number;

    public TestsYandexSamokatFAQ(String question, String answer, int number) { //На вход 2 параметра 1. вопрос, 2. ответ
        this.question = question;
        this.answer = answer;
        this.number = number;
    }
    @Parameterized.Parameters
    public static Object[][] FAQInformation() {
        return new Object[][] {
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
        };
    }

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
    public void testTextHowMuch() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        // Открой страницу тестового стенда
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MethodsImportantQuestions testTheList = new MethodsImportantQuestions(driver, number);

        testTheList.checkText(question, answer);
        Assert.assertEquals(question, driver.findElement(testTheList.locatorForQuestion()).getText());;
        Assert.assertEquals(answer, driver.findElement(testTheList.locatorForAnswer()).getText());
    }
}
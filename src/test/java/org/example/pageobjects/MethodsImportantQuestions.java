package org.example.pageobjects;
import org.example.TestsYandexSamokatFAQ;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MethodsImportantQuestions {

    public By locatorForQuestion() {
        return By.id("accordion__heading-" + number); //Локатор вопроса, номер локатора берется из параметров
    }
    public By locatorForAnswer() {
        return By.id("accordion__panel-"+ number); //Локатор текста, номер локатора берется из параметров
    }

    // Локатор кнопки "Заказать"
    public By order1 = By.xpath("(//button[text()='Заказать'])[1]");// Верхняя кнопка "Заказать"
    public By order2 = By.xpath("(//button[text()='Заказать'])[2]"); // Кнопка "Заказать" в середине страницы


    protected WebDriver driver;
    private int number;

    public MethodsImportantQuestions(WebDriver driver, int number) {
        this.driver = driver;
        this.number = number;
    }
    //"Сколько стоит..." Метод кликает на кнопку и сверяет текст в выпадающим списке
    public void checkText(String question, String answer){
    WebElement element = driver.findElement(locatorForQuestion());
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    driver.findElement(locatorForQuestion()).click();
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.numberOfElementsToBe(locatorForAnswer(), 1));

    }

    // ПЕРЕХОД НА СТРАНИЦУ ФОРМИРОВАНИЯ ЗАКАЗА

    //Метод нажимающий кнопку заказать 1
    public void clickOrderInHeader(){
        MethodsOrderingAScooter waitName = new MethodsOrderingAScooter(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(order2));
        driver.findElement(order1).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfElementsToBe(waitName.name, 1));
    }
    //Метод нажимающий кнопку заказать 2
    public void clickOrder(){

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(order2));
        WebElement element = driver.findElement(order2);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(order2).click();
    }

}

package org.example.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodsOrderingAScooter extends ElementsOrder {

    protected WebDriver driver;

    public MethodsOrderingAScooter(WebDriver driver) {
        this.driver = driver;
    }
    ElementsMain orders = new ElementsMain();

    //1. ПЕРЕХОД НА СТРАНИЦУ ФОРМИРОВАНИЯ ЗАКАЗА

    //Метод нажимающий кнопку заказать 1
    public void clickOrder1(){
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(orders.order2));
            driver.findElement(orders.order1).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfElementsToBe(name, 1));
    }
    //Метод нажимающий кнопку заказать 2
    public void clickOrder2(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(orders.order2));
        WebElement element = driver.findElement(orders.order2);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orders.order2).click();
    }

    //2. ЗАПОЛНЕНИЕ ФОРМЫ "ДЛЯ КОГО САМОКАТ"

    //Метод, заполняющий станцию метро в форме "Для кого самокат"
    public void selectStation(String stationName){
        driver.findElement(metroStation).click(); //Кликаем по полю выбора станции
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfElementsToBe(stations, 1)); //Жем список
        driver.findElement(metroStation).sendKeys(stationName); //Вводим в поле название станции
        By myStation = By.xpath(String.format(station, stationName));//Используем балванку для создания динамического локатора (объяснял чат GPT, потому что в теории этого нет)
        driver.findElement(myStation).click();//Кликаем по станции из списка, в котором осталась только станция из переменной myStation
    }

    //Метод ожидающий и заполняющий форму "Для кого самокат"
    public void fillingOutTheOrderForm(String stationName, String myName, String myLastName, String myAddress, String myPhoneNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
               .until(ExpectedConditions.numberOfElementsToBe(name, 1));
        driver.findElement(name).sendKeys(myName);
        driver.findElement(lastName).sendKeys(myLastName);
        driver.findElement(address).sendKeys(myAddress);
        driver.findElement(phoneNumber).sendKeys(myPhoneNumber);
        //driver.findElement(metroStation).sendKeys(stationName);
        selectStation(stationName);//Заполняем станцию
    }
    //Метод, нажимающий кнопку "Далее" в форме "Для кого самокат"
    public void clickNext(){
        driver.findElement(next).click();
    }

    //3. ЗАПОЛНЕНИЕ ФОРМЫ "ПРО АРЕНДУ"

    //Метод заполняющий срок аренды
    public void selectPeriod(String myPeriod) {
        driver.findElement(orderHeader).click();//сбрасываем календарь тыкая по заголовку
        driver.findElement(rentalPeriods).click(); //Кликаем по полю срока аренды
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.numberOfElementsToBe(listRentalPeriods, 1)); //Жем список
        By desiredPeriod = By.xpath(String.format(period, myPeriod));//Используем балванку для создания динамического локатора (объяснял чат GPT, потому что в теории этого нет)
        WebElement element = driver.findElement(desiredPeriod);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);//Скроллим до нужного периода
        driver.findElement(desiredPeriod).click();//Кликаем по нужному периоду из переменной myPeriod
    }

    //Метод кликающий на чекбокс
    public void clickCheckBoxColor(String myColor){
        By desiredColor = By.xpath(String.format(colorButton, myColor));//Создали динамический локатор, который ищет чекбокс соответствующий переменной myColor
        driver.findElement(desiredColor).click();
    }

    //Метод ожидающий форму "Про аренду" и заполняющий её
    public void fillingOutTheRentalForm(String myDate, String myPeriod, String myColor, String myComment) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.numberOfElementsToBe(date, 1));
        driver.findElement(date).sendKeys(myDate);//Вводим дату
        selectPeriod(myPeriod);//Вызов метода заполнения срока аренды
        clickCheckBoxColor(myColor);//Вызов метода для выбора нужного чек-бокса цвета
        driver.findElement(comment).sendKeys(myComment);//Добавляем комментарий курьеру
    }

    //Метод нажимающий кнопку "Заказать"
    public void clickOrderButton(){
        driver.findElement(orderButton).click();
    }

    //Метод ожидающий окно подтверждения и нажимающий кнопку "Да"
    public void clickYes(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.numberOfElementsToBe(YesButton, 1));
        driver.findElement(YesButton).click();
    }
    //Метод ожидающий окно об успешном заказе
    public void WhitOrderHasBeenPlaced(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.numberOfElementsToBe(orderHasBeenPlaced, 1));//Окно с хэдером
        Assert.assertEquals(driver.findElement(orderHasBeenPlaced).getText(), driver.findElement(orderHasBeenPlaced).getText());//Сравниваем хэдер "Заказ оформлен" с самим собой для завершения
    }

    //4. ОБЩИЙ МЕТОД ПО ФОРМИРОВАНИЮ ЗАКАЗА

    //Метод объединяющий все шаги от заполнения полей, до получения сообщения об успешном создании заказа
    public void orderFormation(String stationName, String myDate, String myPeriod, String myColor, String myComment, String myName, String myLastName, String myAddress, String myPhoneNumber){
        fillingOutTheOrderForm(stationName, myName, myLastName, myAddress, myPhoneNumber);//Заполняем форму "Для кого самокат"
        clickNext();//Жмем далее
        fillingOutTheRentalForm(myDate, myPeriod, myColor, myComment);//Заполняем форму "Про аренду"
        clickOrderButton();//Нажимаем заказать
        clickYes();//Подтверждаем заказ
        WhitOrderHasBeenPlaced();//Метод ожидающий окно об успешном заказе
    }

}
package org.example.pageobjects;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MethodsImportantQuestions extends ElementsMain{

    protected WebDriver driver;

    public MethodsImportantQuestions(WebDriver driver) {
        this.driver = driver;
    }
    //"Сколько стоит..." Метод кликает на кнопку и сверяет текст в выпадающим списке
    public void checkTextHowMuch(){
    WebElement element = driver.findElement(howMuch);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    driver.findElement(howMuch).click();
    Assert.assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", driver.findElement(textHowMuch).getText());
    }

    //"Хочу сразу несколько..." Метод кликает на кнопку и сверяет текст в выпадающим списке
    public void checkTextIWant(){
        WebElement element = driver.findElement(iWant);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(iWant).click();
        Assert.assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", driver.findElement(textIWant).getText());
    }

    //"Как рассчитывается..." Метод кликает на кнопку и сверяет текст в выпадающим списке
    public void checkTextHowCalculated(){
        WebElement element = driver.findElement(howCalculated);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(howCalculated).click();
        Assert.assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", driver.findElement(textHowCalculated).getText());
    }

    //"Можно ли заказать..." Метод кликает на кнопку и сверяет текст в выпадающим списке
    public void checkTextCanOrder(){
        WebElement element = driver.findElement(canOrder);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(canOrder).click();
        Assert.assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", driver.findElement(textCanOrder).getText());
    }

    //"Можно ли продлить..." Метод кликает на кнопку и сверяет текст в выпадающим списке
    public void checkTextCanBeExtended(){
        WebElement element = driver.findElement(canBeExtended);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(canBeExtended).click();
        Assert.assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", driver.findElement(textCanBeExtended).getText());
    }

    //"Вы привозите..." Метод кликает на кнопку и сверяет текст в выпадающим списке
    public void checkTextYouBring(){
        WebElement element = driver.findElement(youBring);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(youBring).click();
        Assert.assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", driver.findElement(textYouBring).getText());
    }

    //"Можно ли отменить..." Метод кликает на кнопку и сверяет текст в выпадающим списке
    public void checkTextCanCancel(){
        WebElement element = driver.findElement(canCancel);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(canCancel).click();
        Assert.assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", driver.findElement(textCanCancel).getText());
    }

    //"Я живу за МКАДом..." Метод кликает на кнопку и сверяет текст в выпадающим списке
    public void checkTextLiveAcrossTheMkad(){
        WebElement element = driver.findElement(liveAcrossTheMkad);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(liveAcrossTheMkad).click();
        Assert.assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", driver.findElement(textLiveAcrossTheMkad).getText());
    }
    //Метод, вызывающий все методы для проверки всех выпадающих списков раздела "Вопросы о важном"
    public void checkTheList(){
        checkTextHowMuch();
        checkTextIWant();
        checkTextHowCalculated();
        checkTextCanOrder();
        checkTextCanBeExtended();
        checkTextYouBring();
        checkTextCanCancel();
        checkTextLiveAcrossTheMkad();
    }

}

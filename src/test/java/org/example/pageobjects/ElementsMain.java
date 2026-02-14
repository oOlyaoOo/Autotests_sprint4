package org.example.pageobjects;

import org.openqa.selenium.By;

public class ElementsMain {

   // Локаторы кнопок выпадающего списка в разделе "Вопросы о важном"
    public By howMuch = By.id("accordion__heading-0"); //Первая кнопка в списке "Сколько это стоит?..."
    public By iWant = By.id("accordion__heading-1"); //Третья кнопка в списке "Хочу сразу несколько..."
    public By howCalculated = By.id("accordion__heading-2"); //Четвертая кнопка в списке "Как рассчитывается..."
    public By canOrder = By.id("accordion__heading-3"); //Пятая кнопка в списке "Можно ли заказать..."
    public By canBeExtended = By.id("accordion__heading-4"); //Шестая кнопка в списке "Можно ли продлить..."
    public By youBring = By.id("accordion__heading-5"); //Седьмая кнопка в списке "Вы привозите..."
    public By canCancel = By.id("accordion__heading-6"); //Восьмая кнопка в списке "Можно ли отменить..."
    public By liveAcrossTheMkad = By.id("accordion__heading-7"); //Восьмая кнопка в списке "Я жизу за МКАДОМ..."

    // Локатор кнопки "Заказать"
    public By order1 = By.xpath("(//button[text()='Заказать'])[1]");// Верхняя кнопка "Заказать"
    public By order2 = By.xpath("(//button[text()='Заказать'])[2]"); // Кнопка "Заказать" в середине страницы

    // Локаторы выпадающих текстов
    public By textHowMuch = By.id("accordion__panel-0"); //Первая кнопка в списке "Сколько это стоит?..."
    public By textIWant = By.id("accordion__panel-1"); //Третья кнопка в списке "Хочу сразу несколько..."
    public By textHowCalculated = By.id("accordion__panel-2"); //Четвертая кнопка в списке "Как рассчитывается..."
    public By textCanOrder = By.id("accordion__panel-3"); //Пятая кнопка в списке "Можно ли заказать..."
    public By textCanBeExtended = By.id("accordion__panel-4"); //Шестая кнопка в списке "Можно ли продлить..."
    public By textYouBring = By.id("accordion__panel-5"); //Седьмая кнопка в списке "Вы привозите..."
    public By textCanCancel = By.id("accordion__panel-6"); // Восьмая кнопка в списке "Можно ли отменить..."
    public By textLiveAcrossTheMkad = By.id("accordion__panel-7"); //Восьмая кнопка в списке "Я жизу за МКАДОМ..."
}

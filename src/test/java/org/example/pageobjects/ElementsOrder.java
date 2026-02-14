package org.example.pageobjects;

import org.openqa.selenium.By;

public class ElementsOrder {

    //Локаторы для заполнения в форме "Для кого самокат"

    public By name = By.cssSelector("[placeholder='* Имя']"); //Поле Имя
    public By lastName = By.cssSelector("[placeholder='* Фамилия']"); //Поле Фамилия
    public By address = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']"); //Поле Адрес
    public By metroStation = By.cssSelector("[placeholder='* Станция метро']"); //Поле Станция метро
    public By phoneNumber = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']"); //Поле Номер телефона

    //Список станций. Динамический элемент, появляется только после клика по полю "Станция метро"
    public By stations = By.className("select-search__select");

    //Болванка для использования переменной "Станция метро" в методе заполняющий станцию (объяснял чат GPT, потому что в теории этого нет)
    public String station = "//button[.//div[text()='%s']]";

    //Кнопка "Далее"
    public By next = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");


    //Локаторы для заполнени в формы "Про аренду"

    public By date = By.cssSelector("[placeholder='* Когда привезти самокат']");//Поле выбора даты
    public By rentalPeriods = By.className("Dropdown-placeholder");//Поле срока аренды
    public By listRentalPeriods = By.className("Dropdown-menu");//Список вариантов срока аренды
    public String period = "//div[text()='%s']";//Болванка для локатора срока аренды

    //public By colorBlack = By.id("black");//Чекбокс "черный жемчуг"
    //public By colorGrey = By.id("grey");//Чекбокс "серая безысходность"
    public String colorButton = "//label[text()='%s']";//Болванка для локатора цвета

    public By comment = By.cssSelector("[placeholder='Комментарий для курьера']");//Комментарий курьеру

    public By orderButton = By.xpath("//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']");//Кнопка Заказать

    public By YesButton = By.xpath("//button[contains(@class,'Button_Middle') and text()='Да']");//Кнопка Да в окне подтверждения

    public By orderHasBeenPlaced = By.xpath("//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']");//Заголовок окна подтверждающего оформление заказа

    public By orderHeader = By.xpath(".//div[@class = 'Order_Header__BZXOb' and text() = 'Про аренду']");//Заголовок формы для клика, чтобы сбросить календарь
}

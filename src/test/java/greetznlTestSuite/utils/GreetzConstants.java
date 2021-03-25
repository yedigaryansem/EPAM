package greetznlTestSuite.utils;

public class GreetzConstants {
    public static String loginXPath = "https://www.greetz.nl/auth/login";
    public static String linkPage = "https://www.greetz.nl/ballonnen/denken-aan";
    public static String addFavElemXPath = ".//*[@class='clearfix']//div[1]//div[@class='b-favourite']";
    public static String expectedGiftPriceElemXPath = ".//*[@class='clearfix']//div[1]//span[@class=\"price-normal\"]";
    public static String expectedGiftNameElemXPath = ".//*[@class='clearfix']//div[1]//div[@class=\"b-products-grid__item-title\"]";
    public static String buttonXPath = ".//*[@class='page-header__navigation']//a[4]";
    public static String FavButtonSccSelector = "li:nth-child(3) > div > span > a > span.b-list--item-subject";
    public static String itemInFavoritesID = "gift-medium";
    public static String actualGiftPriceElemClassName = "price-normal";
    public static String actualGiftNameElemCssSelector = "div.page-detail__sidebar > form > h1";

    public static String email = "test00189@gmail.com";
    public static String pass = "alwaystest";
}

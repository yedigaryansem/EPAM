package SixPMComTestSuite.utils;

public class SixPmConstants {

    public static String homePage = "https://www.6pm.com/";

    public static String accessoriesXPath = ".//*[@class='eb-z']//ul//a[@href='/c/accessories']";
    public static String aviatorsButtonXPath = "//a[text()='Aviators']";
    public static String listOfAllItemsXPath = ".//div[@class='js-z']//article[@class=\"py-z ns-z\"]";
    public static String addToBagElemXPath = ".//button[@class=\"MR-z\"]";
    public static String itemNameElemActual = ".//div[@class='js-z']//article[@class=\"py-z ns-z\"]//dd[@class=\"Zv-z\"]";
    public static String itemInfoElemActual = ".//div[@class='js-z']//article[@class=\"py-z ns-z\"]//dd[@class=\"_v-z\"]";
    public static String itemPriceElemActual = ".//div[@class='js-z']//article[@class=\"py-z ns-z\"]//span[@class=\"Ty-z\"]";
    public static String viewBugButtonElemXPath = ".//a[@class=\"sz-z\"]";
    public static String itemNameElemExpected = ".//div[@class=\"Wk-z\"]//span[1]";
    public static String itemInfoElemExpected = ".//span[@class='Xk-z']";
    public static String itemPriceElemExpected = ".//em[@class=\"yh-z Bh-z\"]";
    public static String itemQuantityDropDownXpath = ".//div[@class=\"Tk-z\"]//select";
    public static String removeButtonFromDropDownXpath = ".//option[@value=\"0\"]";
}

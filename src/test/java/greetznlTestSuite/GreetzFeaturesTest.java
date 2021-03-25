package greetznlTestSuite;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static greetznlTestSuite.utils.GreetzConstants.*;

public class GreetzFeaturesTest {
    private WebDriver driver;

    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @BeforeMethod
    public void login() throws InterruptedException {
        driver.get(loginXPath);
        driver.manage().window().maximize();
        Thread.sleep(3000);

        WebElement loginFormElem = driver.findElement(By.id("loginForm"));

        loginFormElem.findElement(By.name("email")).sendKeys(email);
        loginFormElem.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.id("login-cta")).click();
        Thread.sleep(3000);
    }

    @AfterMethod
    public  void closeDriver(){
        driver.close();
    }

    @Test
    public void addFavoriteTest() throws InterruptedException {
        driver.get(linkPage);
        Thread.sleep(3000);

        WebElement addFavElem = driver.findElement(By.xpath(addFavElemXPath));
        addFavElem.click();

        WebElement giftPriceElem = driver.findElement(By.xpath(expectedGiftPriceElemXPath));
        String expectedPriceResult = "€ " + giftPriceElem.getText();
        WebElement giftNameElem = driver.findElement(By.xpath(expectedGiftNameElemXPath));
        String expectedNameResult = giftNameElem.getText();
        Thread.sleep(3000);

        WebElement myGreetzButton = driver.findElement(By.xpath(buttonXPath));
        myGreetzButton.click();
        Thread.sleep(3000);

        WebElement favoritesButton = driver.findElement(By.cssSelector(FavButtonSccSelector));
        favoritesButton.click();
        Thread.sleep(3000);

        WebElement itemInFavorites = driver.findElement(By.className(itemInFavoritesID));
        itemInFavorites.click();
        Thread.sleep(3000);

        giftPriceElem = driver.findElement(By.className(actualGiftPriceElemClassName));
        String actualPriceResult = giftPriceElem.getText();
        giftNameElem = driver.findElement(By.cssSelector(actualGiftNameElemCssSelector));
        String actualNameResult = giftNameElem.getText();

        Assert.assertEquals(actualNameResult,expectedNameResult);
        Assert.assertEquals(actualPriceResult,expectedPriceResult);
    }

}

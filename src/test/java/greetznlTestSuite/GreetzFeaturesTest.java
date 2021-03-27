package greetznlTestSuite;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

import static greetznlTestSuite.utils.GreetzConstants.*;
import static greetznlTestSuite.utils.GreetzHelperMethods.reformatStringToFloat;
import static greetznlTestSuite.utils.GreetzHelperMethods.takeFromStringOnlyFloat;

public class GreetzFeaturesTest {
    private WebDriver driver;

    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void login() throws InterruptedException {
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(loginLink);
        driver.manage().window().maximize();

        WebElement loginFormElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginForm")));

        loginFormElem.findElement(By.name("email")).sendKeys(email);
        loginFormElem.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.id("login-cta")).click();
        Thread.sleep(2000);
    }

    @AfterMethod
    public  void closeDriver(){
        driver.close();
    }

    @Test(enabled = true)
    public void addFavoriteTest(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get(linkPage);

        WebElement addFavElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addFavElemXPath)));
        addFavElem.click();

        WebElement giftPriceElem = driver.findElement(By.xpath(expectedGiftPriceElemXPath));
        String expectedPriceResult = "€ " + giftPriceElem.getText();
        WebElement giftNameElem = driver.findElement(By.xpath(expectedGiftNameElemXPath));
        String expectedNameResult = giftNameElem.getText();

        WebElement myGreetzButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonXPath)));
        myGreetzButton.click();

        WebElement favoritesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(FavButtonSccSelector)));
        favoritesButton.click();

        WebElement itemInFavorites = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(itemInFavoritesID)));
        itemInFavorites.click();

        giftPriceElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(actualGiftPriceElemClassName)));
        String actualPriceResult = giftPriceElem.getText();
        giftNameElem = driver.findElement(By.cssSelector(actualGiftNameElemCssSelector));
        String actualNameResult = giftNameElem.getText();

        Assert.assertEquals(actualNameResult,expectedNameResult);
        Assert.assertEquals(actualPriceResult,expectedPriceResult);
    }

    @Test(enabled=true)
    public void itemQuantityEqualPriceTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        int testCount = 4;
        String testCountToString = Integer.toString(testCount);

        driver.get(linkPage1);

        WebElement cartElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cartElemXPath)));
        cartElem.click();

        List<WebElement> cartPriceElem = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.className("price-normal"))));
        float expectedPrice = reformatStringToFloat(cartPriceElem.get(1).getText()) * testCount;

        WebElement itemQuantityInputElem = driver.findElement(By.name("amount"));
        itemQuantityInputElem.sendKeys(Keys.chord(Keys.CONTROL, "a"),testCountToString);

        Thread.sleep(3000);
        WebElement actualPriceElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("price-total")));
        float actualPrice = reformatStringToFloat(takeFromStringOnlyFloat(actualPriceElem.getText()));

        Assert.assertEquals(actualPrice,expectedPrice);
    }

}
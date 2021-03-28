package SixPMComTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;

import static SixPMComTestSuite.utils.SixPmConstants.*;

public class SixPMFeaturesTest {
    private WebDriver driver;

    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void setChromeDriver(){
        driver = new ChromeDriver();
    }

    @AfterMethod
    public  void closeDriver(){
        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement itemQuantityDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemQuantityDropDownXpath)));
        itemQuantityDropDown.click();
        WebElement removeButtonFromDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(removeButtonFromDropDownXpath)));
        removeButtonFromDropDown.click();

        driver.quit();
    }

    @Test
    public void addToFavTest(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        Actions action = new Actions(driver);
        Random random = new Random();

        driver.manage().window().maximize();
        driver.get(homePage);

        WebElement accessoriesElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(accessoriesXPath)));
        action.moveToElement(accessoriesElem).build().perform();

        WebElement aviatorsButtonElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(aviatorsButtonXPath)));
        aviatorsButtonElem.click();

        List <WebElement> listOfAllItems = wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(listOfAllItemsXPath),100));

        int countOfItems = listOfAllItems.size();
        int randomItemIndex = random.nextInt(countOfItems);

        List <WebElement> actItemNameElem = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(actItemsNam)));
        String actualItemName = actItemNameElem.get(randomItemIndex).getText();
        List <WebElement> actItemInfoElem = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(actItemsInfo)));
        String actualItemInfo = actItemInfoElem.get(randomItemIndex).getText();
        List <WebElement> actItemPriceElem = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(actItemsPrice)));
        String actualItemPrice = actItemPriceElem.get(randomItemIndex).getText();

        listOfAllItems.get(randomItemIndex).click();

        WebElement addToBagElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addToBagElemXPath)));
        addToBagElem.click();

        WebElement viewBugButtonElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewBugButtonElemXPath)));
        viewBugButtonElem.click();

        WebElement expItemNameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemNameElemExpected)));
        String expectedItemName = expItemNameElem.getText();
        WebElement expItemInfoElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemInfoElemExpected)));
        String expectedItemInfo = expItemInfoElem.getText();
        WebElement expItemPriceElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemPriceElemExpected)));
        String expectedItemPrice = expItemPriceElem.getText();

        Assert.assertEquals(actualItemName,expectedItemName,"The actual item name does not match with expected item name");
        Assert.assertEquals(actualItemInfo,expectedItemInfo,"The actual item info does not match with expected item info");
        Assert.assertEquals(actualItemPrice,expectedItemPrice,"The actual item price does not match with expected item price");
    }
}
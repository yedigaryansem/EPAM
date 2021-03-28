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

        List <WebElement> listOfAllItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(listOfAllItemsXPath)));

        int countOfItems = listOfAllItems.size();
        listOfAllItems.get(random.nextInt(countOfItems)).click();

        WebElement addToBagElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addToBagElemXPath)));
        addToBagElem.click();

        WebElement itemNameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemNameElemActual)));
        String actualItemName = itemNameElem.getText();
        WebElement itemInfoElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemInfoElemActual)));
        String actualItemInfo = itemInfoElem.getText();
        WebElement itemPriceElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemPriceElemActual)));
        String actualItemPrice = itemPriceElem.getText();

        WebElement viewBugButtonElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewBugButtonElemXPath)));
        viewBugButtonElem.click();

        itemNameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemNameElemExpected)));
        String expectedItemName = itemNameElem.getText();
        itemInfoElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemInfoElemExpected)));
        String expectedItemInfo = itemInfoElem.getText();
        itemPriceElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemPriceElemExpected)));
        String expectedItemPrice = itemPriceElem.getText();

        Assert.assertEquals(actualItemName,expectedItemName,"The actual item name does not match with expected item name");
        Assert.assertEquals(actualItemInfo,expectedItemInfo,"The actual item info does not match with expected item info");
        Assert.assertEquals(actualItemPrice,expectedItemPrice,"The actual item price does not match with expected item price");

        WebElement itemQuantityDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemQuantityDropDownXpath)));
        itemQuantityDropDown.click();
        WebElement removeButtonFromDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(removeButtonFromDropDownXpath)));
        removeButtonFromDropDown.click();

    }
}

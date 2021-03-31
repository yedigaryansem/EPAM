package amazonTestSuite;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.amazon.CategoryByBooksPage;
import pages.amazon.CategoryByKindleStorePage;
import pages.amazon.HomePage;

public class amazonFeaturesTest {

    private WebDriver driver;

    @AfterClass
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        
    }
    @BeforeMethod
    public void setChromeDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public  void closeDriver(){
        driver.quit();
    }
        @Test
    public void authorsNameTest(){
        String testName = "Tsugumi Ohba";
        String testCategory = "Books";

        HomePage homePage = new HomePage(driver);
        homePage.getPage();

        homePage.setCategoryForSearchByText(testCategory);
        homePage.searchBySearchingBarByText(testName);

        CategoryByBooksPage categoryByBooksPage = new CategoryByBooksPage(driver);

        List<String> names = categoryByBooksPage.getAuthorsNameFromBooks(12);
        for (String name:names){
            Assert.assertEquals(name,testName,String.format("The actual name %s does not match with the expected name",name));
        }

        categoryByBooksPage.clickOnAuthorsNamedFromBook();

        CategoryByKindleStorePage categoryByKindleStorePage = new CategoryByKindleStorePage(driver);
        String actualText = categoryByKindleStorePage.getBooksByAuthorText();
        String expectedText = String.format("Books By %s", testName);

        Assert.assertEquals(actualText,expectedText,String.format("The actual name does not match with the expected name %s",testName));

        categoryByKindleStorePage.changeBooksSortingFromLowToHigh();
        List<Float> prices = categoryByKindleStorePage.getAllBooksPrice(12);
        for (int i = 0; i < prices.size()-1; ++i) {
            Assert.assertTrue(prices.get(i)<=prices.get(i+1),"The sorting drop down is incorrect");
        }
    }

    @Test(enabled = true)
    public void deliveryToArmeniaButtonTest(){
        HomePage homePage = new HomePage(driver);
        homePage.getPage();

        String actualText = homePage.getDeliveryToArmeniaButtonText();
        String expectedText = "Deliver to Armenia";
        Assert.assertEquals(actualText, expectedText, "The Button text does not match");

    }
}

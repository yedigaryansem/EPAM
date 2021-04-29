package amazonTestSuite;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @Test(dataProvider = "DataOfAuthorsNameTest")
    public void authorsNameTest(String authorName, String category, int booksCount){

        HomePage homePage = new HomePage(driver);
        homePage.getPage();

        homePage.setCategoryForSearchByText(category);
        homePage.searchBySearchingBarByText(authorName);

        CategoryByBooksPage categoryByBooksPage = new CategoryByBooksPage(driver);
        categoryByBooksPage.getPage("s?k=Tsugumi+Ohba&i=stripbooks-intl-ship&ref=nb_sb_noss");

        List<String> names = categoryByBooksPage.getAuthorsNameFromBooks(booksCount);
        for (String name:names){
            Assert.assertEquals(name, authorName, String.format("The actual name %s does not match with the expected name", name));
        }

        categoryByBooksPage.clickOnAuthorsNamedFromBook();

        CategoryByKindleStorePage categoryByKindleStorePage = new CategoryByKindleStorePage(driver);
        categoryByKindleStorePage.getPage("Tsugumi-Ohba/e/B0035POVWA?ref=sr_ntt_srch_lnk_1&qid=1617348759&sr=1-1");
        String actualText = categoryByKindleStorePage.getBooksByAuthorText();
        String expectedText = String.format("Titles By %s", authorName);

        Assert.assertEquals(actualText,expectedText,String.format("The actual name does not match with the expected name %s", authorName));

        categoryByKindleStorePage.changeBooksSortingFromLowToHigh();
        List<Float> prices = categoryByKindleStorePage.getAllBooksPrice(booksCount);
        for (int i = 0; i < prices.size()-1; ++i) {
            Assert.assertTrue(prices.get(i)<=prices.get(i+1),"The sorting drop down is incorrect");
        }
    }

    @Test
    public void deliveryToArmeniaButtonTest(){
        HomePage homePage = new HomePage(driver);
        homePage.getPage();

        String actualText = homePage.getDeliveryToArmeniaButtonText();
        String expectedText = "Deliver to Armenia";
        Assert.assertEquals(actualText, expectedText, "The Button text does not match");

    }


    @DataProvider(name = "DataOfAuthorsNameTest")
    public static Object[][]DataProvider(){
        return new Object[][]{
            {"Tsugumi Ohba","Books",12}
        };
    }
}

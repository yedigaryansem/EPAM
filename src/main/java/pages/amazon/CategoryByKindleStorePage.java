package pages.amazon;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static HelperMethods.HelperMethods.reformatStringToFloat;
import static HelperMethods.HelperMethods.takeFromStringOnlyFloat;

public class CategoryByKindleStorePage {
    private WebDriver driver;

    private final String baseURL = "https://www.amazon.com/";

    @FindBy(id = "formatSelectorHeader")
    private WebElement booksByAuthorText;
    @FindBy(xpath = ".//span[@id=\"sortBySelectors\"]//span[@class=\"a-button-inner\"]")
    private WebElement sortingDropDownButton;
    @FindBy(xpath = ".//li[@aria-labelledby=\"dropdown1_1\"]")
    private WebElement priceLowToHighSDDButton;
    final String bookInfoString = ".//div[@class='a-fixed-right-grid-col a-col-left']";
    @FindBy(xpath = bookInfoString)
    private WebElement bookInfo;
    private By bookPrice = By.xpath(".//div//span[@class='a-size-base-plus a-color-price a-text-bold']");

    public CategoryByKindleStorePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void getPage(String envURL) {
        driver.get(baseURL + envURL);
    }

    private WebElement waitForElement(WebElement loc){

        WebDriverWait wait = new WebDriverWait(this.driver, 10);

        return wait.until(ExpectedConditions.visibilityOf(loc));
    }

    private List<WebElement> waitForElementsByCount(By loc, int count){
        WebDriverWait wait = new WebDriverWait(this.driver,10);

        return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(loc, count-1));
    }

    public String getBooksByAuthorText(){
        return waitForElement(booksByAuthorText).getText();
    }
    public void changeBooksSortingFromLowToHigh(){
        waitForElement(sortingDropDownButton).click();
        waitForElement(priceLowToHighSDDButton).click();
    }

    public List<Float> getAllBooksPrice(int count){
        List<WebElement> webElementsBookInfo = waitForElementsByCount(By.xpath(bookInfoString), count);

        List<Float> booksPrices = new ArrayList<Float>();
        for (WebElement webElementBI : webElementsBookInfo) {
            String priceText = webElementBI.findElement(bookPrice).getText();
            booksPrices.add(reformatStringToFloat(takeFromStringOnlyFloat(priceText)));
        }
        return booksPrices;
    }
}

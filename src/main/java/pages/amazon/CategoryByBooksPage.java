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

public class CategoryByBooksPage {

    WebDriver driver;

    private final String baseURL = "https://www.amazon.com/";
    final String authorsNameDirString = ".//div[@class=\"a-row a-size-base a-color-secondary\"]" +
                                       "//a[@class=\"a-size-base a-link-normal\"]";

    @FindBy(xpath = authorsNameDirString)
    private WebElement authorsNameDir;

    public CategoryByBooksPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void getPage(String envURL) {
        driver.get(baseURL + envURL);
    }


    private WebElement waitForElement(WebElement loc){
        WebDriverWait wait = new WebDriverWait(this.driver,10);

        return wait.until(ExpectedConditions.visibilityOf(loc));
    }

    public List<String> getAuthorsNameFromBooks(int countOFBooks){
        WebDriverWait wait = new WebDriverWait(this.driver,10);
        List<WebElement> namesElem = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath(authorsNameDirString),countOFBooks - 1));

        List<String> names = new ArrayList<String>();
        for (WebElement name : namesElem){
            names.add(name.getText());
        }
        return names;
    }

    public void clickOnAuthorsNamedFromBook(){
        waitForElement(authorsNameDir).click();
    }

}

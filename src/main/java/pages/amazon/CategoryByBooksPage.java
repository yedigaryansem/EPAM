package pages.amazon;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryByBooksPage {

    WebDriver driver;

    private final By authorsNameDir = By.xpath(".//div[@class=\"a-row a-size-base a-color-secondary\"]" +
                                               "//a[@class=\"a-size-base a-link-normal\"]");

    public CategoryByBooksPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement waitForElement(By loc){
        WebDriverWait wait = new WebDriverWait(this.driver,10);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
    }

    public List<WebElement> waitForElementsByCount(By loc, int count){
        WebDriverWait wait = new WebDriverWait(this.driver,10);

        return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(loc,count-1));
    }

    public List<String> getAuthorsNameFromBooks(int countOFBooks){
        List<WebElement> namesElem = waitForElementsByCount(authorsNameDir,countOFBooks);

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

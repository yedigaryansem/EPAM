package pages.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;

    private final String pageLink = "https://www.amazon.com/";

    private final By deliveryToArmeniaButton = By.id("glow-ingress-block");
    private final By navSearchBarForm = By.id("nav-search-bar-form");

    //authors page by

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void getPage() {
        driver.get(pageLink);
    }

    public String getDeliveryToArmeniaButtonText(){
        return  waitForElement(deliveryToArmeniaButton).findElement(By.id("glow-ingress-line1")).getText() + " " +
                waitForElement(deliveryToArmeniaButton).findElement(By.id("glow-ingress-line2")).getText();
    }
    public WebElement waitForElement(By loc){

        WebDriverWait wait = new WebDriverWait(this.driver,10);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
    }

    public void setCategoryForSearchByText(String option){

        WebElement categoryDropDown = waitForElement(navSearchBarForm)
                .findElement(By.className("nav-left"));
        categoryDropDown.click();

        categoryDropDown = waitForElement(By.xpath(String.format(".//option[text()='%s']", option)));
        categoryDropDown.click();
    }

    public void searchBySearchingBarByText(String content){
        WebElement searchingBar = waitForElement(navSearchBarForm)
                .findElement(By.id("twotabsearchtextbox"));
        searchingBar.sendKeys(Keys.chord(content, Keys.ENTER));
    }
}

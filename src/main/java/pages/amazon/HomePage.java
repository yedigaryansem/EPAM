package pages.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;

    private final String baseURL = "https://www.amazon.com/";

    @FindBy(id = "glow-ingress-block")
    private WebElement deliveryToArmeniaButton;
    @FindBy(id = "nav-search-bar-form")
    private WebElement navSearchBarForm;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void getPage() {
        driver.get(baseURL);
    }

    public String getDeliveryToArmeniaButtonText(){
        return  waitForElement(deliveryToArmeniaButton).findElement(By.id("glow-ingress-line1")).getText() + " " +
                waitForElement(deliveryToArmeniaButton).findElement(By.id("glow-ingress-line2")).getText();
    }
    private WebElement waitForElement(WebElement loc){

        WebDriverWait wait = new WebDriverWait(this.driver,10);

        return wait.until(ExpectedConditions.visibilityOf(loc));
    }

    public void setCategoryForSearchByText(String option){
        WebDriverWait wait = new WebDriverWait(this.driver,10);

        WebElement categoryDropDown = waitForElement(navSearchBarForm)
                .findElement(By.className("nav-left"));
        categoryDropDown.click();

        WebElement categoryElem = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(String.format(".//option[text()='%s']", option))));
        categoryElem.click();
    }

    public void searchBySearchingBarByText(String content){
        WebElement searchingBar = waitForElement(navSearchBarForm)
                .findElement(By.id("twotabsearchtextbox"));
        searchingBar.sendKeys(Keys.chord(content, Keys.ENTER));
    }
}

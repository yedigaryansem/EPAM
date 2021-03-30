package pages.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;

    private final String pageLink = "https://www.amazon.com/";

    private final By deliveryToArmeniaButton = By.id("glow-ingress-block");
    private final By navSearchBarForm = By.id("nav-search-bar-form");


    HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void setCategoryForSearchByText(String option){

        WebElement categoryDropDown = driver.findElement(navSearchBarForm)
                .findElement(By.className("nav-left"));
        categoryDropDown.click();

        categoryDropDown.findElement(By.xpath(String.format(".//option[text()='%s']", option)));
        categoryDropDown.click();
    }

    public void searchBySearchingBarByText(String content){
        WebElement searchingBar = driver.findElement(navSearchBarForm)
                .findElement(By.className("nav-fill"));
        searchingBar.sendKeys(Keys.chord(content, Keys.ENTER));
    }
}

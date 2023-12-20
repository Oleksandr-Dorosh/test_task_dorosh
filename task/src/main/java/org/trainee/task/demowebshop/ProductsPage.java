package org.trainee.task.demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.trainee.task.demowebshop.commun.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {
    @FindBy(id = "products-orderby")
    private WebElement sortByDropDown;

    @FindBy(id = "products-pagesize")
    private WebElement displayDropDown;

    @FindAll(@FindBy(xpath = "//span[@class='price actual-price']"))
    private List<WebElement> allPrices;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void selectSortByText(String sortText) {
        new Select(sortByDropDown).selectByVisibleText(sortText);
    }

    public void selectDisplayPerPage(String quantity) {
        new Select(displayDropDown).selectByVisibleText(quantity);
    }

    public void addToCartProductWithHighestPriceProduct() {
        List<WebElement> p = allPrices.stream()
                .sorted((o1, o2) ->
                        Double.valueOf(o1.getText()).compareTo(Double.valueOf(o2.getText())))
                .collect(Collectors.toList());
        p.get(p.size() - 1)
                .findElement(By.xpath("./parent::div/../div/input")).click();
    }
}

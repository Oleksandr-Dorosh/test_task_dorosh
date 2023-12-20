package org.trainee.task.demowebshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.trainee.task.demowebshop.commun.BasePage;

public class CartPage extends BasePage {
    @FindBy(xpath = "//tr[@class='cart-item-row']")
    private WebElement item;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isItemDisplayed() {
        waiter.waitForElementToBeVisible(item);
        return item.isDisplayed();
    }
}

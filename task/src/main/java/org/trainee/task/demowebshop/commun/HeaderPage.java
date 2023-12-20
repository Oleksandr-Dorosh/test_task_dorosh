package org.trainee.task.demowebshop.commun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.trainee.task.demowebshop.commun.BasePage;

public class HeaderPage extends BasePage {

    @FindBy(xpath = "//span[@class='cart-label']")
    private WebElement shoppingCart;
    public HeaderPage(WebDriver driver) {
        super(driver);
    }
    public void clickShoppingCart() {
        waiter.waitForElementToBeClickable(shoppingCart);
        shoppingCart.click();
    }
}

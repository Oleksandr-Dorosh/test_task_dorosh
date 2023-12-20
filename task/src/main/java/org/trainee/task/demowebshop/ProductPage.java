package org.trainee.task.demowebshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.trainee.task.demowebshop.commun.BasePage;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//input[@id='add-to-cart-button-74']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//input[@id='product_attribute_74_5_26_82']")
    private WebElement processorRadio;

    @FindBy(xpath = "//input[@id='product_attribute_74_6_27_85']")
    private WebElement ramRadio;
    @FindBy(xpath = "//input[@value='88']")
    private WebElement checkbox1;
    @FindBy(xpath = "//input[@value='89']")
    private WebElement checkbox2;
    @FindBy(xpath = "//input[@value='90']")
    private WebElement checkbox3;
    @FindBy(name = "removefromcart")
    private WebElement removeCheckbox;
    @FindBy(xpath = "//input[@class='button-2 update-cart-button']")
    private WebElement updateCart;


    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public void selectProcessor() {
        waiter.waitForElementToBeClickable(processorRadio);
        processorRadio.click();
    }

    public void selectRAM() {
        waiter.waitForElementToBeClickable(ramRadio);
        ramRadio.click();
    }

    public void selectAllCheckboxes() {
        waiter.waitForElementToBeClickable(checkbox1);
        checkbox1.click();
        waiter.waitForElementToBeClickable(checkbox2);
        checkbox2.click();
        waiter.waitForElementToBeClickable(checkbox3);
        checkbox3.click();
    }

    public void addProductToCart() {
        waiter.waitForElementToBeClickable(addToCartButton);
        addToCartButton.click();
    }

    public void removeCheckbox() {
        waiter.waitForElementToBeClickable(removeCheckbox);
        removeCheckbox.click();
    }

    public void updateCart() {
        waiter.waitForElementToBeClickable(updateCart);
        updateCart.click();
    }


}

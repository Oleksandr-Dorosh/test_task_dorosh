package org.trainee.task.demowebshop.buildcomputer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComputerPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@id='product_attribute_74_5_26_82']")
    private WebElement processorRadioButton;
}

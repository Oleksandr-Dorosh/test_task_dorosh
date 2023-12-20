package org.trainee.task.demowebshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.trainee.task.demowebshop.commun.BasePage;

public class HomePage extends BasePage {

    @FindBy(linkText = "Computers")
    private WebElement computersButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickComputersButton() {
        computersButton.click();
    }
}

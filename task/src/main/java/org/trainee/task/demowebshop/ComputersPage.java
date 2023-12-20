package org.trainee.task.demowebshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.trainee.task.demowebshop.commun.BasePage;

public class ComputersPage extends BasePage {
    @FindBy(linkText = "Desktops")
    private WebElement desktopsButton;

    public ComputersPage(WebDriver driver) {
        super(driver);
    }

    public void selectDesctopsComputers(){
        waiter.waitForElementToBeClickable(desktopsButton);
        desktopsButton.click();
    }
}

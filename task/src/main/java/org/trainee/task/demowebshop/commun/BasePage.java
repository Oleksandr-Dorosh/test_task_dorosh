package org.trainee.task.demowebshop.commun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.trainee.task.utils.Waiter;

public class BasePage {

    protected Waiter waiter;
    public BasePage(WebDriver driver) {
        waiter = new Waiter(driver);
        PageFactory.initElements(driver, this);
    }
}

package demowebshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.trainee.task.demowebshop.*;
import org.trainee.task.demowebshop.commun.HeaderPage;


public class BuildComputerTest {
    private static WebDriver webDriver;
    private static ProductPage productPage;
    private static HeaderPage headerPage;
    private static CartPage cartPage;

    @BeforeAll
    private static void setUp() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        webDriver = new EdgeDriver();
        webDriver.manage().window().maximize();
        productPage = new ProductPage(webDriver);
        headerPage = new HeaderPage(webDriver);
        cartPage = new CartPage(webDriver);
        webDriver.get("http://demowebshop.tricentis.com/build-your-own-expensive-computer-2");

    }
    @Test
    public void testSelectProcessor(){
        productPage.selectProcessor();
        productPage.selectRAM();
        productPage.selectAllCheckboxes();
        productPage.addProductToCart();
    }

    @Test
    public void testCart(){
        headerPage.clickShoppingCart();
        Assertions.assertTrue(cartPage.isItemDisplayed());
    }
    @Test
    public void testRemoveFromCart(){
        productPage.removeCheckbox();
        productPage.updateCart();
    }
}

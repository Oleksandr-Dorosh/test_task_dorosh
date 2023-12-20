package demowebshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.trainee.task.demowebshop.*;
import org.trainee.task.demowebshop.commun.HeaderPage;

public class CartFlowTest {
    private static WebDriver webDriver;
    private static HomePage homePage;
    private static ComputersPage computersPage;
    private static ProductsPage productsPage;
    private static ProductPage productPage;
    private static HeaderPage headerPage;
    private static CartPage cartPage;

    @BeforeAll
    private static void setUp() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        webDriver = new EdgeDriver();
        webDriver.manage().window().maximize();
        homePage = new HomePage(webDriver);
        computersPage = new ComputersPage(webDriver);
        productsPage = new ProductsPage(webDriver);
        productPage = new ProductPage(webDriver);
        headerPage = new HeaderPage(webDriver);
        cartPage = new CartPage(webDriver);

    }

    @Test
    public void testTaskA() throws InterruptedException {
        webDriver.get("http://demowebshop.tricentis.com/");
        homePage.clickComputersButton();
        computersPage.selectDesctopsComputers();
        productsPage.selectDisplayPerPage("4");
        productsPage.selectSortByText("Price: High to Low");
        productsPage.addToCartProductWithHighestPriceProduct();
        productPage.addProductToCart();
        headerPage.clickShoppingCart();
        Assertions.assertTrue(cartPage.isItemDisplayed());
    }

}

package demowebshop;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.trainee.task.demowebshop.*;
import org.trainee.task.demowebshop.commun.HeaderPage;

public class CartFlowTest {
    private static WebDriver webDriver;
    private static ProductPage productPage;
    private static HeaderPage headerPage;
    private static CartPage cartPage;
    private static HomePage homePage;
    private static ComputersPage computersPage;
    private static ProductsPage productsPage;

    @BeforeAll
    private static void setUp() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        webDriver = new EdgeDriver();
        webDriver.manage().window().maximize();
        productPage = new ProductPage(webDriver);
        headerPage = new HeaderPage(webDriver);
        cartPage = new CartPage(webDriver);
        homePage = new HomePage(webDriver);
        computersPage = new ComputersPage(webDriver);
        productsPage = new ProductsPage(webDriver);
        productPage = new ProductPage(webDriver);
        headerPage = new HeaderPage(webDriver);
        cartPage = new CartPage(webDriver);
    }

    @Test
    public void testCart() {
        webDriver.get("http://demowebshop.tricentis.com/build-your-own-expensive-computer-2");
        productPage.selectProcessor();
        productPage.selectRAM();
        productPage.selectAllCheckboxes();
        productPage.addProductToCart();
        headerPage.clickShoppingCart();
        Assertions.assertTrue(cartPage.isItemDisplayed());
    }

    @Test
    public void testTaskA() {
        webDriver.get("http://demowebshop.tricentis.com/");
        homePage.clickComputersButton();
        computersPage.selectDesktopsComputers();
        productsPage.selectDisplayPerPage("4");
        productsPage.selectSortByText("Price: High to Low");
        productsPage.addToCartProductWithHighestPriceProduct();
        productPage.addProductToCart();
        headerPage.clickShoppingCart();
        Assertions.assertTrue(cartPage.isItemDisplayed());
    }

    @AfterEach
    public void testRemoveFromCart() {
        webDriver.get("https://demowebshop.tricentis.com/cart");
        productPage.removeCheckbox();
        productPage.updateCart();
    }

    @AfterAll
    public static void сleanUp() {
        webDriver.quit();
    }
}

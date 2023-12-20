package main;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MainPageTest {
    @Test
    public void testMainPage() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://demowebshop.tricentis.com/");


    }
}
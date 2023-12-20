package org.trainee.task;


import org.openqa.selenium.edge.EdgeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.http.factory","jdk-http-client");
        System.setProperty("webdriver.edge.driver","src/test/resources/msedgedriver.exe");

        EdgeDriver edgeDriver = new EdgeDriver();
        edgeDriver.navigate().to("http://demowebshop.tricentis.com/");
        Thread.sleep(3000);


    }
}
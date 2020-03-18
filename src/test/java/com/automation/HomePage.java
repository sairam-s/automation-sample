package com.automation;

import org.testng.annotations.Test;

import java.io.IOException;

public class HomePage extends Base {
    public HomePage() throws IOException {
        driver = initialiseDriver();
    }

    @Test
    public void hoempageNavigation() {
        driver.get("http://google.co.nz");
        System.out.println(driver.getTitle());
        driver.quit();
    }

}

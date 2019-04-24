package com.demo.testcase;

import com.demo.driver.Driver;
import com.demo.page.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    public static MainPage mainPage;

    @BeforeAll
    public static void setUp() {
        mainPage = MainPage.getInstance().gotoMain();

    }


    @AfterAll
    public static void teardown() {
        System.out.println("teardown");
        Driver.getInstance().quit();
    }
}

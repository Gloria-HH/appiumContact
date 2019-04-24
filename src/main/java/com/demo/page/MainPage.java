package com.demo.page;

import com.demo.driver.Driver;
import com.demo.page.contact.ContactPage;
import com.demo.page.favorite.FavoritePage;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    By allContact = byText("All contacts");
    By favorites = byText("Favorites");
    private final static MainPage mainPage = new MainPage();


    public ContactPage gotoContact() {
        click(allContact);
        return new ContactPage();
    }

    public FavoritePage gotoFavorite() {
        click(favorites);
        return new FavoritePage();
    }

    public static MainPage getInstance() {
        return mainPage;
    }

    public static MainPage gotoMain() {
        Driver.getInstance().start();
        return mainPage;
    }


}

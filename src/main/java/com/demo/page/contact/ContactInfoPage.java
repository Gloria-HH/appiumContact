package com.demo.page.contact;

import com.demo.driver.Driver;
import com.demo.page.BasePage;
import com.demo.response.ContactInfoResponse;
import org.openqa.selenium.By;

public class ContactInfoPage extends BasePage {


    public ContactInfoResponse getCurrentContactInfo() {
        String name = find(By.id("large_title")).getText();
        ContactInfoResponse contactInfoResponse = new ContactInfoResponse();
        contactInfoResponse.setName(name);
        return contactInfoResponse;
    }

    public ContactPage back() {
        Driver.getInstance().getAppiumDriver().navigate().back();
        return new ContactPage();
    }


}

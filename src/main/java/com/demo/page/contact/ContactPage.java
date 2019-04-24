package com.demo.page.contact;

import com.demo.driver.Driver;
import com.demo.page.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class ContactPage extends BasePage {
    By addContact = By.id("floating_action_button");


    public ContactInfoPage addContact(String name, String phone, String mail) {
//        click(By.id("left_button"));
        click(addContact);
        sendKeys(byText("Name"), name);
        sendKeys(byText("Phone"), phone);
        sendKeys(byText("Email"), mail);
        click(By.id("menu_save"));
        return new ContactInfoPage();
    }
    public String getName(String name){
        By departmentName= MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".scrollIntoView(new UiSelector().text(\""+ name + "\").instance(0));");
        return attribute(departmentName, "text");
    }


}

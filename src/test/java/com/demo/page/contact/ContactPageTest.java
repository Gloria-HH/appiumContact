package com.demo.page.contact;

import com.demo.page.MainPage;
import com.demo.response.ContactInfoResponse;
import com.demo.testcase.BaseTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactPageTest extends BaseTest {

    @Test
    void add() {
        Long currentTime = System.currentTimeMillis();
        String contactName = String.valueOf(currentTime);
        String phone = String.valueOf(currentTime);
        String email = currentTime + "@sina.com";
        ContactInfoPage contactInfoPage = mainPage.gotoContact()
                .addContact(contactName, phone, email);
        ContactInfoResponse contactInfoResponse = contactInfoPage.getCurrentContactInfo();
        contactInfoPage.back();
        assertThat(contactName, equalTo(contactInfoResponse.getName()));

    }

    @Test
    void query() {
        String name = "tekkk";
        String showName = mainPage.gotoContact().getName(name);
        assertThat(name, equalTo(showName));

    }



}

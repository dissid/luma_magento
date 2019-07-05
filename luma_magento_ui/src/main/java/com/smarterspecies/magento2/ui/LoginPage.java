package com.smarterspecies.magento2.ui;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    @Step("Open Login page")

    public static LoginPage open() {
        Selenide.open("/customer/account/login/");
        return new LoginPage();
    }
    @Step("User is logged as: {email} and password: {password}")
    @Link("CPSP-64")
    public MyAccountPage fillLoginForm(String email, String password) {
        $("#email").setValue(email);
        $("#pass").setValue(password);
        $("#send2").click();

        return new MyAccountPage();
    }
}

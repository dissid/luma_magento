package com.smarterspecies.magento2.ui;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationUserPage {

    public static RegistrationUserPage open() {
        Selenide.open("/customer/account/create/");
        return new RegistrationUserPage();
    }
    public MyAccountPage registeredAs(String name, String last_name, String email, String pass, String pass2) {
        $("#firstname").setValue(name);
        $("#lastname").setValue(last_name);
        $("#email_address").setValue(email);
        $("#password").setValue(pass);
        $("#password-confirmation").setValue(pass2);
        $("#form-validate button").click();
        return new MyAccountPage();
    }
}

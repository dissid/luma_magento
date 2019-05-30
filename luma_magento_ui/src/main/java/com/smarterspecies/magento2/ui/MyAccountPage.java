package com.smarterspecies.magento2.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MyAccountPage {

    public SelenideElement userName(){
        return $(".panel.header .greet.welcome > span");
    }

}

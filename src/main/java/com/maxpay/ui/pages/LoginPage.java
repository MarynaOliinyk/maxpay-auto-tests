package com.maxpay.ui.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class LoginPage {
    @Getter
    private SelenideElement userField = $(By.id("login-email")),
            passwordField = $(By.id("login-password")),
            loginButton = $(By.xpath("//form[@name='loginForm']//button[@type='submit'][contains(text(),'Войти')]")),
            incorrectCredentialsMessage = $(byText("Некорректны пароль или email"));

    public void login(String user, String password) {
        assertEquals(url(), "https://my-sandbox.maxpay.com/#/signin");
        this.userField.should(visible, attribute("type", "email")).val(user);
        this.passwordField.should(visible, attribute("type", "password")).val(password);
        loginButton.should(visible, attribute("type", "submit")).click();
    }

    public void checkIncorrectCredentialsMessage(String incorrectCredentialsMessageText) {
        incorrectCredentialsMessage.should(visible, exactTextCaseSensitive(incorrectCredentialsMessageText));
    }
}

package com.maxpay.ui;

import com.maxpay.ui.core.DriverBase;
import com.maxpay.ui.pages.DashBoard;
import com.maxpay.ui.pages.LoginPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class LoginTest extends DriverBase {
    String email = "qa+test+automation@maxpay.com";
    String password = "ZXCasdQWE123";
    String incorrecttEmail = "qa+test+automation@maxpay.com";
    String incorrectCredentialsText = "Некорректны пароль или email";

   LoginPage loginPage =  new LoginPage();
   DashBoard dashBoard = new DashBoard();
    @Test
    public void loginWithCorrectCredentials(){
        loginPage.login(email,password);
        dashBoard.checkSuccessfulLogin();

    }

    @Test
    public void loginWithInCorrectCredentials() {
        loginPage.login(incorrecttEmail, password);
        loginPage.checkIncorrectCredentialsMessage(incorrectCredentialsText);
        String expectURL = "https://my-sandbox.maxpay.com/#/signin";
        assertEquals(expectURL, url());
    }
}

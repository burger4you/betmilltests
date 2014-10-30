package ru.badbin.pages;

import net.thucydides.core.Thucydides;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

@DefaultUrl("http://autotest.dev.badbin.ru/office/")
public class LoginForm extends PageObject {

    @FindBy(id = "username")
    private WebElementFacade loginField;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(id = "ext-gen48")
    private WebElementFacade enterButton;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void loading() {
        if (getDriver().getTitle().contains("404")) Thucydides.ignoredStep("404");
        loginField.shouldBeEnabled();
        passwordField.shouldBeEnabled();
        enterButton.shouldBeEnabled();
    }

    public void enter_login(String login) {
        enter(login).into(loginField);
    }

    public void enter_password(String password) {
        enter(password).into(passwordField);
    }

    public void click_to_enter_button() {
        enterButton.click();
    }
}
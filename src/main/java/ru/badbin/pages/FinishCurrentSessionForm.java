package ru.badbin.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

@DefaultUrl("http://autotest.dev.badbin.ru/office/")
public class FinishCurrentSessionForm extends PageObject {

    @FindBy(id = "session_end_ok_button")
    private WebElementFacade confirmFinishButton;

    @FindBy(id = "session_end_cancel_button")
    private WebElementFacade cancelFinishButton;

    public FinishCurrentSessionForm(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void loading() {
        confirmFinishButton.shouldBeEnabled();
        cancelFinishButton.shouldBeEnabled();
    }

    public void click_to_confirm_button() {
        confirmFinishButton.click();
    }

    public void click_to_cancel_button() {
        cancelFinishButton.click();
    }
}
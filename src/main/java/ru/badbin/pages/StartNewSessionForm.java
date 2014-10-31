package ru.badbin.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

@DefaultUrl("http://autotest.dev.badbin.ru/office/")
public class StartNewSessionForm extends PageObject {

    @FindBy(id = "operatorFioField")
    private WebElementFacade operatorFioField;

    @FindBy(id = "ext-comp-1087")
    private WebElementFacade confirmButton;

    @FindBy(id = "ext-comp-1088")
    private WebElementFacade cancelButton;


    public StartNewSessionForm(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void loading() {
        operatorFioField.shouldBeEnabled();
        confirmButton.shouldBePresent();
        cancelButton.shouldBePresent();
    }

    public void enter_operator_name(String operatorFio) {
        enter(operatorFio).into(operatorFioField);
    }

    public void click_to_confirm_button() {
        confirmButton.click();
    }

    public void click_to_cancel_button() {
        cancelButton.click();
    }
}
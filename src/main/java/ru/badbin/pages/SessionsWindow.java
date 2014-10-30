package ru.badbin.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

@DefaultUrl("http://autotest.dev.badbin.ru/office/")
public class SessionsWindow extends PageObject {

    @FindBy(xpath = ".//*[text()='Завершить смену']")
    private WebElementFacade finishSessionButton;

    @FindBy(xpath = ".//*[text()='Начать новую смену']")
    private WebElementFacade newSessionButton;

    @FindBy(xpath = ".//*[@class='x-tool x-tool-minimize']")
    private WebElementFacade minimizeWindowIcon;

    @FindBy(id = "ext-comp-1076")
    private WebElementFacade confirmErrorButton;

    @FindBy(id = "ext-comp-1081")
    private WebElementFacade sessionAlert;

    @FindBy(xpath = ".//*[text()='OK']")
    private WebElementFacade confirmAlertButton;

    public SessionsWindow(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void loading() {
        finishSessionButton.shouldBeEnabled();
        newSessionButton.shouldBeEnabled();
    }

    public void click_to_finish_current_session_button() {
        finishSessionButton.click();
        if (containsAllText("В настоящее время по данной кассе нет открытой смены")) {
//            Logger.getGlobal().info("Открытых смен нет");
            confirmErrorButton.click();
        }
    }

    public void click_to_new_session_button() {
        newSessionButton.click();
    }

    public void click_to_minimize_window_icon() {
        minimizeWindowIcon.click();
    }

    public boolean has_done_alert() {
        return sessionAlert.isCurrentlyVisible() && sessionAlert.containsText("смена успешно");
    }

    public boolean has_error_alert() {
        return sessionAlert.isCurrentlyVisible() && sessionAlert.containsText("Ошибка");
    }

    public void click_to_confirm_alert_button() {
        confirmAlertButton.click();
    }
}
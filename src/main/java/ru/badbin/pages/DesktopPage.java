package ru.badbin.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

@DefaultUrl("http://autotest.dev.badbin.ru/office/")
public class DesktopPage extends PageObject {

    @FindBy(id = "cards-win-shortcut")
    private WebElementFacade handlingShortcut;

    @FindBy(id = "sessions-win-shortcut")
    private WebElementFacade sessionsShortcut;

    public DesktopPage(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void loading() {
        sessionsShortcut.shouldBeEnabled();
        handlingShortcut.shouldBeEnabled();
    }

    public void click_to_handling_shortcut() {
        handlingShortcut.click();
    }

    public void click_to_sessions_shortcut() {
        sessionsShortcut.click();
    }
}
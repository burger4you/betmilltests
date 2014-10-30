package ru.badbin.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

@DefaultUrl("http://autotest.dev.badbin.ru/office/")
public class HandlingTabsNavigator extends PageObject {

    @FindBy(id = "manageTabPanel__fillPanelTab")
    private WebElementFacade fillingTab;

    @FindBy(id = "manageTabPanel__timelinePanelTab")
    private WebElementFacade timeLineTab;

    @FindBy(id = "manageTabPanel__ext-comp-1149")
    private WebElementFacade takenTab;

    @FindBy(id = "manageTabPanel__ext-comp-1182")
    private WebElementFacade clubCardsTab;

    @FindBy(id = "manageTabPanel__paymentsPanel")
    private WebElementFacade paymentsTab;

    @FindBy(id = "manageTabPanel__ratsPanel")
    private WebElementFacade ratsTab;


    @FindBy(id = "ext-gen293")
    private WebElementFacade minimizeWindowIcon;

    public HandlingTabsNavigator(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void loading() {
        fillingTab.shouldBeEnabled();
        timeLineTab.shouldBeEnabled();
        takenTab.shouldBeEnabled();
        clubCardsTab.shouldBeEnabled();
        paymentsTab.shouldBeEnabled();
        ratsTab.shouldBeEnabled();
    }

    public void click_to_filling_tab() {
        fillingTab.click();
    }

    public void click_to_timeLine_tab() {
        timeLineTab.click();
    }

    public void click_to_taken_tab() {
        takenTab.click();
    }

    public void click_to_clubCards_tab() {
        clubCardsTab.click();
    }

    public void click_to_payments_tab() {
        paymentsTab.click();
    }

    public void click_to_rats_tab() {
        ratsTab.click();
    }

    public void click_to_minimize_window_icon() {
        minimizeWindowIcon.click();
    }
}
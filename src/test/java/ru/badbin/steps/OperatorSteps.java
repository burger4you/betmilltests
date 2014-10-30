package ru.badbin.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import ru.badbin.pages.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

import static net.thucydides.core.matchers.BeanMatchers.the;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;

public class OperatorSteps extends ScenarioSteps {

    DesktopPage desktop;
    LoginForm loginForm;
    SessionsWindow sessions;
    StartNewSessionForm newSessionForm;
    HandlingFillingWindow fillingWindow;
    SearchClientForm searchClientForm;
    HandlingTabsNavigator tabsNavigator;
    HandlingTakenWindow takenWindow;
    FinishCurrentSessionForm finishSessionForm;

    public OperatorSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void logs_in_office(String login, String password) {
        loginForm.open();
        loginForm.enter_login(login);
        loginForm.enter_password(password);
        loginForm.click_to_enter_button();
    }

    @Step
    public void is_the_desktop_page() {
        desktop.loading();
    }

    @Step
    public void opens_new_session(String operatorFio) {
        desktop.loading();
        desktop.click_to_sessions_shortcut();
        sessions.loading();
        sessions.click_to_new_session_button();
        waitABit(3000);
        if (sessions.containsText("По данной кассе не была завершена предыдущая смена")) {
            sessions.click_to_confirm_alert_button();
            sessions.click_to_finish_current_session_button();
            finishSessionForm.loading();
            finishSessionForm.click_to_confirm_button();
            sessions.click_to_confirm_alert_button();
            Logger.getGlobal().info("Текущая смена была перед открытием новой смены");
            sessions.click_to_new_session_button();
        }
        newSessionForm.loading();
        newSessionForm.enter_operator_name(operatorFio);
        newSessionForm.click_to_confirm_button();
        sessions.click_to_confirm_alert_button();
        waitABit(3000);
        sessions.getDriver().switchTo().defaultContent();
    }

    @Step
    public void minimizes_sessions_window() {
        sessions.loading();
        sessions.click_to_minimize_window_icon();
    }

    @Step
    public void opens_handling() {
        desktop.loading();
        desktop.click_to_handling_shortcut();
    }

    @Step
    public void sets_client_by_Id(String userId) {
        fillingWindow.loading();
        fillingWindow.click_to_search_client_icon();
        searchClientForm.loading();
        searchClientForm.enter_search_request(userId);
        searchClientForm.click_to_ok_button();
        searchClientForm.click_on_client_checkbox_matching_with(the("ID", is(userId)));
    }

    @Step
    public void adds_random_bet_2_for_game(String competitorHome, String competitorAway, String betValue) {
        fillingWindow.loading();
        fillingWindow.click_on_bet_2_icon_matching_with(the("3", allOf(containsString(competitorHome), containsString(competitorAway))));
        fillingWindow.enter_bet_value(betValue);
        fillingWindow.click_on_confirm_bet_button();
    }

    @Step
    public void minimizes_handling_window() {
        tabsNavigator.loading();
        tabsNavigator.click_to_minimize_window_icon();
    }

    @Step
    public void opens_taken_window() {
        tabsNavigator.loading();
        tabsNavigator.click_to_taken_tab();
    }

    @Step
    public void prints_invoice_for_bet(String competitorHome, String competitorAway) {
        takenWindow.loading();
        takenWindow.click_on_print_invoice_icon_matching_with(the("Действие", allOf(containsString(competitorHome), containsString(competitorAway))));
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void opens_live_window() {
        fillingWindow.loading();
        fillingWindow.click_on_live_button();
    }
}
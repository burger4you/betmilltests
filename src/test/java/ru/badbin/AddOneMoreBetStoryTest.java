package ru.badbin;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ru.badbin.requirements.Application;
import ru.badbin.steps.OperatorSteps;

@Story(Application.Bets.OneMoreBet.class)
@RunWith(ThucydidesRunner.class)
public class AddOneMoreBetStoryTest {

    @Managed(uniqueSession = false)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://autotest.dev.badbin.ru")
    public Pages pages;

    @Steps
    public OperatorSteps operator;

    @Test
    public void add_one_more_bet_prematch() {
        operator.logs_in_office("test111", "1");
        operator.is_the_desktop_page();
        operator.opens_new_session("Иванова Светлана Николаевна");
        operator.minimizes_sessions_window();
        operator.opens_handling();
        operator.sets_client_by_Id("1683");
        operator.adds_random_bet_2_for_game("Германия", "Франция", "400");
        operator.opens_taken_window();
        operator.prints_invoice_for_bet("Германия", "Франция");
    }

    @Test
    public void add_one_more_bet_live() {
        operator.logs_in_office("test111", "1");
        operator.is_the_desktop_page();
        operator.opens_new_session("Селиванова Марина Петровна");
        operator.minimizes_sessions_window();
        operator.opens_handling();
        operator.opens_live_window();
        operator.sets_client_by_Id("1683");
        operator.adds_random_bet_2_for_game("Германия", "Франция", "400");
        operator.opens_taken_window();
        operator.prints_invoice_for_bet("Германия", "Франция");
    }
} 
package ru.badbin.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.matchers.BeanMatcher;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static net.thucydides.core.pages.components.HtmlTable.filterRows;
import static net.thucydides.core.pages.components.HtmlTable.rowsFrom;

@DefaultUrl("http://autotest.dev.badbin.ru/office/")
public class HandlingFillingWindow extends PageObject {

    @FindBy(xpath = ".//*[@title='Поиск клиентов']")
    private WebElementFacade searchClientIcon;

    @FindBy(xpath = ".//table[@class='b-events-grid']")
    private WebElementFacade betsTable;

    @FindBy(xpath = ".//*[@class='bet-value']")
    private WebElementFacade betValueField;

    @FindBy(id = "submit")
    private WebElementFacade confirmBetButton;

    @FindBy(css = "a.live.item")
    private WebElementFacade liveMenuItem;

    public HandlingFillingWindow(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void loading() {
        waitForWithRefresh();
        element(By.xpath(".//*[@title='Поиск клиентов']")).waitUntilEnabled();
//        betsTable.waitUntilEnabled();
        searchClientIcon.shouldBeEnabled();

    }

    public void click_to_search_client_icon() {
        searchClientIcon.click();
    }

    /**
     * Получить загаловки таблицы ставок, для удобной работы с ними
     *
     * @return - загаловки таблицы
     */
    public List<Map<Object, String>> getSearchResults() {
        return rowsFrom(betsTable);
    }

    /**
     * Кликнуть первую ставку, которая совпадет с запросом
     *
     * @param matchers - запрос
     */
    public void click_on_bet_1_icon_matching_with(BeanMatcher... matchers) {
        List<WebElement> matchingRows = filterRows(betsTable, matchers);
        WebElement targetRow = matchingRows.get(0);
        WebElement bet1Icon = targetRow.findElement(By.id("555-coeff_CW_P1"));
        bet1Icon.click();
    }

    /**
     * Кликнуть первую ставку, которая совпадет с запросом
     *
     * @param matchers - запрос
     */
    public void click_on_bet_2_icon_matching_with(BeanMatcher... matchers) {
        List<WebElement> matchingRows = filterRows(betsTable, matchers);
        WebElement targetRow = matchingRows.get(0);
        WebElement bet2Icon = targetRow.findElement(By.id("553-coeff_CW_P2"));
        bet2Icon.click();
    }

    /**
     * Кликнуть первую фору, которая совпадет с запросом
     *
     * @param matchers - запрос
     */
    public void click_on_fora_1_icon_matching_with(BeanMatcher... matchers) {
        List<WebElement> matchingRows = filterRows(betsTable, matchers);
        WebElement targetRow = matchingRows.get(0);
        WebElement fora1Icon = targetRow.findElement(By.id("553-coeff_ODDS_FT_0ODDS_H"));
        fora1Icon.click();
    }

    /**
     * Кликнуть вторую фору, которая совпадет с запросом
     *
     * @param matchers - запрос
     */
    public void click_on_fora_2_icon_matching_with(BeanMatcher... matchers) {
        List<WebElement> matchingRows = filterRows(betsTable, matchers);
        WebElement targetRow = matchingRows.get(0);
        WebElement fora2Icon = targetRow.findElement(By.id("553-coeff_ODDS_FT_0ODDS_A"));
        fora2Icon.click();
    }

    /**
     * Кликнуть ТМ ставку, которая совпадет с запросом
     *
     * @param matchers - запрос
     */
    public void click_on_bet_tm_icon_matching_with(BeanMatcher... matchers) {
        List<WebElement> matchingRows = filterRows(betsTable, matchers);
        WebElement targetRow = matchingRows.get(0);
        WebElement betTmIcon = targetRow.findElement(By.id("553-coeff_FT_TL"));
        betTmIcon.click();
    }

    /**
     * Кликнуть ТБ ставку, которая совпадет с запросом
     *
     * @param matchers - запрос
     */
    public void click_on_bet_tb_icon_matching_with(BeanMatcher... matchers) {
        List<WebElement> matchingRows = filterRows(betsTable, matchers);
        WebElement targetRow = matchingRows.get(0);
        WebElement betTbIcon = targetRow.findElement(By.id("553-coeff_FT_TG"));
        betTbIcon.click();
    }

    public void enter_bet_value(String betValue) {
        betValueField.waitUntilPresent();
        enter(betValue).into(betValueField);
    }

    public void click_on_confirm_bet_button() {
        confirmBetButton.click();
        confirmBetButton.waitUntilNotVisible();
    }

    public void click_on_live_button() {
        liveMenuItem.click();
    }
}
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
public class SearchClientForm extends PageObject {

    @FindBy(name = "term")
    private WebElementFacade searchField;

    @FindBy(xpath = ".//*[@class='input-search button']")
    private WebElementFacade okButton;

    @FindBy(xpath = ".//*[@class='b-events-grid']")
    private WebElementFacade clientsTable;

    public SearchClientForm(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void loading() {
        searchField.shouldBeEnabled();
        okButton.shouldBeEnabled();
        clientsTable.shouldBeEnabled();
    }

    public void enter_search_request(String request) {
        enter(request).into(searchField);
    }

    public void click_to_ok_button() {
        okButton.click();
    }

    /**
     * Получить загаловки таблицы клиентов, для удобной работы с ними
     *
     * @return - загаловки таблицы
     */
    public List<Map<Object, String>> getSearchResults() {
        return rowsFrom(clientsTable);
    }

    /**
     * Кликнуть чекбокс клиента, который первый совпадет с запросом
     *
     * @param matchers - запрос
     */
    public void click_on_client_checkbox_matching_with(BeanMatcher... matchers) {
        List<WebElement> matchingRows = filterRows(clientsTable, matchers);
        WebElement targetRow = matchingRows.get(0);
        WebElement clientCheckbox = targetRow.findElement(By.xpath(".//input[@tabindex='-1']"));
        clientCheckbox.click();
    }


}
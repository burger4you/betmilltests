package ru.badbin.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.matchers.BeanMatcher;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.pages.components.HtmlTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static net.thucydides.core.pages.components.HtmlTable.filterRows;

@DefaultUrl("http://autotest.dev.badbin.ru/office/")
public class HandlingTakenWindow extends PageObject {

    @FindBy(id = "ext-gen2398")
    private WebElementFacade takenTable;

    public HandlingTakenWindow(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void loading() {
        takenTable.shouldBeEnabled();
    }


    /**
     * Получить загаловки таблицы ставок, для удобной работы с ними
     *
     * @return - загаловки таблицы
     */
    public List<Map<Object, String>> tableRows() {
        return HtmlTable.withColumns("Действие", "Сумма", "Коэф.", "Результат", "Совершена", "Рассчитана", "Изм. баланса", "Выигрыш", "НДФЛ", "К выплате", "Счёт", "Лайв", "Выплачено", "Печать")
                .readRowsFrom(takenTable);
    }

    /**
     * Кликнуть на печать чека ставки, которая совпадет с запросом
     *
     * @param matchers - запрос
     */
    public void click_on_print_invoice_icon_matching_with(BeanMatcher... matchers) {
        List<WebElement> matchingRows = filterRows(takenTable, matchers);
        WebElement targetRow = matchingRows.get(0);
        WebElement printIcon = targetRow.findElement(By.id("ext-gen3814"));
        printIcon.click();
    }
}
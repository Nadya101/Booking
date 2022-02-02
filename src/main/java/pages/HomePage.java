package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    private static final String SELECTED_MONTH = "//*[@class='bui-calendar__month'][contains(text(), '%s')]";
    private static final String SELECTED_DAY = "//*[@class='bui-calendar__month'][contains(text(), '%s')]/ancestor::*[@class='bui-calendar__wrapper']//td[contains(@data-date,'%s')]";

    private static final By SEARCH_INPUT = By.id("ss");
    private static final By DATA = By.xpath("//*[@data-calendar2-type = 'checkin']");
    private static final By LANGUAGE_ICON = By.xpath("//*[@data-modal-id = 'language-selection']");
    private static final By CALENDAR_NEXT_ARROW = By.xpath("//*[@data-bui-ref='calendar-next']");
    private static final By SEARCH_BUTTON = By.xpath("//*[@class = 'sb-searchbox__button ']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomePage() {
        openPage(BASE_URL);
        return this;
    }

    public LanguageModal clickOnLanguageIcon() {
        driver.findElement(LANGUAGE_ICON).click();
        return new LanguageModal(driver);
    }

    public HomePage selectCity(String cityName) {
        driver.findElement(SEARCH_INPUT).clear();
        driver.findElement(SEARCH_INPUT).sendKeys(cityName);
        return this;
    }

    public HomePage clickOnCheckInData() {
        driver.findElement(DATA).click();
        return this;
    }

    public HomePage selectCheckInData(String day, String monthAndYear) {
        selectCheckInMonth(monthAndYear);
        driver.findElement(By.xpath(String.format(SELECTED_DAY, monthAndYear, day))).click();
        return this;
    }

    public void selectCheckInMonth(String monthAndYear) {
        for (int i = 0; i < 12; i++) {
            List<WebElement> monthList = driver.findElements(By.xpath(String.format(SELECTED_MONTH, monthAndYear)));
            if (monthList.size() >= 1) {
                driver.findElement(By.xpath(String.format(SELECTED_MONTH, monthAndYear))).click();
                return;
            }
            driver.findElement(CALENDAR_NEXT_ARROW).click();
        }
    }

    public HomePage selectCheckOutData(String day, String monthAndYear) {
        selectCheckInMonth(monthAndYear);
        driver.findElement(By.xpath(String.format(SELECTED_DAY, monthAndYear, day))).click();
        return this;
    }

    public SearchResultsPage clickOnSearchButton(){
        driver.findElement(SEARCH_BUTTON).click();
        return new SearchResultsPage(driver);
    }

}
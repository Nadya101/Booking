package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waiters;

public class LanguageModal extends BasePage{

private static final String LANGUAGE = "//*[@data-lang='%s']";

    LanguageModal(WebDriver driver) {
        super(driver);
    }

    public HomePage selectLanguageByCode(String languageCode){
        Waiters.waitForElementLocated(driver, By.xpath(String.format(LANGUAGE, languageCode)), 10);
        driver.findElement(By.xpath(String.format(LANGUAGE, languageCode))).click();
        return new HomePage(driver);
    }

}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage{

public static final By PROPERTY_CART = By.xpath("//*[@data-testid='property-card']");
public static final By PROPERTY_ADDRESS = By.xpath("//*[@data-testid='address']");

public static final String NUMBER_OF_NIGHTS = "//*[contains(text(), '%s nights')]";
public static final String HOTEL_RATING = "//*[contains(text(), '%s')]/ancestor::div[@data-testid='property-card']//div[contains(@aria-label,'Scored')]";


   public  SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfPropertyCard(){
       return driver.findElements(PROPERTY_CART).size();
    }

    public int getNumberOfPropertiesBookedForPeriod(String numOfNights){
       return  driver.findElements(By.xpath(String.format(NUMBER_OF_NIGHTS, numOfNights))).size();
    }

    public int numberOfPropertiesWithTargetCity(String targetCity){
       int count = 0;
        List<WebElement> cities = driver.findElements(PROPERTY_ADDRESS);
        for (WebElement city : cities){
            String cityName = city.getText();
            if(cityName.contains(targetCity)){
                count++;
            }
        }
        return count;
    }

    public String getHotelRating(String hotelName){
       return driver.findElement(By.xpath(String.format(HOTEL_RATING, hotelName))).getText();
    }

}
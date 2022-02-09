package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CityTest extends BaseTest {

    @Test(description = "Verifies if search results contains correct city and date")
    public void checkCityAndDateInSearchResultTest() {
        homePage.openHomePage()
                .clickOnLanguageIcon()
                .selectLanguageByCode("en-us")
                .selectCity("Central New York City")
                .clickOnCheckInData()
                .selectCheckInData("1", "May 2022")
                .selectCheckOutData("30", "May 2022")
                .clickOnSearchButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(searchResultsPage.getNumberOfPropertiesBookedForPeriod("29"),
                searchResultsPage.getNumberOfPropertyCard());
        softAssert.assertEquals(searchResultsPage.numberOfPropertiesWithTargetCity("Central New York City"),
                searchResultsPage.getNumberOfPropertyCard());
        softAssert.assertAll();
    }

    @Test(description = "Verifies if hotel rating displays correctly")
    public void checkHotelRating() {
        homePage.openHomePage()
                .clickOnLanguageIcon()
                .selectLanguageByCode("en-us")
                .selectCity("Milan")
                .clickOnCheckInData()
                .selectCheckInData("17", "March 2022")
                .selectCheckOutData("15", "April 2022")
                .clickOnSearchButton();
        Assert.assertEquals(searchResultsPage.getHotelRating("ApartHotel Durini"), "8.7");
    }


}
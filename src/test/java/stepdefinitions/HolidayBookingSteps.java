package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.EtsTurHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HolidayBookingSteps {

    EtsTurHomePage pages=new EtsTurHomePage();


    @Given("User goes to {string} web site")
    public void user_goes_to_web_site(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }
    @Then("User can see home page")
    public void user_can_see_home_page() {
      assertTrue(pages.closeButtonForAd.isDisplayed());
    }

    @Given("User logs the web site")
    public void user_logs_the_web_site() throws InterruptedException {
       ReusableMethods.userLogIn(ConfigReader.getProperty("mail"),ConfigReader.getProperty("sifre"));
    }


    @Given("User can search boxes in home page")
    public void user_can_search_boxes_in_home_page() {
        ReusableMethods.pleaseWait(2);
        assertTrue(pages.destination.isDisplayed());
        assertTrue(pages.entryDate.isDisplayed());
        assertTrue(pages.releaseDate.isDisplayed());
        assertTrue(pages.numberButton.isDisplayed());
        assertTrue(pages.searchButton.isDisplayed());

    }
    @Then("closes driver")
    public void closes_driver() {
        Driver.closeDriver();

    }

    @Given("User fills  the necessary information in boxesd")
    public void user_fills_the_necessary_information_in_boxesd() {
        pages.destination.sendKeys(ConfigReader.getProperty("destination"));
        ReusableMethods.pleaseWait(3);
        //pages.destination.click();
        //ReusableMethods.jsClick(pages.closeButtonForAd);
        pages.closeButtonForAd.click();
        ReusableMethods.pleaseWait(2);
        pages.entryDate.click();
        ReusableMethods.jsScrollBy(200);
        ReusableMethods.pleaseWait(1);
        pages.startDate.click();
        ReusableMethods.pleaseWait(1);
        pages.endDate.click();
        ReusableMethods.pleaseWait(1);
        pages.numberButton.click();
        ReusableMethods.pleaseWait(1);
        pages.minusButton.click();
        ReusableMethods.pleaseWait(1);

    }
    @Given("Clicks searh button")
    public void clicks_searh_button() {
        //pages.searchButton.click();
        ReusableMethods.jsClick(pages.searchButton);
        ReusableMethods.pleaseWait(2);

    }
    @Given("User can see the holiday list")
    public void user_can_see_the_holiday_list() {
        ReusableMethods.pleaseWait(3);
        assertTrue(pages.informationMessage.isDisplayed());


    }

    @Given("User selects the desired hotel and clicks")
    public void user_selects_the_desired_hotel_and_clicks() {
        ReusableMethods.pleaseWait(2);
        String firstWindowHandle=Driver.getDriver().getWindowHandle();;
        pages.desiredHotelButton.click();
        ReusableMethods.pleaseWait(3);
        Set<String> windowhandles=Driver.getDriver().getWindowHandles();
        String secondWindowHandle = "";
        for (String each:windowhandles
             ) {
            if (!each.equals(firstWindowHandle)){
                secondWindowHandle=each;
            }
            Driver.getDriver().switchTo().window(secondWindowHandle);

        }




    }
    @Given("User can see the new page")
    public void user_can_see_the_new_page() {
        assertTrue(pages.filterItemBody.isDisplayed());
        ReusableMethods.pleaseWait(1);

    }


    @Given("User can see make a reservation button in new page")
    public void user_can_see_make_a_reservation_button_in_new_page() {
        assertTrue(pages.makeARezervationButton.isDisplayed());
        ReusableMethods.pleaseWait(1);
    }


}

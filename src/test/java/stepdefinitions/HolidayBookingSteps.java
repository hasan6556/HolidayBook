package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.TatilBudurTurHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HolidayBookingSteps {

    TatilBudurTurHomePage pages = new TatilBudurTurHomePage();


    @Given("User goes to {string} web site")
    public void user_goes_to_web_site(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @Then("User can see home page")
    public void user_can_see_home_page() {
        String expectedUrl = "https://www.tatilbudur.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @Given("User logs the web site")
    public void user_logs_the_web_site() throws InterruptedException {
        ReusableMethods.userLogIn(ConfigReader.getProperty("mail"), ConfigReader.getProperty("sifre"));
    }


    @Given("User can see search boxes in home page")
    public void user_can_see_search_boxes_in_home_page() {
        //ReusableMethods.pleaseWait(2);
        //assertTrue(pages.destination.isDisplayed());
        //ReusableMethods.pleaseWait(1);
        //assertTrue(pages.entryDate.isDisplayed());
        //assertTrue(pages.numberButton.isDisplayed());
        //assertTrue(pages.searchButton.isDisplayed());
        assertTrue(pages.hotelSearhBoxes.isDisplayed());

    }

    @Then("closes driver")
    public void closes_driver() {
        Driver.quitDriver();

    }

    @Given("User fills  the necessary information in boxesd")
    public void user_fills_the_necessary_information_in_boxesd() {
        ReusableMethods.pleaseWait(3);
        pages.destination.sendKeys(ConfigReader.getProperty("destination"));
        ReusableMethods.pleaseWait(2);
        pages.destination.click();
        ReusableMethods.pleaseWait(2);
        pages.entryDate.click();
        ReusableMethods.pleaseWait(1);
        pages.startDate.click();
        ReusableMethods.pleaseWait(1);
        pages.endDate.click();
        ReusableMethods.pleaseWait(1);
        pages.numberButton.click();
        ReusableMethods.pleaseWait(1);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", pages.minusButton);
        //pages.minusButton.click();
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
        String firstWindowHandle = Driver.getDriver().getWindowHandle();
        ;
        pages.desiredHotelButton.click();
        ReusableMethods.pleaseWait(3);
        Set<String> windowhandles = Driver.getDriver().getWindowHandles();
        String secondWindowHandle = "";
        for (String each : windowhandles
        ) {
            if (!each.equals(firstWindowHandle)) {
                secondWindowHandle = each;
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
        ReusableMethods.jsScrollBy(500);
        ReusableMethods.pleaseWait(2);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", pages.makeARezervationButton);
        ReusableMethods.pleaseWait(3);
        assertTrue(pages.makeARezervationButton.isDisplayed());
        ReusableMethods.pleaseWait(2);
    }

    @Given("User clicks the make a reservation button")
    public void user_clicks_the_make_a_reservation_button() {
        //pages.makeARezervationButton.click();
        ReusableMethods.jsClick(pages.makeARezervationButton);
        ReusableMethods.pleaseWait(2);


    }

    @Given("User can see boxes for enter his informations")
    public void user_can_see_boxes_for_enter_his_informations() {
        assertTrue(pages.boxesForEnterInformations.isDisplayed());

    }

    @Given("User can enter his informations in boxes")
    public void user_can_enter_his_informations_in_boxes() {
        pages.maleCheckbox.click();
        ReusableMethods.pleaseWait(2);
        pages.nameBox.sendKeys(ConfigReader.getProperty("firstName"));
        ReusableMethods.pleaseWait(1);
        pages.surNameBox.sendKeys(ConfigReader.getProperty("surName"));
        ReusableMethods.pleaseWait(1);
        pages.phoneBox.sendKeys(ConfigReader.getProperty("phone"));
        ReusableMethods.pleaseWait(3);
        pages.birthDateBox.click();
        ReusableMethods.pleaseWait(2);
        Select select = new Select(pages.yearBox);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        select.selectByVisibleText("2002");
        //ReusableMethods.pleaseWait(2);
        select = new Select(pages.monthBox);
        options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        select.selectByVisibleText("Haziran");
        ReusableMethods.pleaseWait(1);
        ReusableMethods.jsScrollBy(400);
        ReusableMethods.pleaseWait(2);
        pages.birthDay.click();
        ReusableMethods.pleaseWait(2);
        pages.identificationNumber.sendKeys(ConfigReader.getProperty("idNo"));
        ReusableMethods.pleaseWait(1);

    }

    @Given("User see add another person in rezervation page")
    public void user_see_add_another_person_in_rezervation_page() {
        ReusableMethods.pleaseWait(3);
        ReusableMethods.jsScrollBy(400);
        ReusableMethods.pleaseWait(2);
        assertTrue(pages.addAnotherPerson.isDisplayed());

    }

    @Given("when cliks add another person checkbox can see other information boxes")
    public void when_cliks_add_another_person_checkbox_can_see_other_information_boxes() {
        pages.addAnotherPerson.click();
        ReusableMethods.pleaseWait(2);
        assertTrue(pages.informationBoxesForAnotherPerson.isDisplayed());
        ReusableMethods.pleaseWait(1);
        pages.addAnotherPerson.click();
    }


    @Given("User see add billing checkbox in rezervation page")
    public void user_see_add_billing_checkbox_in_rezervation_page() {
        ReusableMethods.pleaseWait(3);
        ReusableMethods.jsScrollBy(600);
        ReusableMethods.pleaseWait(2);
        assertTrue(pages.addBillingInformation.isDisplayed());
    }
    @Given("when cliks add billig checkbox can see other information boxes")
    public void when_cliks_add_billig_checkbox_can_see_other_information_boxes() {
        pages.addBillingInformation.click();
        ReusableMethods.pleaseWait(2);
        assertTrue(pages.informationBoxesForBilling.isDisplayed());
        ReusableMethods.pleaseWait(1);
        pages.addBillingInformation.click();
    }

    @Given("User see add note checkbox in rezervation page")
    public void user_see_add_note_checkbox_in_rezervation_page() {
        ReusableMethods.pleaseWait(3);
        ReusableMethods.jsScrollBy(700);
        ReusableMethods.pleaseWait(2);
        assertTrue(pages.addNoteButton.isDisplayed());
    }
    @Given("when cliks add note checkbox can see description box")
    public void when_cliks_add_note_checkbox_can_see_description_box() {
        pages.addNoteButton.click();
        ReusableMethods.pleaseWait(2);
        assertTrue(pages.descriptionBoxForNote.isDisplayed());
        ReusableMethods.pleaseWait(1);
        pages.addNoteButton.click();
    }

    @Given("User see add transportation in rezervation page")
    public void user_see_add_transportation_in_rezervation_page() {
        ReusableMethods.pleaseWait(3);
        ReusableMethods.jsScrollBy(800);
        ReusableMethods.pleaseWait(2);
        assertTrue(pages.addTransportation.isDisplayed());
    }
    @Given("when cliks add transportation checkbox can see description box")
    public void when_cliks_add_transportation_checkbox_can_see_description_box() {
        pages.addTransportation.click();
        ReusableMethods.pleaseWait(2);
        assertTrue(pages.informationBoxesForTransportation.isDisplayed());
        ReusableMethods.pleaseWait(1);
        pages.closeButtonForTransportation.click();
    }

    @Given("User see check out to payment button in rezervation page")
    public void user_see_check_out_to_payment_button_in_rezervation_page() {
      ReusableMethods.jsScrollBy(850);
      ReusableMethods.waitForVisibility(pages.checkOutToPaymentButton,15);
      assertTrue(pages.checkOutToPaymentButton.isDisplayed());
    }

    @Given("when cliks checkout to payment page  can see payment page")
    public void when_cliks_checkout_to_payment_page_can_see_payment_page() {
        ReusableMethods.jsScrollBy(200);
        ReusableMethods.pleaseWait(3);
        pages.checkOutToPaymentButton.click();
        ReusableMethods.waitForVisibility(pages.paymentInformationBoxes,15);
        assertTrue(pages.paymentInformationBoxes.isDisplayed());

    }

    @Given("User clicks checkout to payment button")
    public void user_clicks_checkout_to_payment_button() {
        ReusableMethods.jsScrollBy(850);
        ReusableMethods.pleaseWait(3);
        ReusableMethods.jsScrollBy(200);
        ReusableMethods.pleaseWait(3);
        pages.checkOutToPaymentButton.click();
        ReusableMethods.waitForVisibility(pages.paymentInformationBoxes,15);
    }
    @Given("In new page user can enter his payment information in boxes")
    public void ın_new_page_user_can_enter_his_payment_information_in_boxes() {
        pages.cardNameSurname.sendKeys(ConfigReader.getProperty("cardNameSurname"));
        ReusableMethods.pleaseWait(2);
        pages.creditCardNoBox.sendKeys(ConfigReader.getProperty("cardNumber"));
        ReusableMethods.jsScrollBy(400);
        Select select=new Select(pages.cardDateMonth);
        select.selectByVisibleText("12");
        ReusableMethods.pleaseWait(2);
        select=new Select(pages.cardDateYear);
        select.selectByVisibleText("2027");
        ReusableMethods.pleaseWait(1);
        ReusableMethods.jsScrollBy(200);
        pages.cardCvc.sendKeys(ConfigReader.getProperty("CardCvc"));
        ReusableMethods.pleaseWait(2);
        pages.installmentCheckBox.click();
        ReusableMethods.pleaseWait(2);
        pages.contractAcceptanceCheckBox.click();


    }

    @Given("In new page user can see coupon box")
    public void ın_new_page_user_can_see_coupon_box() {
        ReusableMethods.jsScrollBy(450);
        assertTrue(pages.couponCodeBox.isDisplayed());
        ReusableMethods.pleaseWait(1);
    }

    @Given("In new page user can enter his coupon code in  coupon box")
    public void ın_new_page_user_can_enter_his_coupon_code_in_coupon_box() {
        ReusableMethods.jsScrollBy(250);
        pages.couponCodeBox.sendKeys(ConfigReader.getProperty("couponCode"));
        ReusableMethods.pleaseWait(1);
        pages.couponButton.click();
        ReusableMethods.pleaseWait(3);
    }


}

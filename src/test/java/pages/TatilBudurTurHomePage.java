package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TatilBudurTurHomePage {

   @FindBy(xpath = "(//*[text()=\"Rezervasyon Yap\"])[1]")
    public WebElement makeARezervationButton;

    public TatilBudurTurHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//button[@class=\"fc63351294 a822bdf511 e3c025e003 fa565176a8 f7db01295e c334e6f658 ae1678b153\"]")
    //@FindBy(xpath = "(//*[@xmlns=\"http://www.w3.org/2000/svg\"])[17]")
    public WebElement closeButtonForAd;

    @FindBy(xpath = "//*[@data-testid=\"date-display-field-end\"]")
    public WebElement releaseDate;

    @FindBy(xpath = "//*[@id=\"key\"]")
    public WebElement destination;

    @FindBy(xpath = "//*[@class=\"c-input c-input--has-icon hotel-search-daterange\"]")
    public WebElement entryDate;

 @FindBy(xpath = "//*[@class=\"c-finder \"]")
 public WebElement hotelSearhBoxes;


    @FindBy(xpath = "(//*[text()=\"30\"])[2]")
    public WebElement startDate;

    @FindBy(xpath = "(//*[text()=\"7\"])[3]")
    public WebElement endDate;

    @FindBy(xpath = "(//*[@name=\"personCount\"])[1]")
    public WebElement numberButton;

    @FindBy(xpath = "(//*[@disabled=\"disabled\"])[1]")
    public WebElement minusButton;


    @FindBy(xpath = "//*[@id=\"searchFormHotelSubmitBtn\"]")
    public WebElement searchButton;


    @FindBy(xpath = "//h1")
    public WebElement informationMessage;


    @FindBy(xpath = "(//button[text()=\"Oteli İncele\"])[1]")
    public WebElement desiredHotelButton;


    @FindBy(xpath = "//*[text()=\"Genel Özellikler\"]")
    public WebElement filterItemBody;


    @FindBy(xpath = "//div[@id=\"checkout__form__link\"]")
    public WebElement boxesForEnterInformations;

    @FindBy(xpath = "//*[@id=\"gender10\"]")
    public WebElement maleCheckbox;

    @FindBy(xpath = "//*[@id=\"name0\"]")
    public WebElement nameBox;


    @FindBy(xpath = "//*[@id=\"surname0\"]")
    public WebElement surNameBox;


    @FindBy(xpath = "//*[@id=\"phone\"]")
    public WebElement phoneBox;


    @FindBy(xpath = "//*[@name=\"contactEmail\"]")
    public WebElement emailBox;


    @FindBy(xpath = "//*[@name=\"adultBirthDate[0]\"]")
    public WebElement birthDateBox;

    @FindBy(xpath = "//*[@class=\"monthselect\"]")
    public WebElement monthBox;


    @FindBy(xpath = "//*[@class=\"yearselect\"]")
    public WebElement yearBox;

    @FindBy(xpath = "//*[@id=\"identityNumber0\"]")
    public WebElement identificationNumber;

    @FindBy(xpath = "(//*[@type=\"checkbox\"])[2]")
    public WebElement addAnotherPerson;

    @FindBy(xpath = "(//*[@type=\"checkbox\"])[5]")
    public WebElement addBillingInformation;

    @FindBy(xpath = "(//*[@type=\"checkbox\"])[7]")
    public WebElement addNoteButton;

    @FindBy(xpath = "//b[@onclick=\"appCheckout.pickTransform(this)\"]")
    public WebElement addTransportation;

    @FindBy(xpath = "//*[@id=\"invoiceArea\"]")
    public WebElement informationBoxesForBilling;


    @FindBy(xpath = "//*[@id=\"name1\"]")
    public WebElement informationBoxesForAnotherPerson;


    @FindBy(xpath = "//*[@id=\"description\"]")
    public WebElement descriptionBoxForNote;


    @FindBy(xpath = "//*[@class=\"checkout__transportation__list__item _flight checkout__transportation__list__item--active\"]")
    public WebElement informationBoxesForTransportation;

    @FindBy(xpath = "//*[text()=\" Vazgeç\"]")
    public WebElement closeButtonForTransportation;


    @FindBy(xpath = "(//button[@type=\"button\"])[10]")
    public WebElement checkOutToPaymentButton;



    @FindBy(xpath = "(//*[text()=\"16\"])[1]")
   public WebElement birthDay;


    @FindBy(xpath = "//*[@id=\"paymentForm\"]")
    public WebElement paymentInformationBoxes;


    @FindBy(xpath = "//*[@id=\"cardOwnerNameSurname\"]")
    public WebElement cardNameSurname;


    @FindBy(xpath = "//*[@name=\"creditCard\"]")
    public WebElement creditCardNoBox;


    @FindBy(xpath = "//*[@name=\"expireMonth\"]")
    public WebElement cardDateMonth;


    @FindBy(xpath ="//*[@name=\"expireYear\"]" )
    public WebElement cardDateYear;


    @FindBy(xpath ="//*[@name=\"cvc\"]" )
    public WebElement cardCvc;


    @FindBy(xpath = "(//*[@name=\"installmentOption\"])[2]")
    public WebElement installmentCheckBox;


    @FindBy(xpath = "(//*[@name=\"coupon_code\"])[1]")
    public WebElement couponCodeBox;


    @FindBy(xpath = "(//*[@onclick=\"checkCoupon(this);\"])[1]")
    public WebElement couponButton;


     @FindBy(xpath ="(//*[text()=\"Rezervasyon Oluştur\"])[1]" )
    public WebElement rezervationButton;


    @FindBy(xpath = "//*[@id=\"soz-check1-mobile\"]")
    public WebElement contractAcceptanceCheckBox;

}

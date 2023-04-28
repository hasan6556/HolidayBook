package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;
import utilities.Driver;

public class EtsTurHomePage {

   @FindBy(xpath = "//button[@id=\"hp_book_now_button\"]")
    public WebElement makeARezervationButton;

    public EtsTurHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//button[@class=\"fc63351294 a822bdf511 e3c025e003 fa565176a8 f7db01295e c334e6f658 ae1678b153\"]")
    //@FindBy(xpath = "(//*[@xmlns=\"http://www.w3.org/2000/svg\"])[17]")
    public WebElement closeButtonForAd;

    @FindBy(xpath = "//*[@data-testid=\"date-display-field-end\"]")
    public WebElement releaseDate;

    @FindBy(xpath = "//*[@id=\":Ra9:\"]")
    public WebElement destination;

    @FindBy(xpath = "//*[@data-testid=\"date-display-field-start\"]")
    public WebElement entryDate;


    @FindBy(xpath = "(//*[text()=\"28\"])[1]")
    public WebElement startDate;

    @FindBy(xpath = "(//*[text()=\"7\"])[2]")
    public WebElement endDate;

    @FindBy(xpath = "//*[@data-testid=\"occupancy-config\"]")
    public WebElement numberButton;

    @FindBy(xpath = "(//*[@xmlns=\"http://www.w3.org/2000/svg\"])[1]")
    public WebElement minusButton;


    @FindBy(xpath = "(//*[@class=\"e57ffa4eb5\"])[7]")
    public WebElement searchButton;


    @FindBy(xpath = "//h1")
    public WebElement informationMessage;


    @FindBy(xpath = "(//a[@data-testid=\"availability-cta-btn\"])[1]")
    public WebElement desiredHotelButton;


    @FindBy(xpath = "(//*[@data-scroll=\"a[name=availability]\"])[1]")
    public WebElement filterItemBody;


}

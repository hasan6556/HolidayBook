package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class ReusableMethods {
    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    //========Switching Window=====//
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getCurrentUrl().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    //========Hover Over=====//
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    //==========Return a list of string given a list of Web Element====////
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //========Returns the Text of the element given an element locator==//
    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //   HARD WAIT WITH THREAD.SLEEP
//   waitFor(5);  => waits for 5 second
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                bekle(1);
            }
        }
    }

    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    //======Fluent Wait====//
    public static WebElement fluentWait(final WebElement webElement, int timeout) {
        //FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver()).withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(timeinsec, TimeUnit.SECONDS);
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(3))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(1));//Check for the element every 1 second
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return webElement;
            }
        });
        return element;
    }

    //*************************Akif************************************
    public static void jsScrollBy(int scrollBy) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0," + scrollBy + ")");
    }

    public static void jsClick(WebElement elementClick) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", elementClick);
    }

    public static void jsToEndOfThePage() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void pleaseWait(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void userLogIn(String mail, String password) throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        Driver.getDriver().findElement(By.xpath("//*[@data-testid=\"header-sign-in-button\"]")).click();
        Driver.getDriver().findElement(By.xpath("//*[@name=\"username\"]")).sendKeys(mail);
        ReusableMethods.pleaseWait(2);
        Driver.getDriver().findElement(By.xpath("//*[@type=\"submit\"]")).click();
        ReusableMethods.pleaseWait(2);
        Driver.getDriver().findElement(By.xpath("//*[@name=\"password\"]")).sendKeys(password);
        ReusableMethods.pleaseWait(1);
        Driver.getDriver().findElement(By.xpath("//*[@type=\"submit\"]")).click();
        pleaseWait(2);
        //ReusableMethods.jsMouesDown(Driver.getDriver().findElement(By.xpath("//*[@style=\"animation: 28.9ms ease 0s 1 normal none running textColorIReverse;\"]")));
        //Actions action = new Actions(Driver.getDriver());
        //action.clickAndHold(Driver.getDriver().findElement(By.xpath("//*[text()=\"Güvenlik kontrolünü geçmek için bu butonu basılı tutun\"]"))).perform();
        //action.release().perform();
        //WebElement button = Driver.getDriver().findElement(By.xpath("//*[text()=\\\"Güvenlik kontrolünü geçmek için bu butonu basılı tutun\\\"]")); // Butonu bulun
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver(); // JavascriptExecutor örneği oluşturun

       // Butonun üzerine gelin ve basılı tutun
        String script = "var element = arguments[0];" + "var mouseEventObj = document.createEvent('MouseEvents');" + "mouseEventObj.initEvent( 'mousedown', true, true );" + "element.dispatchEvent(mouseEventObj);";
        js.executeScript(script, Driver.getDriver().findElement(By.xpath("//*[@style=\"animation: 28.9ms ease 0s 1 normal none running textColorIReverse;\"]")));

        // Gösterge dolana kadar bekleyin
        Thread.sleep(5000); // 5 saniye bekleyin (gösterge dolu olana kadar)

        // Basılı tutmayı bırakın
        script = "var element = arguments[0];" + "var mouseEventObj = document.createEvent('MouseEvents');" + "mouseEventObj.initEvent( 'mouseup', true, true );" + "element.dispatchEvent(mouseEventObj);";
        js.executeScript(script, Driver.getDriver().findElement(By.xpath("//*[@style=\"animation: 28.9ms ease 0s 1 normal none running textColorIReverse;\"]")));

    }


    public static void jsMouesDown(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].mousedown();", element);
    }
}
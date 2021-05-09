package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);

    }


    By flightalternative = By.xpath("//*[@id=\"uitk-tabs-button-container\"]/li[2]/a/span");
    By leavingfrom = By.cssSelector("button[aria-label='Leaving from']");
    By texboxdeparture = By.cssSelector("input[type=\"text\"][placeholder=\"Where are you leaving from?\"]");
    By lasvegas = By.cssSelector("div[class=\"is-subText truncate\"]");
    By goingto = By.cssSelector("button[aria-label='Going to']");
    By textboxarrival = By.cssSelector("input[type=\"text\"][placeholder=\"Where are you going to?\"]");
    By losangeles = By.xpath("//*[@id=\"location-field-leg1-destination-menu\"]/div[2]/ul/li[1]/button/div/div[2]");

    //calendar selectors
    By calendarpicker = By.id("d1-btn");
    By rightarrow = By.cssSelector("button[data-stid='date-picker-paging']");//return a list|click twice
    By departuredate = By.cssSelector("button[data-day=\"30\"]");
    By donebutton = By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[3]/button");
    By searchbutton = By.xpath("//*[text()[contains(.,'Search')]][@type]");


    /***
     * @author Rosangela
     * @description this method will select flight option from the service alternatives on the homepage.

     */
    public void switchToFlight() {
        boolean success;
        try {
            driver.findElement(flightalternative).click();

            success = true;

        } catch (Exception e) {
            success = false;
        }
        Assert.assertEquals(true, success);

    }

    /**
     * @param from it is the departure city.
     * @param to   it is the arrival city.
     * @author Rosangela
     * @description this method will select the departure and arrival cities on the flights box.
     */
    public void selectCities(String from, String to) {
        boolean success;
        try {
            driver.findElement(leavingfrom).click();
            WebElement inputDeparture = driver.findElement(texboxdeparture);
            inputDeparture.sendKeys(from);
            highLight(inputDeparture, driver);
            wait.until(ExpectedConditions.elementToBeClickable(lasvegas));
            WebElement lasVegasOpt = driver.findElement(lasvegas);
            lasVegasOpt.click();
            highLight(lasVegasOpt, driver);

            driver.findElement(goingto).click();
            WebElement inputArrival = driver.findElement(textboxarrival);
            inputArrival.sendKeys(to);
            highLight(inputArrival, driver);
            wait.until(ExpectedConditions.elementToBeClickable(losangeles));
            WebElement losAngelesOpt = driver.findElement(losangeles);
            losAngelesOpt.click();
            highLight(losAngelesOpt, driver);


            success = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            success = false;
        }
        Assert.assertEquals(true, success);
    }

    /**
     * @author Rosangela
     * @description this method will select the departure and arrival dates in the picker calendar.
     */
    public void selectDates() {
        boolean success;
        try {
            driver.findElement(calendarpicker).click();
            driver.findElements(rightarrow).get(1).click();
            driver.findElements(departuredate).get(1).click();
            driver.findElement(donebutton).click();
            driver.findElement(searchbutton).click();


            success = true;


        }catch (Exception e){
            System.out.println(e.getMessage());
            success = false;
        }
        Assert.assertEquals(true, success);
    }
}

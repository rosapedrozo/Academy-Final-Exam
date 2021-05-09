package Tests;

import Screens.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Runner {
    private WebDriver driver;
    String URL = "https://www.travelocity.com/";
    String URL_CHECKOUT ="https://www.travelocity.com/Flight-Information?journeyContinuationId=AQqEAwrlAnY1LXNvcy0wZTRjYmYyNjNhNjk0MWMzYWRlODJlNmFkNmE4OGFlZi0xMC0xLXN0LXY1LXNvcy1hYjNkMTE4Y2M3MTk0ZDRlOGZlYzAxM2FjZWZmMzY3Ny0yNS0xLTExNTZ-Mi5TfkFRb0VDSUh4QkJJSENOUUVFQWNZR3lBSElBRWdEQ0FOSUFrb0FsSUUyUFFCQUZnQ2NBQndBQX5BUW9vQ2lZSTFZSUJFZ1F5TVRZNEdJdVFBU0NMdUFFbzdKN3pBVENwbl9NQk9FNUFBRmdCYWdKQ1JSSUtDQUVRQVJnQktnSlZRUmdCSWdRSUFSQUJLQUlvQXlnRU1BSS5BUW92Q2kwSXhKZ0JFZ1F5TmpjMEdJdTRBU0NMa0FFb2tMSHpBVERkc2ZNQk9FVkFBRmdCYWdsQ1FWTkpRMFZEVDA0U0NnZ0JFQUVZQVNvQ1JFd1lBU0lFQ0FFUUFTZ0NLQU1vQkRBQxGamZmZmblhQCIBASoFEgMKATEqBwgBEgMKATESPwoWCgoyMDIxLTA3LTMwEgNMQVMaA0xBWAoWCgoyMDIxLTA3LTMxEgNMQVgaA0xBUxIHEgVDT0FDSBoCEAEgAhoKCAESBhoAIgIIAiAB";
    String URL_WHO_TRLV ="https://www.travelocity.com/Checkout/V1/FlightCheckout?tripid=883c67b7-84f8-5889-a7c2-b174578469dc&c=1a5cf5a4-1beb-46fd-ae3c-c907acd1c0d3";
    HomePage flights;
    FlightSearchs flightSearchs;
    SecondFlight secondFlight;
    CheckOut checkOut;
    WhoiSTraveling whoiSTraveling;



    @BeforeSuite
    public void initDriver(@Optional("CH") String browser) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C://Users//Usuario//Documents//driversSelenium//chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        flights = new HomePage(driver);
        flightSearchs = new FlightSearchs(driver);
        secondFlight = new SecondFlight(driver);
        checkOut = new CheckOut(driver);
        whoiSTraveling = new WhoiSTraveling(driver);


    }

    @Test(priority = 1, description = "Select a flight")
    public void selectOneFlights() {
        flights.switchToFlight();
        flights.selectCities("LAS", "LAX");
        flights.selectDates();

    }

    @Test(priority = 2, description = "Validate Drop Down Options")
    public void validateOptions() {
        flightSearchs.dropDownListValidation();
        flightSearchs.shortestFlightValidation();
    }

    @Test(priority = 3, description = "select the second flight")
    public void selectTheSecondFlight() {
        secondFlight.selectReturnedFlight();


    }

    @Test(priority = 4, description = "validate checkout information")
    public void validateCheckOutInfo() {
        driver.get(URL_CHECKOUT);
        checkOut.validateCheckoutInformation();
        

    }

    @Test(priority = 5, description = "validate who is traveling error messages")
    public void validateErrorMessages() {
        driver.get(URL_WHO_TRLV);
        whoiSTraveling.fillData();
        whoiSTraveling.errorMessagesValidation();


    }

    @AfterSuite
    public void closeDriver() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }


}

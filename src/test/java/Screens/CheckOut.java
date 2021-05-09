package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckOut {
    WebDriver driver;
    WebDriverWait wait;

    public CheckOut(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);

    }

    public final String TRIP_TOTAL = "Trip total";
    public final String LAS_TO_LAX = "Las Vegas to Los Angeles";
    public final String LAX_TO_LAS = "Los Angeles to Las Vegas";


    By totaltrip = By.xpath("//table/tbody/tr[1]/td[1]/h3");
    By titleTrips = By.cssSelector("div[data-test-id='flight-review-header'] h2[class='uitk-heading-4']");
    By checkoutbutton = By.cssSelector("button[data-test-id='goto-checkout-button']");


    /***
     * @author Rosangela
     * @description this method will validate the in formation in the checkout page.
     */

    public void validateCheckoutInformation() {
        boolean success;
        try {
            driver.navigate().refresh();
            Thread.sleep(2000);
            String totalPrice = driver.findElement(totaltrip).getText();
            String lasToAng = driver.findElements(titleTrips).get(0).getText();
            String angToLas = driver.findElements(titleTrips).get(1).getText();

           System.out.println(totalPrice + lasToAng +angToLas);

            Assert.assertEquals(true, TRIP_TOTAL.equals(totalPrice));
            Assert.assertEquals(true, LAS_TO_LAX.equals(lasToAng));
            Assert.assertEquals(true, LAX_TO_LAS.equals(angToLas));


            driver.findElement(checkoutbutton).click();


            success = true;

        } catch (Exception e) {
            success = false;
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(true, success);

    }
}

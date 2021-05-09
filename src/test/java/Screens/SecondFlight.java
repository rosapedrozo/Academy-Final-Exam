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


public class SecondFlight extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public SecondFlight(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    By returnFlight = By.cssSelector("button[data-test-id='select-link']");//select third option
    By bntContinueButton = By.cssSelector("button[data-test-id='select-button']");


    /***
     * @author Rosangela
     * @description this method will select the retuned flight.

     */


    public void selectReturnedFlight() {
        boolean success;
        try {
            WebElement scf = driver.findElements(returnFlight).get(2);
            highLight(scf, driver);
            scf.click();
            highLight(scf, driver);
            Thread.sleep(3000);
            driver.findElement(bntContinueButton).click();


            success = true;

        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement scf = driver.findElements(returnFlight).get(2);
            highLight(scf, driver);
            scf.click();
            highLight(scf, driver);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.findElement(bntContinueButton).click();

            success = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            success = false;

        }

        Assert.assertEquals(true, success);

    }

}


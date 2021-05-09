package Screens;


import Utilities.DataProvider;
import Utilities.TestUtilitie;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.ArrayList;

public class FlightSearchs extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public FlightSearchs(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);

    }


    By ddSort = By.id("listings-sort");
    By shortest = By.xpath("//[contains(@id, ‘N2E0MjViLTM0LTEtMTE1N34’)]");
    By flightResults = By.xpath("//*[@data-test-id='journey-duration']");
    By leavingoption=By.xpath("//*[@data-test-id='select-link']");
    By btnContinue = By.cssSelector("button[data-test-id='select-button']");


    /***
     * @author Rosangela
     * @description this method will validate the drop down list options.

     */
    public void dropDownListValidation() {
        boolean success;
        try {
             wait.until(ExpectedConditions.elementToBeClickable(ddSort));
             Select selectSort = new Select(driver.findElement(ddSort));
             ArrayList<WebElement> selectOptions = (ArrayList<WebElement>) selectSort.getOptions();
             for (WebElement element:selectOptions){
                 String selectValue = element.getText();

                 if(!DataProvider.getOptionsMandatories().contains(selectValue)){
                     throw new Exception("Value not found in the drop down: " +selectValue);

                 }
                 System.out.println(selectValue);
             }

             selectSort.selectByVisibleText("Duration (Shortest)");
            highLight(selectSort.getFirstSelectedOption(), driver);

            success = true;

        } catch (Exception e) {
            success = false;
            System.out.println(e.getMessage());
                    }
                        Assert.assertEquals(true, success);

    }

    /***
     * @author Rosangela
     * @description this method will verify the shortest flight.

     */
    public void shortestFlightValidation() {
        boolean success;
        try {
            String optionOne = driver.findElements(flightResults).get(0).getText();
            String optionTwo = driver.findElements(flightResults).get(1).getText();
            System.out.println(optionOne+optionTwo);
            if (!TestUtilitie.validSortestReuslt(optionOne,optionTwo)){
                throw new Exception("First flight is not the shortest one");

            }
            highLight(driver.findElements(leavingoption).get(0),driver);
            Thread.sleep(3000);
            driver.findElements(leavingoption).get(0).click();
            wait.until(ExpectedConditions.elementToBeClickable(btnContinue));
            driver.findElement(btnContinue).click();
            success = true;

            } catch (Exception e) {
                success = false;
                System.out.println(e.getMessage());
            }
            Assert.assertEquals(true, success);

        }
    }



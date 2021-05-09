package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WhoiSTraveling extends BasePage {
    String firstNameError ="Please enter a first name using letters only.";
    String middleNameError ="Please enter a middle name using letters only.";
    String lastNameError ="Please enter a last name using letters only (minimum 2 characters).";
    String phoneNumberError ="Please enter a valid phone number.";
    String monthError ="Please select a valid date of birth.";

    WebDriver driver;
    WebDriverWait wait;

    public WhoiSTraveling(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);

    }

    By firstName = By.xpath("//*[@id=\"firstname[0]\"]");
    By middleName = By.xpath("//*[@id=\"middlename[0]\"]");
    By lastName = By.xpath("//*[@id=\"lastname[0]\"]");
    By phoneNumber = By.xpath("//*[@id=\"phone-number[0]\"]");
    By monthButton = By.cssSelector("select[name='tripPreferencesRequest.airTripPreferencesRequest.travelerPreferences[0].dateOfBirth.month']");
    By maleButton = By.xpath("//*[@id=\"gender_male[0]\"]");

    /***
     * @author Rosangela
     * @description this method will fill the who is traveling information.

     */
    public void fillData() {
        boolean success;
        try {

            System.out.println("Inside filled data");
            WebElement firstNameInput = driver.findElement(firstName);
            highLight(firstNameInput,driver);
            Thread.sleep(5000);
            firstNameInput.sendKeys("47874");
            driver.findElement(middleName).sendKeys("47893");
            driver.findElement(lastName).sendKeys("221452");
            driver.findElement(phoneNumber).sendKeys("rrrrew");
            driver.findElement(monthButton).click();
            driver.findElement(maleButton).click();
            System.out.println("Output filled data");

        } catch (Exception e) {
            success = false;
            System.out.println(e.getMessage());
        }
    }

    /***
     * @author Rosangela
     * @description this method will validate who is traveling filled information.

     */
    public void errorMessagesValidation() {
        boolean success;
        try {
            System.out.println("Validate Message");
            Assert.assertEquals(true,firstNameError.equals(driver.findElements(By.xpath("//*[@id=\"preferences\"]/form/fieldset/fieldset/div/fieldset[1]/label[1]/p")).get(0).getText()));
            Assert.assertEquals(true,middleNameError.equals(driver.findElements(By.xpath("//*[@id=\"preferences\"]/form/fieldset/fieldset/div/fieldset[1]/label[2]/p")).get(0).getText()));
            Assert.assertEquals(true,lastNameError.equals(driver.findElements(By.xpath("//*[@id=\"preferences\"]/form/fieldset/fieldset/div/fieldset[1]/label[3]/p")).get(0).getText()));
            Assert.assertEquals(true,phoneNumberError.equals(driver.findElements(By.xpath("//*[@id=\"preferences\"]/form/fieldset/fieldset/div/label[2]/p")).get(0).getText()));
            Assert.assertEquals(true,monthError.equals(driver.findElements(By.xpath("//*[@id=\"preferences\"]/form/fieldset/fieldset/div/fieldset[3]/legend/p")).get(0).getText()));
            System.out.println("Error message validations");
            success = true;

        } catch (Exception e) {
            success = false;
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(true, success);

    }
}
package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.assertTrue;

public class ContactUsSteps {
    private WebDriver driver;

    @Given("I am on the contact us page")
    public void i_am_on_the_contact_us_page() {
        // Setup ChromeOptions first
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        
        // Create driver with options
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://jignect.tech/contact-us/");
    }

    @When("I fill in the contact us form with valid details")
    public void i_fill_in_the_contact_us_form_with_valid_details() {
        WebElement textArea = driver.findElement(By.xpath("//span//textarea[contains(@name,'textarea')]"));
        textArea.sendKeys("I want to learn automation");

        WebElement fullNameInput = driver.findElement(By.xpath("//input[@placeholder='Full name']"));
        fullNameInput.sendKeys("Aarti Lodha");

        WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='Work email address']"));
        emailInput.sendKeys("arati@jignect.tech");

        WebElement companyInput = driver.findElement(By.xpath("//input[@placeholder='Company']"));
        companyInput.sendKeys("Jignect Technologies Pvt.Ltd");

        WebElement phoneInput = driver.findElement(By.xpath("//input[@placeholder='Phone number']"));
        phoneInput.sendKeys("9874563210");
    }

    @When("I submit the contact us form")
    public void i_submit_the_contact_us_form() {
        WebElement iAgreeCheckbox = driver.findElement(By.xpath("//p//span[contains(@class,'first last')]//input"));
        iAgreeCheckbox.click();
        WebElement submitButton = driver.findElement(By.xpath("//p//input[@type='submit']"));
        submitButton.click();
    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() throws InterruptedException {
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(@class,'response-output')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", successMessage);
        Thread.sleep(1000);
        assertTrue(successMessage.isDisplayed());

        // Close the browser
        driver.quit();
    }
}
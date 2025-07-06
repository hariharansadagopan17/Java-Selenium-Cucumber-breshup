package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.time.Duration;

public class ContactUsSteps {
    private WebDriver driver;

    @Given("I am on the contact us page")
    public void i_am_on_the_contact_us_page() {
        // Setup ChromeOptions first
        ChromeOptions options = new ChromeOptions();
        
        // Add CI-friendly arguments
        options.addArguments("--headless");  // Run in headless mode for CI
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");  // Set a specific window size
        
        // Create a unique temporary directory for user data
        String tempDir = System.getProperty("java.io.tmpdir");
        String userDataDir = new File(tempDir, "chrome-test-" + System.currentTimeMillis()).getAbsolutePath();
        options.addArguments("--user-data-dir=" + userDataDir);
        
        // Create driver with options
        driver = new ChromeDriver(options);
        driver.get("https://jignect.tech/contact-us/");
    }

    @When("I fill in the contact us form with valid details")
    public void i_fill_in_the_contact_us_form_with_valid_details() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement textArea = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span//textarea[contains(@name,'textarea')]")));
        textArea.sendKeys("I want to learn automation");

        WebElement fullNameInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Full name']")));
        fullNameInput.sendKeys("Aarti Lodha");

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Work email address']")));
        emailInput.sendKeys("arati@jignect.tech");

        WebElement companyInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Company']")));
        companyInput.sendKeys("Jignect Technologies Pvt.Ltd");

        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Phone number']")));
        phoneInput.sendKeys("9874563210");
    }

    @When("I submit the contact us form")
    public void i_submit_the_contact_us_form() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement iAgreeCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p//span[contains(@class,'first last')]//input")));
        iAgreeCheckbox.click();
        
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p//input[@type='submit']")));
        submitButton.click();
    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'response-output')]")));
            
            // Scroll to the element
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", successMessage);
            
            // Wait for element to be visible
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            
            assertTrue("Success message should be displayed", successMessage.isDisplayed());
        } finally {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
            
            // Clean up the temporary user data directory
            try {
                File userDataDir = new File(System.getProperty("java.io.tmpdir"), "chrome-test-*");
                if (userDataDir.exists()) {
                    userDataDir.delete();
                }
            } catch (Exception e) {
                // Ignore cleanup errors
            }
        }
    }
}
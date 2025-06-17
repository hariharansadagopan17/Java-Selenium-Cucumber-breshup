import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumJava_Test {

    @Test
    public void myFirstSeleniumTest() {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver_Exe\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Navigate to a website
        driver.get("https://www.amazon.in");

        // Perform actions, such as finding elements and interacting with them
        // ...

        // Close the browser
        driver.quit();
    }
}

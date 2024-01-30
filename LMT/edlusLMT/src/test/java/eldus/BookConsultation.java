package eldus;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BookConsultation {

    private static final Logger logger = LoggerFactory.getLogger(BookConsultation.class);

    /**
     * 1) Launch the web browser and open the application under test – https://edlus.lmt.lv/
     * 2) Verify the web page title
     * 3) Click on the “Funkcijas” hyperlink
     * 4) Navigate back to the original web page
     * 5) Verify if the “Pieteikties konsultācijai” button is displayed
     * 6) Based on visibility of the “Pieteikties konsultācijai” button, click on it
     * 7) Fill the form with test data
     */
    @Test
    public void bookConsultationTest() {
        String driverPath = System.getProperty("webdriver.chrome.driver");

        if (driverPath == null) {
            driverPath = "C:\\DEV\\chromedriver-win32\\chromedriver.exe";
        }

        System.setProperty("webdriver.chrome.driver", driverPath);

        logger.info("Launch the web browser and open the application under test – https://edlus.lmt.lv/");
        WebDriver driver = new ChromeDriver();
        driver.get("https://edlus.lmt.lv/");

        logger.info("Wait for the page to load");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-cookie-approve='all']")));

        WebElement approveCoockie = driver.findElement(By.cssSelector("[data-cookie-approve='all']"));
        if (approveCoockie != null) {
            approveCoockie.click();
        }

        String pageTitle = driver.getTitle();
        String expectedTitle = "LMT elektroniskā darbalaika uzskaite – EDLUS";

        logger.info("Verify the web page title");
        Assert.assertEquals("Page title does not match", expectedTitle, pageTitle);

        logger.info("Click on the “Funkcijas” hyperlink");
        WebElement navigationButton = driver.findElement(By.id("funkcijas"));
        navigationButton.click();

        logger.info("Navigate back to the original web page");
        navigationButton = driver.findElement(By.cssSelector("#menu-biznesam-1>[data-id='sakums']"));
        navigationButton.click();


        logger.info("Verify if the “Pieteikties konsultācijai” button is displayed");
        WebElement sectionElement = driver.findElement(By.id("sakums"));
        List<WebElement> bookingButton = sectionElement.findElements(By.id("kas-ir-edlus-pieteikties"));

        try {
            if (bookingButton.isEmpty()) {
                System.out.println("Button 'Pieteikties konsultācijai' are not displayed");
            } else {
                navigationButton = driver.findElement(By.id("kas-ir-edlus-pieteikties"));
                navigationButton.click();
            }

        } finally {
            driver.quit();
        }
    }
}
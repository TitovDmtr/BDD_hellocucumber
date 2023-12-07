package hellocucumber;

import java.time.Duration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class StepsDefWebsiteSearch {

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("prepare browser")
    public void prepareBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize(); // open full size window
    }

    @When("search website by name using google search")
    public void searchSomeElements() throws InterruptedException {
        driver.get("https://www.google.com/?hl=en-US");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElements(By.className("gNO89b")).get(1).click();
        wait.until(titleIs("webdriver - Google Search"));
    }

    @Then("check first website in the response list")
    public void checkFirstElement() {
        Assertions.assertEquals(driver.getTitle(), "webdriver - Google Search", "fail_666");
        driver.quit();
    }
}

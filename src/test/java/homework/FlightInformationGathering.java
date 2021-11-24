package homework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightInformationGathering {

    //LOCATORS:
    private WebDriver browser;
    private final String HOME_PAGE = "http://www.united.com";
    private final By ONE_WAY_BUTTON = By.xpath(".//*[@id = 'oneway']");
    private final By REMOVE_FROM = By.xpath(".//*[contains(@class, '__clearButton--')]");
    private final By FROM_DEST = By.id("bookFlightOriginInput");
    private final By TO_DEST = By.id("bookFlightDestinationInput");
    private final By AUTOCOMPLETE_ITEM = By.xpath("//*[@id=\"autocomplete-item-0\"]/button");
    private final By DEPART_DATE = By.id("DepartDate");


    @Test
    public void criteriaSort() {

        //DRIVER LAUNCH:
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.manage().window().maximize();
        //Navigate to the main page
        browser.get(HOME_PAGE);
        //Choose one-way ticket type
        browser.findElement(ONE_WAY_BUTTON).click();
        //Set the right destination FROM
        browser.findElement(FROM_DEST).click();
        browser.findElement(REMOVE_FROM).click();
        browser.findElement(FROM_DEST).sendKeys("New York JFK");
        //Set the right destination TO
        browser.findElement(TO_DEST).click();
        browser.findElement(TO_DEST).sendKeys("Miami");
        wait.until(ExpectedConditions.elementToBeClickable(AUTOCOMPLETE_ITEM)).click();
        //Choose departure date
        browser.findElement(DEPART_DATE).click();

        }
    }

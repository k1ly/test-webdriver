package by.belstu.it.lyskov.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NvidiaDriversPage extends AbstractPage {
    public static final String SEARCH_PAGE_URL = "https://www.nvidia.com/ru-ru/geforce/drivers/";

    @FindBy(id = "languagebutton-ru")
    private WebElement localePromptRuButton;

    private By productParamLocator = By.id("manualSearch-0-button");
    private By productListLocator = By.cssSelector("ul#manualSearch-0-menu li");
    private String productListElementLocatorPart = "//ul[@id='manualSearch-0-menu']/li[text()='";

    private By seriesParamLocator = By.id("manualSearch-1-button");
    private By seriesListLocator = By.cssSelector("ul#manualSearch-1-menu li");
    private String seriesListElementLocatorPart = "//ul[@id='manualSearch-1-menu']/li[text()='";

    private String defaultModelParamTextLocator = "//span[@id='manualSearch-2-button']/span[@class='ui-selectmenu-text' and text()='";
    private String defaultModelParam_GeForceRTX3090Ti = "GeForce RTX 3090 Ti";
    private String defaultModelParam_GeForceGTX980 = "GeForce GTX 980";
    private By modelParamLocator = By.id("manualSearch-2-button");
    private By modelListLocator = By.cssSelector("ul#manualSearch-2-menu li");
    private String modelListElementLocatorPart = "//ul[@id='manualSearch-2-menu']/li[text()='";

    private By osParamLocator = By.id("manualSearch-4-button");
    private By osListLocator = By.cssSelector("ul#manualSearch-4-menu li");
    private String osListElementLocatorPart = "//ul[@id='manualSearch-4-menu']/li[text()='";

    private By langParamLocator = By.id("manualSearch-5-button");
    private By langListLocator = By.cssSelector("ul#manualSearch-5-menu li");
    private String langListElementLocatorPart = "//ul[@id='manualSearch-5-menu']/li[text()='";

    private By typeParamLocator = By.id("driverType-button");
    private By typeListLocator = By.cssSelector("ul#driverType-menu li");
    private String typeListElementLocatorPart = "//ul[@id='driverType-menu']/li[text()='";

    private By searchButton = By.id("manualSearchButton");

    public NvidiaDriversPage(WebDriver webDriver) {
        super(webDriver);
    }

    public NvidiaDriversPage openPage() {
        webDriver.get(SEARCH_PAGE_URL);
        return this;
    }

    public NvidiaDriversPage selectPageLocaleRu() {
        new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(localePromptRuButton));
        localePromptRuButton.click();
        return this;
    }

    public NvidiaDriversPage selectProduct(String product) {
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(productParamLocator));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);javascript:window.scrollBy(0,-100);",
                webDriver.findElement(productParamLocator));
        webDriver.findElement(productParamLocator).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(productListLocator));
        webDriver.findElement(By.xpath(productListElementLocatorPart + product + "']")).click();
        return this;
    }

    public NvidiaDriversPage selectSeries(String series) {
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(seriesParamLocator));
        webDriver.findElement(seriesParamLocator).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(seriesListLocator));
        webDriver.findElement(By.xpath(seriesListElementLocatorPart + series + "']")).click();
        return this;
    }

    public NvidiaDriversPage selectModel(String model) {
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.and(ExpectedConditions.or(
                                ExpectedConditions.presenceOfElementLocated(
                                        By.xpath(defaultModelParamTextLocator + defaultModelParam_GeForceRTX3090Ti + "']")),
                                ExpectedConditions.presenceOfElementLocated(
                                        By.xpath(defaultModelParamTextLocator + defaultModelParam_GeForceGTX980 + "']"))),
                        ExpectedConditions.elementToBeClickable(modelParamLocator)));
        webDriver.findElement(modelParamLocator).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(modelListLocator));
        webDriver.findElement(By.xpath(modelListElementLocatorPart + model + "']")).click();
        return this;
    }

    public NvidiaDriversPage selectOS(String os) {
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(osParamLocator));
        webDriver.findElement(osParamLocator).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(osListLocator));
        webDriver.findElement(By.xpath(osListElementLocatorPart + os + "']")).click();
        return this;
    }

    public NvidiaDriversPage selectLang(String lang) {
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(langParamLocator));
        webDriver.findElement(langParamLocator).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(langListLocator));
        webDriver.findElement(By.xpath(langListElementLocatorPart + lang + "']")).click();
        return this;
    }

    public NvidiaDriversPage selectType(String type) {
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(typeParamLocator));
        webDriver.findElement(typeParamLocator).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(typeListLocator));
        webDriver.findElement(By.xpath(typeListElementLocatorPart + type + "']")).click();
        return this;
    }

    public NvidiaDriversSearchResultsPage searchForDrivers() {
        new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(searchButton));
        webDriver.findElement(searchButton).click();
        return new NvidiaDriversSearchResultsPage(webDriver);
    }
}

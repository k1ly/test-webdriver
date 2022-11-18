package by.belstu.it.lyskov;

import by.belstu.it.lyskov.pageobject.NvidiaDriversPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WebDriverPageObjectTest {

    private WebDriver webDriver;

    @BeforeEach
    void initBrowser() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    void commonDriverParamsShouldReturnResults() {
        int searchDriversResultNumber = new NvidiaDriversPage(webDriver)
                .openPage()
                .selectPageLocaleRu()
                .selectProduct("GeForce")
                .selectSeries("GeForce RTX 30 Series")
                .selectModel("GeForce RTX 3090")
                .selectOS("Windows 10 64-bit")
                .selectLang("Japanese")
                .selectType("Драйвер Game Ready ")
                .searchForDrivers()
                .countResultNumber();
        assertTrue(searchDriversResultNumber > 0, "Search drivers results are empty");
    }

    @Test
    void ineligibleDriverParamsShouldReturnEmptyResults() {
        int searchDriversResultNumber = new NvidiaDriversPage(webDriver)
                .openPage()
                .selectPageLocaleRu()
                .selectProduct("GeForce")
                .selectSeries("GeForce 900M Series (Notebooks)")
                .selectModel("GeForce GTX 950M")
                .selectOS("FreeBSD x86")
                .selectLang("Polski")
                .selectType("Драйверы для Linux с краткосрочной поддержкой")
                .searchForDrivers()
                .countResultNumber();
        assertFalse(searchDriversResultNumber > 0, "Search results are not empty");
    }

    @AfterEach
    void closeBrowser() {
        webDriver.quit();
        webDriver = null;
    }
}

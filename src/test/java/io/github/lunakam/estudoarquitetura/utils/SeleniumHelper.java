package io.github.lunakam.estudoarquitetura.utils;

import io.github.lunakam.estudoarquitetura.drivers.WebDriverContext;
import lombok.Getter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumHelper {

    @Getter
    private final WebDriver driver;
    @Getter
    private final Wait<WebDriver> driverWait;

    public SeleniumHelper(final WebDriverContext webDriverContext) {
        this.driver = webDriverContext.getDriver();
        this.driverWait = webDriverContext.getDriverWait();
    }


    public List<WebElement> findElements(final By by) { return this.driver.findElements(by); }

    public boolean isElementPresent(final By by) {
        return this.driver.findElements(by).size() > 0;
    }

    public boolean isElementPresent(final WebElement element) {
        try {
            element.getTagName();
        } catch (final NoSuchElementException ignored) {
            return false;
        } catch (final StaleElementReferenceException ignored) {
            return false;
        }
        return true;
    }

    public boolean isElementVisible(final By by) {
        return this.driver.findElement(by).isDisplayed();
    }

    public boolean isElementVisible(final WebElement element) {
        return element.isDisplayed();
    }

    public boolean isAnyTextPresent(final By by) {
        final String text = this.driver.findElement(by).getText();
        return StringUtils.isNotBlank(text);
    }

    public boolean isAnyTextPresent(final WebElement element) {
        final String text = element.getText();
        return StringUtils.isNotBlank(text);
    }

    public WebElement waitForElement(final WebElement element) {
        return driverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElement(final WebElement element, final int timeoutInSeconds) {
        final WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElement(final By by) {
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElement(final By by, final int timeoutInSeconds) {
        final WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementIsInvisible(final By by) {
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForTextToAppear(final String textToAppear, final WebElement element) {
        driverWait.until(ExpectedConditions.textToBePresentInElement(element, textToAppear));
    }

    public void waitForUrlPart(final String urlPart) {
        driverWait.until(ExpectedConditions.urlContains(urlPart));
    }

    public WebElement waitForPageLoad() {
        return waitForElement(By.tagName("html"));
    }

    public WebElement waitForPageLoad(final int timeoutInSeconds) {
        return waitForElement(By.tagName("html"), timeoutInSeconds);
    }

    public Optional<String> xpathFinder(final String... xpathList) {
        for (final String xpath : xpathList) {
            if (isElementPresent(By.xpath(xpath))) {
                return Optional.of(xpath);
            }
        }
        return Optional.empty();
    }

    public void mouseover(final By by) {
        final WebElement element = this.driver.findElement(by);
        final Actions builder = new Actions(this.driver);
        final Action mouseover = builder.moveToElement(element).build();
        mouseover.perform();
    }

    public void mouseover(final WebElement element) {
        final Actions builder = new Actions(this.driver);
        final Action mouseover = builder.moveToElement(element).build();
        mouseover.perform();
    }

    public void moveToElement(final By by) {
        mouseover(by);
    }

    public void moveToElement(final WebElement element) {
        mouseover(element);
    }

    public void waitAndMoveToElement(final WebElement element) {
        waitForElement(element);
        moveToElement(element);
    }

    public void waitAndMoveToElement(final By by) {
        waitForElement(by);
        moveToElement(by);
    }

    public void dragAndDrop(final By by, final int xOffset, final int yOffset) {
        final WebElement ele = this.driver.findElement(by);
        final Actions builder = new Actions(this.driver);
        final Action dragAndDrop = builder.clickAndHold(ele).moveByOffset(xOffset, yOffset).release().build();
        dragAndDrop.perform();
    }

    public void dragAndDrop(final WebElement element, final int xOffset, final int yOffset) {
        final Actions builder = new Actions(this.driver);
        final Action dragAndDrop = builder.clickAndHold(element).moveByOffset(xOffset, yOffset).release().build();
        dragAndDrop.perform();
    }

    public void switchWindow(final String url) {
        sleep(2000);
        String currentHandle = null;
        final Set<String> handles = this.driver.getWindowHandles();
        if (handles.size() > 1) {
            currentHandle = this.driver.getWindowHandle();
        }
        if (currentHandle != null) {
            for (final String handle : handles) {
                this.driver.switchTo().window(handle);
                if (this.driver.getCurrentUrl().contains(url) && !currentHandle.equals(handle)) {
                    break;
                }
            }
        } else {
            for (final String handle : handles) {
                this.driver.switchTo().window(handle);
                if (this.driver.getCurrentUrl().contains(url)) {
                    break;
                }
            }
        }
    }

    public boolean isReadonly(final By by) {
        return Boolean.parseBoolean(this.driver.findElement(by).getAttribute("readonly"));
    }

    public boolean isReadonly(final WebElement element) {
        return Boolean.parseBoolean(element.getAttribute("readonly"));
    }

    public Point getElementPosition(final WebElement element) {
        return element.getLocation();
    }

    public int getElementPositionX(final WebElement element) {
        final Point pos = getElementPosition(element);
        return pos.getX();
    }

    public int getElementPositionY(final WebElement element) {
        final Point pos = getElementPosition(element);
        return pos.getY();
    }

    public void backSpaceInputClear(final WebElement element) {
        final int numberOfCharacters = element.getAttribute("value").length();
        for (int i = 0; i <= numberOfCharacters; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void backSpaceInputClear(final WebElement element, final int numberOfCharacters) {
        for (int i = 0; i <= numberOfCharacters; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void scroll(final int x, final int y) {
        final JavascriptExecutor js = (JavascriptExecutor) this.driver;
        for (int i = 0; i <= x; i = i + 50) {
            js.executeScript("scroll(" + i + ",0)");
        }
        for (int j = 0; j <= y; j = j + 50) {
            js.executeScript("scroll(0," + j + ")");
        }
    }

    public JavascriptExecutor highlightElementPermanently(final WebElement element) {
        final JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        return js;
    }

    public void highlightElement(final WebElement element) {
        final String originalStyle = element.getAttribute("style");
        final JavascriptExecutor js = highlightElementPermanently(element);
        sleep(3000);
        js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
    }

    public void zoomPlus() {
        Actions actions = new Actions(this.driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ADD).perform();
        actions = new Actions(this.driver);
        actions.keyUp(Keys.CONTROL).perform();
    }

    public void zoomMinus() {
        Actions actions = new Actions(this.driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).perform();
        actions = new Actions(this.driver);
        actions.keyUp(Keys.CONTROL).perform();
    }

    public void takeScreenshot(final String path) {
        final File scrFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isAlertPresent() {
        try {
            final Alert alert = this.driver.switchTo().alert();
            alert.getText();
        } catch (final NoAlertPresentException nape) {
            return false;
        }
        return true;
    }

    public String getAlertText() {
        final Alert alert = this.driver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlert() {
        final Alert alert = this.driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        final Alert alert = this.driver.switchTo().alert();
        alert.dismiss();
    }

    private void sleep(int millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

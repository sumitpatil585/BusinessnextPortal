package com.dap.qa.utils;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dap.qa.base.BaseTest;



public class ActionUtilities extends BaseTest
{

    private Actions actions;
    private WebDriverWait wait;
    Select select;
    WebDriver driver;

    // 
    public ActionUtilities(WebDriver driver) 
    {
    	this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ================= Mouse Actions =================

    // Mouse Hover
    public void mouseHover(WebElement element) 
    {
        actions.moveToElement(element).build().perform();
    }
    public void mouseOverAndClick(WebElement hoverElement, WebElement clickElement) 
    {

        // wait for hover element
        wait.until(ExpectedConditions.visibilityOf(hoverElement));

        // hover
        actions.moveToElement(hoverElement).perform();

        // wait for click element
        wait.until(ExpectedConditions.elementToBeClickable(clickElement));

        // click
        clickElement.click();
    }
    public void mouseclick(WebElement element)
    {
    	actions.moveToElement(element).click().build().perform();
    }

	/*
	 * public void dropdownselect(WebElement element, String value) {
	 * 
	 * Select select = new Select(element); select.selectByVisibleText(value); }
	 */
    
    public void dropdownselect(WebElement element, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait until element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(element));

            Select select = new Select(element);
            select.selectByVisibleText(value);

        } catch (StaleElementReferenceException e) {
            // Retry once if DOM refreshed
            WebElement refreshedElement = wait.until(
                ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(element)
                )
            );

            Select select = new Select(refreshedElement);
            select.selectByVisibleText(value);

        } catch (NoSuchElementException e) {
            throw new RuntimeException("Dropdown value not found: " + value);
        }
    }
    public void scrolldown(WebElement assigned_to_button) 
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", assigned_to_button);
    	
    	//JavascriptExecutor js = (JavascriptExecutor) driver;
    	//js.executeScript("window.scrollBy({top: 500, behavior: 'smooth'});");
    }
    
}
package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By desktopTab = By.linkText("Desktops");
    By desktopText = By.xpath("//h2[contains(text(),'Desktops')]");
    By laptopsAndNotebooks = By.linkText("Laptops & Notebooks");
    By laptopsAndNotebooksText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By components = By.linkText("Components");
    By componentsText = By.xpath("//h2[contains(text(),'Components')]");


    public void clickOnDesktopTab() {
        mouseHoverToElementAndClick(desktopTab);
    }
    public String verifyTextDesktop() {
        return getTextFromElement(desktopText);
    }
    public void clickOnLaptopsAndNotebooksTab() {
        mouseHoverToElementAndClick(laptopsAndNotebooks);
    }
    public String verifyTextLaptopsAndNotebooks() {
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public void clickOnComponentsTab() {
        mouseHoverToElementAndClick(components);
    }
    public String verifyTextComponents() {
        return getTextFromElement(componentsText);
    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }


    }
}

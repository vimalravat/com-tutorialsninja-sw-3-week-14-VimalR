package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utility {
By desktopTab= By.linkText("Desktops");
By desktopElement= By.linkText("Show All Desktops");
By sortOrderByAToZ= By.id("input-sort");
By selectProduct=  By.xpath("//a[contains(text(),'HP LP3065')]");
By productText= By.xpath("//h1[contains(text(),'HP LP3065')]");
By addToCartTab= By.xpath("//button[@id='button-cart']");
By successfullyAddedToCartText= By.xpath("//div[@id='content']//h1");
By clickOnMessageBanner= By.xpath("//a[contains(text(),'shopping cart')]");
By productNameDisplayed= By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]");
By deliveryDate= By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");
By productModel= By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");
By orderTotal= By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");

    public void verifyProductArrangeInDescendingOrder(){
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
    }
    public void hoverAndClickOnDesktopsTab() {
        mouseHoverToElement(desktopTab);
        clickOnElement(desktopElement);
    }
    public void setSortOrderByAToZ(){
        selectByVisibleTextFromDropDown(sortOrderByAToZ,"Name (A - Z)");
    }
    public void selectYourCurrency(){
        clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e:currencyList ) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")){
                e.click();
                break;
            }
        }
    }
    public void setSelectProduct(){
        clickOnElement(selectProduct);
    }
    public String getProductText(){
        return getTextFromElement(productText);
    }
    public void pickDate(){
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }
    public void addProductToCart (){
        clickOnElement(addToCartTab);
    }
    public void goToCartByClickOnBanner(){
        clickOnElement(clickOnMessageBanner);
    }
    public String productAddedToCartDisplayed(){
        return getTextFromElement(successfullyAddedToCartText);
    }
    public String verifyProductNameDisplayed(){
        return getTextFromElement(productNameDisplayed);}
    public String verifyDeliveryDate(){
        return getTextFromElement(deliveryDate);}
    public String verifyProductModel(){
        return getTextFromElement(productModel);}
    public String verifyOrderTotal(){
        return getTextFromElement(orderTotal);}

}

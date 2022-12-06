package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {
    By laptopsAndNotebooksTab= By.linkText("Laptops & Notebooks");
    By allLaptopsAndNotebooksOptionFromTab= By.linkText("Show All Laptops & Notebooks");
    By sortByTab= By.xpath("//select[@id='input-sort']");
    By productMacBookTab= By.linkText("MacBook");
    By productMacBookText= By.xpath("//h1[contains(text(),'MacBook')]");
    By addToCartTab= By.xpath("//button[@id='button-cart']");
    By cartSuccessfullyAdded= By.xpath("//div[contains(text(),'Success: You have added ')]");
    By shoppingCartInSuccessMessage= By.xpath("//a[contains(text(),'shopping cart')]");
    By shoppingCartTextInBasket= By.xpath("//a[contains(text(),'Shopping Cart')]");
    By macBookTextInCart= By.xpath("//a[contains(text(),'Shopping Cart')]");
    By updateTab= By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]");
    By quantityUpdateSuccess= By.xpath("//body/div[@id='checkout-cart']/div[1]");
    By basketTotal= By.xpath("//td[contains(text(),'£737.45')]");
    By checkoutButton= By.xpath("//a[contains(text(),'Checkout')]");
    By checkoutText= By.xpath("//h1[contains(text(),'Checkout')]");
    By newCustomerText= By.xpath("//h2[contains(text(),'New Customer')]");
    By guestCheckoutRadioButton= By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]");
    By continueTab= By.xpath("//input[@id='button-account']");
    By firstNameField= By.name("firstname");
    By lastNameField= By.name("lastname");
    By emailField= By.id("input-payment-email");
    By telephoneField= By.name("telephone");
    By addressField= By.name("address_1");
    By cityField= By.name("city");
    By postcodeField= By.name("postcode");
    By paymentCountryField= By.id("input-payment-country");
    By selectYourCountry= By.xpath("//option[contains(text(),'United Kingdom')]");
    By inputPaymentZone= By.id("input-payment-zone");
    By selectYourRegion= By.xpath("//option[contains(text(),'Greater London')]");
    By mandatoryFieldContinueTab= By.xpath("//input[@id='button-register']");
    By commentsSection= By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]");
    By termsAndConditionCheckBox= By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]");
    By continueTabInPaymentMethod= By.xpath("//input[@id='button-payment-method']");
    By warningMessagePaymentMethod= By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]");



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
    public void hoverOnLaptopsAndNotebooks(){
        mouseHoverToElement(laptopsAndNotebooksTab);
    }
    public void hoverAndClickOnLaptopsAndNotebooks(){
        mouseHoverToElementAndClick(allLaptopsAndNotebooksOptionFromTab);
    }
    public void arrangeProductsHighToLow(){
        clickOnElement(sortByTab);
         selectByVisibleTextFromDropDown(sortByTab,"Price (High > Low)");
    }
    public void selectProductMacBook(){
        clickOnElement(productMacBookTab);
    }
    public String verifyTheTextMacBook(){
      return getTextFromElement(productMacBookText);
    }
    public void clickOnAddToCartTab(){
        clickOnElement(addToCartTab);
    }
    public String verifyTheMessageAfterAddToCart(){
        return getTextFromElement(cartSuccessfullyAdded);
    }
    public void clickOnLinkShoppingCart(){
        clickOnElement(shoppingCartInSuccessMessage);
    }
    public String verifyShoppingCart() {
        return getTextFromElement(shoppingCartTextInBasket);
    }
    public String verifyMacBookText() {
        return getTextFromElement(macBookTextInCart);
    }
    public void changeQuantity(){
        Actions actions= new Actions(driver);
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
        actions.sendKeys(Keys.BACK_SPACE).perform();
        actions.sendKeys(Keys.DELETE).perform();
        actions.sendKeys("2").perform();
    }
    public void clickOnUpdateTab(){
        clickOnElement(updateTab);
    }
    public String verifyBasketQuantityUpdateSuccess() {
        return getTextFromElement(quantityUpdateSuccess);
    }
    public String verifyBasketItemTotal() {
        return getTextFromElement(basketTotal);
    }
    public void clickOnCheckoutButton(){
        clickOnElement(checkoutButton);
    }
    public String verifyCheckoutText() {
        return getTextFromElement(checkoutText);
    }
    public String verifyNewCustomerText() {
        return getTextFromElement(newCustomerText);
    }
    public void clickOnGuestCheckoutRadioButton(){
        clickOnElement(guestCheckoutRadioButton);
    }
    public void clickOnContinue(){
        clickOnElement(continueTab);
    }
    public void enterFirstName(){
        sendTextToElement(firstNameField,"ABCD");
    }
    public void enterLastName(){
        sendTextToElement(lastNameField,"WXYZ");
    }
    public void enterEmail(){
        sendTextToElement(emailField,"Abcdwxyz@gmail.com");
    }
    public void enterTelephoneNumber(){
        sendTextToElement(telephoneField,"01234567890");
    }
    public void enterAddress(){
        sendTextToElement(addressField,"420 Roop Mahal");
    }
    public void enterCityField(){
        sendTextToElement(cityField,"London");
    }
    public void enterPostcode(){
        sendTextToElement(postcodeField,"NW12TT");
    }
    public void enterCountryFromList(){
        clickOnElement(paymentCountryField);
        clickOnElement(selectYourCountry);
    }
    public void selectPaymentZone(){
        clickOnElement(inputPaymentZone);
        clickOnElement(selectYourRegion);
    }
    public void selectContinueTab(){
        clickOnElement(mandatoryFieldContinueTab);
    }
    public void insertYourComments(){
        sendTextToElement(commentsSection, "Thank you");
    }
    public void checkCheckBoxTermsAndConditions(){
        clickOnElement(termsAndConditionCheckBox);
    }
    public void selectContinueTab2(){
        clickOnElement(continueTabInPaymentMethod);
    }
    public String verifyPaymentMethodRequiredMessage() {
        return getTextFromElement(warningMessagePaymentMethod);
    }

 public void verifyProductListGetArrangeHighToLow(){
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        // Select sort by Price (High > Low)
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (Low > High)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(afterSortByPrice);
         }

}

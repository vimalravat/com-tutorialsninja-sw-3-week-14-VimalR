package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountsPage extends Utility {
    By myAccount= By.xpath("//span[contains(text(),'My Account')]");
    By registerAccount= By.xpath("//h1[contains(text(),'Register Account')]");
    By returningCustomer= By.xpath("//h2[contains(text(),'Returning Customer')]");
    By firstNameField= By.id("input-firstname");
    By lastNameField= By.id("input-lastname");
    By emailField= By.id("input-email");
    By telephoneField= By.name("telephone");
    By passwordField= By.id("input-password");
    By confirmPasswordField= By.id("input-confirm");
    By privacyPolicyCheckBox=By.xpath("//div[@class = 'buttons']//input[@name='agree']");
    By continueRegister=By.xpath("//div[@class = 'buttons']//input[@value='Continue']");
    By accountHasBeenCreated= By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    By continueRegister2= By.xpath("//a[contains(text(),'Continue')]");
    By myAccountLink= By.xpath("//span[contains(text(),'My Account')]");
    By accountLogoutLink= By.xpath("//h1[contains(text(),'Account Logout')]");
    By continueLinkBottom= By.xpath("//a[contains(text(),'Continue')]");
    By loginLink= By.xpath("//form[contains(@action,'login')]//input[@type='submit']");
    By myAccountLinkLoginPage= By.xpath("//span[contains(text(),'My Account')]");

    public void clickOnMyAccountTab(){
        clickOnElement(myAccount);
    }
    public String verifyTextRegisterCustomer() {
        return getTextFromElement(registerAccount);
    }
    public String verifyTextReturningCustomer() {
        return getTextFromElement(returningCustomer);
    }
    public void enterFirstName(String firstName){
        sendTextToElement(firstNameField,firstName);
    }
    public void enterLastName(String lastName){
        sendTextToElement(lastNameField,lastName);
    }
    public void enterEmail(String emailID){
        sendTextToElement(emailField, emailID);
    }
    public void enterTelephoneNumber(String phoneNumber){
        sendTextToElement(telephoneField,phoneNumber);
    }
    public void enterPassword(String password){
        sendTextToElement(passwordField,password);
    }
    public void enterConfirmPassword(String confirmPassword){
        sendTextToElement(confirmPasswordField,confirmPassword);
    }
    public void clickOnPrivacyPolicyCheckBox(){
        clickOnElement(privacyPolicyCheckBox);
    }
    public void clickOnContinueRegister(){
        clickOnElement(continueRegister);
    }
    public String verifyTextAccountCreated() {
        return getTextFromElement(accountHasBeenCreated);
    }
    public void clickOnContinueRegister2(){
        clickOnElement(continueRegister2);
    }
    public void clickOnMyAccount(){
        clickOnElement(myAccountLink);
    }
    public String verifyTextAccountLoggedOut() {
        return getTextFromElement(accountLogoutLink);
    }
    public void clickOnContinueLinkBottom(){
        clickOnElement(continueLinkBottom);
    }
    public void clickOnLoginLink(){
        clickOnElement(loginLink);
    }
    public void clickOnMyAccountLinkLoginPage(){
        clickOnElement(myAccountLinkLoginPage);
    }


    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }
    public static String getAlphaNumericString(int n) {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length() * Math.random());
            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
    public void selectRadioButton(){
    List<WebElement> radioButtons = driver.findElements(By.xpath("//fieldset[3]//input"));
        for (WebElement e : radioButtons) {
            if (e.getText().equals("Yes")) {
                e.click();
                break;
            }
        }
    }

        }


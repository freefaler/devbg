package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);
    private static final String PAGE_URL = "/login";

    @FindBy(id = "loginusername")
    private WebElement emailField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;


   @FindBy(id = "newpass2")
    private WebElement forgottenPasswordLink;

    @FindBy(id = "loginsubmit")
    private WebElement loginButton;


    @FindBy(id = "firstloginalert2")
    private WebElement loginPageAlert;

    @FindBy(xpath = "//div[@id='wellcome']")
    private WebElement companyNameDiv;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigates to current page
     * @return this
     */
    public LoginPage gotoPage() {
        LOGGER.info("Navigate to: " + BASE_URL + PAGE_URL);
        navigateTo(PAGE_URL);
        return this;
    }

    /**
     * Enters email address
     * @param email email
     * @return this
     */
    public LoginPage enterEmail(String email){
        LOGGER.info("Entering email: " + email);
        typeText(emailField, email);
        return this;
    }

    /**
     * Enters password
     * @param password password
     * @return this
     */
    public LoginPage enterPassword(String password){
        LOGGER.info("Entering password: " + "********");
        typeText(passwordField, password);
        return this;
    }

    /**
     * Clicks Login button
     * @return this
     */
    public LoginPage clickLoginButton(){
        LOGGER.info("Clicking Login button");
        click(loginButton);
        return this;
    }

    /**
     * Clicks Forgotten Password link
     */
    public void clickForgottenPasswordLink(){
        LOGGER.info("Clicking Forgotten Password link");
        click(forgottenPasswordLink);
    }

    /**
     * Performs login
     * @param email
     * @param password
     */
    public void login(String email, String password){
        gotoPage().enterEmail(email).enterPassword(password).clickLoginButton();
    }


    /**
     * Retrieves company name
     * @return
     */
    public String getCompanyName(){
        return getText(companyNameDiv);
    }

}

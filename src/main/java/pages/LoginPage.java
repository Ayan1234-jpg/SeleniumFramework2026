package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	
	@FindBy(id="Email")
	WebElement usernameTextBox;
	
	@FindBy(id="Password")
	WebElement passwordTextBox;
	
	@FindBy(css=".button-1.login-button")
	WebElement loginButton;
	

	//private By usernameTextBox = By.id("Email");
	//private By passwordTextBox = By.id("Password");
	//private By loginButton = By.cssSelector(".button-1.login-button");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		usernameTextBox.clear();
		usernameTextBox.sendKeys(username);
		
		//driver.findElement(usernameTextBox).clear();
		//driver.findElement(usernameTextBox).sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
		
		//driver.findElement(passwordTextBox).clear();
		//driver.findElement(passwordTextBox).sendKeys(password);
	}

	public void clickLogin() {
		loginButton.click();
		//driver.findElement(loginButton).click();
	}

}

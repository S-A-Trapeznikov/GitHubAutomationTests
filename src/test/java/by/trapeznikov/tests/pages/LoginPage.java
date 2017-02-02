package by.trapeznikov.tests.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
	
	
	private final String BASE_URL = "https://github.com/login";
	private final String LOGIN = "IvanovMisha";
	private final String JOIN_GITHUB = "Join GitHub";
	private final Logger logger = LogManager.getRootLogger();
	
	@FindBy(id = "login_field")
	private WebElement login;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement btnSubmit;
	@FindBy(xpath = "//strong[@class='css-truncate-target']")
	private WebElement signAsName;
	@FindBy(xpath = "//form[@class='logout-form']/button")
	private WebElement btnSignOut;	
	@FindBy(xpath = "//img[@class='avatar']")
	private WebElement navList;
	@FindBy(xpath = "//div[@class='container']")
	private WebElement container;
	@FindBy(xpath = "//div[@id='login']/p/a")
	private WebElement linkToRegForm;
	@FindBy(xpath = "//div[@class='setup-wrapper']/div/h1")
	private WebElement joinGitHub;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void signIn(String login,String password){
		this.login.sendKeys(login);
		this.password.sendKeys(password);
		btnSubmit.click();		
	}
	
	public void openLinkRegForm(){
		linkToRegForm.click();
	}
	
	public boolean isRegForm(){		
		boolean check = JOIN_GITHUB.equals(joinGitHub.getText());
		return check;
	}
	
	public boolean isSignIn(){
		navList.click();
		boolean check = LOGIN.equals(signAsName.getText());
		container.click();
		return check;
	}
	
	public void signOut(){
		navList.click();
		btnSignOut.click();		
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Login page open");				
	}

}

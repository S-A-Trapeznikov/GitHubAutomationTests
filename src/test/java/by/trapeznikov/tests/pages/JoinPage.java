package by.trapeznikov.tests.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JoinPage extends AbstractPage {
	
	private final String BASE_URL = "https://github.com/join";
	private final String ERROR_MSG = "There were problems creating your account.";
	private final Logger logger = LogManager.getRootLogger();
	
	@FindBy(id = "user_login")
	private WebElement userName;
	@FindBy(id = "user_email")
	private WebElement userMail;
	@FindBy(id = "user_password")
	private WebElement userPassword;
	@FindBy(id = "signup_button")
	private WebElement BtnSignUp;
	@FindBy(xpath = "//form[@id='signup-form']/div[2]")
	private WebElement warningMsg;
	
	
	public JoinPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public boolean warrningMsgIsExist(){
		logger.info(ERROR_MSG.equals(warningMsg.getText()));
		return ERROR_MSG.equals(warningMsg.getText());
		
	}
	
	public void createNewAccount(String Name, String email, String Password) {
		userName.clear();
		userMail.clear();
		userPassword.clear();
		userName.sendKeys(Name);
		userMail.sendKeys(email);
		userPassword.sendKeys(Password);
		BtnSignUp.click();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Join page open");		
	}

	
}

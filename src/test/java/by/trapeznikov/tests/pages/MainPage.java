package by.trapeznikov.tests.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage{
	
	private final String BASE_URL = "https://github.com/";
	private final String JOIN_GITHUB = "Join GitHub";
	private final String ERROR_MSG = "There were problems creating your account.";
	private final Logger logger = LogManager.getRootLogger();
	
	@FindBy(xpath = "//div[@class='d-none-sm-dn']/form/button")
	private WebElement btnReg;	
	@FindBy(xpath = "//div[@class = 'setup-form-container']/form/div[2]")
	private WebElement errorMsg;
	@FindBy(xpath = "//div[@class = 'site-header-actions']/a")
	private WebElement btnSignUp;
	@FindBy(xpath = "//div[@class = 'pricing-card-cta']/a")
	private WebElement btnSignUpForGitHub;
	@FindBy(xpath = "//div[@class='setup-wrapper']/div/h1")
	private WebElement joinGitHub;
	
	

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public boolean regWithEmptyFields(){
		btnReg.click();
		return ERROR_MSG.equals(errorMsg.getText());
	}	
	
	public void openLinkRegFormSignUp(){
		btnSignUp.click();
	}
	
	public void openLinkRegFormSignUpForGitHub(){
		btnSignUp.click();
	}
	
	public boolean isRegForm(){		
		boolean check = JOIN_GITHUB.equals(joinGitHub.getText());
		return check;
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Main page github.com open");
				
	}

}

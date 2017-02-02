package by.trapeznikov.tests.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenSourcePage extends AbstractPage {
	
	public OpenSourcePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver,this);
	}

	private final String BASE_URL = "https://github.com/open-source";
	private final String JOIN_GITHUB = "Join GitHub";
	private final Logger logger = LogManager.getRootLogger();
	
	@FindBy(xpath = "//div[@role = 'main']/div/a")
	private WebElement btnSignUpForGitHub;
	
	@FindBy(xpath = "//div[@class = 'pricing-card-cta']/a")
	private WebElement btnSignUpForGitHubBottom;
	
	@FindBy(xpath = "//div[@class='setup-wrapper']/div/h1")
	private WebElement joinGitHub;
	
	public void openLinkRegFormSignUpForGitHub(){
		btnSignUpForGitHub.click();
	}
	
	public void openLinkRegFormSignUpForGitHubBottom(){
		btnSignUpForGitHubBottom.click();
	}
	
	public boolean isRegForm(){		
		boolean check = JOIN_GITHUB.equals(joinGitHub.getText());
		return check;
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("OpenSource page open");		
	}
	
	

}
	
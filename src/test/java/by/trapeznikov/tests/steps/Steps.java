package by.trapeznikov.tests.steps;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.trapeznikov.tests.driver.DriverSingleton;
import by.trapeznikov.tests.pages.JoinPage;
import by.trapeznikov.tests.pages.LoginPage;
import by.trapeznikov.tests.pages.MainPage;
import by.trapeznikov.tests.pages.OpenSourcePage;
import by.trapeznikov.tests.pages.PersonalPage;

public class Steps {
	
	private WebDriver driver;
	private final  Logger logger = LogManager.getRootLogger();
	
	public void initBrowser(){
		driver = DriverSingleton.getDriver();
	}
	
	public void closeDriver(){
	driver.close();	
	}
		
	public boolean tryRegWithEmptyFields(){
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		return mainPage.regWithEmptyFields();
	}
	
	public boolean tryCreateNewAccount(String name, String email, String password){
		JoinPage joinPage = new JoinPage(driver);
		joinPage.openPage();
		joinPage.createNewAccount(name, email, password);
		return joinPage.warrningMsgIsExist();		
	}
	
	public boolean trySignIn(String login, String password){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.signIn(login,password);
		boolean nameAcc = loginPage.isSignIn();
		loginPage.signOut();
		return nameAcc;		
	}
	
	public boolean tryJoinGitHub(){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.openLinkRegForm();
		return loginPage.isRegForm();		
	}
	
	public boolean tryJoinGitHubMainPageHeader(){
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.openLinkRegFormSignUp();
		return mainPage.isRegForm();		
	}
	
	public boolean tryJoinGitHubMainPageBottom(){
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.openLinkRegFormSignUpForGitHub();
		return mainPage.isRegForm();		
	}
	
	public boolean tryJoinGitHubPersonalPageHeader(){
		PersonalPage personalPage = new PersonalPage(driver);
		personalPage.openPage();
		personalPage.openLinkRegFormSignUpForGitHub();
		return personalPage.isRegForm();		
	}
	
	public boolean tryJoinGitHubPersonalPageBottom(){
		PersonalPage personalPage = new PersonalPage(driver);
		personalPage.openPage();
		personalPage.openLinkRegFormSignUpForGitHubBottom();
		return personalPage.isRegForm();		
	}
	
	public boolean tryJoinGitHubOpenSourcePageHeader(){
		OpenSourcePage openSourcePage = new OpenSourcePage(driver);
		openSourcePage.openPage();
		openSourcePage.openLinkRegFormSignUpForGitHub();
		return openSourcePage.isRegForm();		
	}
	
	public boolean tryJoinGitHubOpenSourcePageBottom(){
		OpenSourcePage openSourcePage = new OpenSourcePage(driver);
		openSourcePage.openPage();
		openSourcePage.openLinkRegFormSignUpForGitHubBottom();
		return openSourcePage.isRegForm();		
	}
		
}

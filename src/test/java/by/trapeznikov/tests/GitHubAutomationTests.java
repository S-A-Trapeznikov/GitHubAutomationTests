package by.trapeznikov.tests;

import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.trapeznikov.tests.steps.Steps;

public class GitHubAutomationTests {
	
	private Steps steps;
	
	@DataProvider(name = "dataLoginForm")
	public Object [][] createDataLoginForm(){
		return new Object [][] 
				{
					{"IvanovMisha","Ivanov2017"},
					{"tempgite@mail.ru","Ivanov2017"}
				};
	}
	
	@DataProvider(name = "dataJoinForm")
	public Object [][] createDataJoinForm(){
		return new Object [][] 
				{
					{"sdgdfgdf","sdfsdfsdf","1234567"},
					{"tstGit","",""},
					{"","tempgite@mail.ru",""},
					{"","","1234567m"},
					{"user!@#$%","tempgite@mail.ru","water2Proof"},
					{"-","tempgite@mail.ru","water2Proof"},
					{"excelentPerson-","tempgite@mail.ru","water2Proof"},
					{"excelent--Person","tempgite@mail.ru","water2Proof"},
					{"1234567890123456789012345678901234567890","tempgite@mail.ru","water2Proof"},
					{"Trapeznikov","tempgite@mail.ru","water2Proof"},
					{"Трапезников","tempgite@mail.ru","water2Proof"},
					{"IvanovMisha","tempgitemail.ru","water2Proof"},
					{"IvanovMisha","temp@gite@mail.ru","water2Proof"},
					{"IvanovMisha","temp@gite@mailru","water2Proof"},
					{"IvanovMisha","@mail.ru","water2Proof"},
					{"IvanovMisha","tempgite@192.168.1.1.0","water2Proof"},
					{"IvanovMisha","tempgite@mail.ru","1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234"},
				};
	}
		
	@BeforeTest(description = "Initialisation Browser")
	public void setUp(){
		steps = new Steps();
		steps.initBrowser();
	}
	
	@Test(description = "go to join form from login page")
	public void toRegFormLogin(){
		Assert.assertTrue(steps.tryJoinGitHub());		
	}
	
	@Test(description = "go to join form header main page")
	public void toRegFormMainHeader(){
		Assert.assertTrue(steps.tryJoinGitHubMainPageHeader());		
	}
	
	@Test(description = "go to join form bottom main page")
	public void toRegFormMainBottom(){
		Assert.assertTrue(steps.tryJoinGitHubMainPageBottom());		
	}
	
	@Test(description = "go to join form header personal page")
	public void toRegFormPersonalHeader(){
		Assert.assertTrue(steps.tryJoinGitHubPersonalPageHeader());		
	}
	
	@Test(description = "go to join form bottom personal page")
	public void toRegFormPersonalBottom(){
		Assert.assertTrue(steps.tryJoinGitHubPersonalPageBottom());		
	}
	
	@Test(description = "go to join form header open source page")
	public void toRegFormOpenSourceHeader(){
		Assert.assertTrue(steps.tryJoinGitHubOpenSourcePageHeader());		
	}
	
	@Test(description = "go to join form bottom open source page")
	public void toRegFormOpenSourceBottom(){
		Assert.assertTrue(steps.tryJoinGitHubOpenSourcePageBottom());		
	}
	
	@Test(description = "attempt registration with empty fields")
	public void regEmptyField(){
		Assert.assertTrue(steps.tryRegWithEmptyFields());		
	}
	
	@Test(dataProvider = "dataJoinForm")
	public void createNewAccount(String userName, String email, String Password){
			Assert.assertTrue(steps.tryCreateNewAccount(userName, email, Password));
	}
	
	@Test(dataProvider = "dataLoginForm")
	public void SignIn(String userName, String Password){
			Assert.assertTrue(steps.trySignIn(userName, Password));
	}	
	
	
	
	
	
	@AfterTest(description = "Stop Browser")
	public void stopBrowser(){
		steps.closeDriver();
	}

}

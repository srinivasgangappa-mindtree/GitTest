package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Test_Steps {
	static WebDriver driver;
	static WebDriverWait wait;
	@Given("^User is on Home Page$")
	public void User_is_on_Home_Page() throws Throwable
	{
		String usrDir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", usrDir+"/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,90);		
	    // Write code here that turns the phrase above into concrete actions
	   //throw new PendingException();
	}

	@Given("^User enters UserName and Password$")
	public void User_enters_UserName_and_Password () throws Throwable
		{
		driver.findElement(By.id("username")).sendKeys("srinivas.chennupati@gmail.com");
		driver.findElement(By.id("password")).sendKeys("passw0rd");
		driver.findElement(By.id("Login")).click();
	}
	@Then("^Message displayed Login Successfully$")
	public void Message_displayed_Login_Successfully() throws Throwable
	{
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
	}
}

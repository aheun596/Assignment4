package steps;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {
	
	WebDriver driver;
	
	@Given("^I open Chrome browser$")
	public void i_open_Chrome_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "chrome/chromdriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	@Given("^I go to Petstore page$")
	public void i_go_to_Petstore_page() throws Throwable {
		driver.get("http://34.121.163.23:8080/jpetstore/");
	}

	@Given("^I enter Petstore$")
	public void i_enter_Petstore() throws Throwable {
		driver.findElement(By.linkText("Enter The Store")).click();
		
	}

	@Given("^I go to login page$")
	public void i_go_to_login_page() throws Throwable {
		driver.findElement(By.linkText("Sign In")).click();
	}

	@When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\" combination$")
	public void i_enter_valid_and_combination(String arg1, String arg2) throws Throwable {
		driver.findElement(By.name("username")).sendKeys(arg1);
		driver.findElement(By.name("password")).sendKeys(arg2);
		driver.findElement(By.cssSelector("[type='submit']")).click();
		
	}

	@Then("^I should be able to login successfully$")
	public void i_should_be_able_to_login_successfully() throws Throwable {
		try {
			WebElement element = driver.findElement(By.linkText("Home"));
			assertTrue(true);
		} catch (Exception e) {
			fail();
		} finally {
			driver.quit();
		}
	}
}

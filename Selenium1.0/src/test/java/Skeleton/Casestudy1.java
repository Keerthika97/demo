package Skeleton;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Casestudy1 
{
	static {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\training_c2d.02.11\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		   }	
	 WebDriver driver=new ChromeDriver();
	public class inputs
	{
		public String username;
		public String firstname;
		public String lastName;
		public String password;
		public String password_confirmation;
		public String Gender;
		public String E_mail;
		public String mobilenumber;
		public String DOB;
		public String address;
		public String security_ques;
		public String Answer;
	}
	@Given("User should be on the login page")
	public void user_should_be_on_the_login_page()
	{
		driver.get("http://10.232.237.143:443/TestMeApp/");
		WebElement signin=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li/a"));
		 signin.click();
		 WebElement register1=driver.findElement(By.xpath("//a[@class='btn btn-link col-md-3']"));
		 register1.click();
	}

	
	@When("User should enter the details and click register button")
	public void user_should_enter_the_details_and_click_register_button(List<inputs> ob) 
	{
		 
	    for(inputs val:ob)
	    {
	    	WebElement username=driver.findElement(By.name("userName"));
	    	username.click();
	    	username.sendKeys(val.username);
	    	WebElement firstname=driver.findElement(By.id("firstName"));
	    	firstname.click();
	    	firstname.sendKeys(val.firstname);
	    	WebElement lastname=driver.findElement(By.id("lastName"));
	    	lastname.click();
	    	lastname.sendKeys(val.lastName);
	    	WebElement password2=driver.findElement(By.id("password"));
	    	password2.click();
	    	password2.sendKeys(val.password);
	    	WebElement cpassword=driver.findElement(By.id("pass_confirmation"));
	        cpassword.click();
	    	cpassword.sendKeys(val.password_confirmation);
	    	WebElement gen=driver.findElement(By.cssSelector("input[value='Female']"));
	  	    gen.click();
	  	    WebElement email=driver.findElement(By.id("emailAddress"));
	  	    email.click();
	  	    email.sendKeys(val.E_mail);
	    	driver.findElement(By.id("mobileNumber")).sendKeys(val.mobilenumber);
	    	driver.findElement(By.id("dob")).sendKeys(val.DOB);
	    	driver.findElement(By.id("address")).sendKeys(val.address);
	    	Select s=new Select(driver.findElement(By.id("securityQuestion")));
	   	    s.selectByValue(val.security_ques);
	   	    driver.findElement(By.id("answer")).sendKeys(val.Answer);
	   	    WebElement regis=driver.findElement(By.xpath("//div[@class='col-md-12 remove-default-padding']/input"));
		    regis.click();
	    }
	}

	@Then("Successfull user registration")
	public void successfull_user_registration()
	{
		System.out.println("USER NAME PASSWORD SUCCESSFULLY REGISTERED!!!");
	}
}

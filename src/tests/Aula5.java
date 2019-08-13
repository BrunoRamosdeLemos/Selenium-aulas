package tests;

import model.Customer;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Aula5 {
	public WebDriver driver;
	public String testURL = "http://automationpractice.com/index.php";
	public Customer test_user;

  @BeforeTest
  public void setupTest() {
	  	System.setProperty("webdriver.gecko.driver",
	            "C:\\Dev\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to(testURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		int no_email = (int)(Math.random() * 1001);
		String test_email = "joao-doe"+ no_email +"@example.com";
		
		test_user = new Customer(
					"João",
					"Doe",
					test_email,
					"swordF1$H",
					"ACME",
					"Rua que vem",
					"Washington",
					"Washington",
					"20001",
					"United States",
					"246 2222",
					"246 2242",
					"rua que vai"
				);
	}
  @Test(priority = 0)
  public void Test_Title() {
	  assertTrue(driver.getTitle().contains("My Store"));
  }
  
  @Test(priority = 1)
	public void registerTest() {
	  //go to register page
		WebElement log = driver.findElement(By.className("login"));
		log.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//register by email
		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email_create")));
		email.sendKeys(test_user.getEmail());
		
		WebElement go_to_register = driver.findElement(By.id("SubmitCreate"));
		go_to_register.submit();
		
		//user data
		
		WebElement address_alias =wait.until(ExpectedConditions.elementToBeClickable(By.id("alias")));
		address_alias.clear();
		address_alias.sendKeys(test_user.getAddress_alias());
		
		WebElement gender = driver.findElement(By.id("id_gender1"));
		gender.click();
		
		WebElement customer_firstname = driver.findElement(By.id("customer_firstname"));
		customer_firstname.sendKeys(test_user.getFirst_name());
		
		WebElement customer_lastname = driver.findElement(By.id("customer_lastname"));
		customer_lastname.sendKeys(test_user.getLast_name());
		
		WebElement customer_email = driver.findElement(By.id("email"));
		customer_email.clear();
		customer_email.sendKeys(test_user.getEmail());
		
		WebElement customer_pass = driver.findElement(By.id("passwd"));
		customer_pass.sendKeys(test_user.getPassword());
		
		Select day = new Select(driver.findElement(By.id("days")));
		day.selectByValue("1");
		
		Select month = new Select(driver.findElement(By.id("months")));
		month.selectByValue("1");
		
		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByValue("1975");
		
		//address form
		
		//WebElement firstname = driver.findElement(By.id("firstname"));
		//firstname.sendKeys(test_user.getFirst_name());
		
		//WebElement lastname = driver.findElement(By.id("lastname"));
		//lastname.sendKeys(test_user.getLast_name());
		
		WebElement company = driver.findElement(By.id("company"));
		company.sendKeys(test_user.getCompany());
		
		WebElement address1 = driver.findElement(By.id("address1"));
		address1.sendKeys(test_user.getAddress());
		
		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys(test_user.getCity());
		
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText(test_user.getState());
		
		WebElement postal_code = driver.findElement(By.id("postcode"));
		postal_code.sendKeys(test_user.getPostal_code());
		
		Select country = new Select(driver.findElement(By.id("id_country")));
		country.selectByVisibleText(test_user.getCountry());
		
		WebElement home_phone = driver.findElement(By.id("phone"));
		home_phone.sendKeys(test_user.getHome_phone());
		
		WebElement phone_mobile = driver.findElement(By.id("phone_mobile"));
		phone_mobile.sendKeys(test_user.getMobile_phone());
		
		
		//register account
		WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitAccount")));
		register.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(driver.getTitle().contains("My account"));	
	}
  
  @Test(priority = 2)
  public void Test_add_item() {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  
	  WebElement t_shirts = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".sf-menu > li:nth-child(3) > a:nth-child(1)")));
	  t_shirts.click();
	  
	  WebElement faded_short_sleeve_img = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".product_img_link > img:nth-child(1)")));
	  
	  Actions action = new Actions(driver);
	  action.moveToElement(
			  faded_short_sleeve_img
			  ).click(
					  wait.until(
							  ExpectedConditions.elementToBeClickable(
									  By.cssSelector(".ajax_add_to_cart_button > span:nth-child(1)")
									  )
							  )
					  ).build().perform();
	  //WebElement success_add = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".layer_cart_product > h2:nth-child(2)")));
	  //assertTrue(success_add.getText().contains("Product successfully added to your shopping cart"));
  }
  
  @Test(priority = 3)
  public void Test_send_friend() {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  WebElement continue_shopping = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".continue > span:nth-child(1)")));
	  continue_shopping.click();
	  
	  
	  WebElement faded_short_sleeve_img = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".product_img_link > img:nth-child(1)")));
	  
	  Actions action = new Actions(driver);
	  action.moveToElement(
			  faded_short_sleeve_img
			  ).click(
					  wait.until(
							  ExpectedConditions.elementToBeClickable(
									  By.cssSelector(".lnk_view > span:nth-child(1)")
									  )
							  )
					  ).build().perform();
	  
	  WebElement send_friend = wait.until(ExpectedConditions.elementToBeClickable(By.id("send_friend_button")));
	  send_friend.click();
	  
	  WebElement friend = wait.until(ExpectedConditions.elementToBeClickable(By.id("friend_name")));
	  friend.sendKeys("Amanda Jane");
	  WebElement friend_email = wait.until(ExpectedConditions.elementToBeClickable(By.id("friend_email")));
	  friend_email.sendKeys("amanda_jane@example.com");
	  WebElement send_buttom = wait.until(ExpectedConditions.elementToBeClickable(By.id("sendEmail")));
	  send_buttom.click();
	  
	  //WebElement success_send = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fancybox-inner > p:nth-child(2)")));
	  //assertTrue(success_send.getText().contains("Your e-mail has been sent successfully"));
	  
  }
  
  @Test(priority = 4)
  public void Test_checkout() {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  
	  WebElement ok_buttom = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.button")));
	  ok_buttom.click();
	  
	  WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".shopping_cart > a:nth-child(1) > b:nth-child(1)")));
	  
	  Actions action = new Actions(driver);
	  action.moveToElement(
			  cart
			  ).click(
					  wait.until(
							  ExpectedConditions.elementToBeClickable(
									  By.cssSelector("#button_order_cart > span:nth-child(1)")
									  )
							  )
					  ).build().perform();
	  
	  WebElement go_to_checkout1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".standard-checkout > span:nth-child(1)")));
	  go_to_checkout1.click();
	  
	  WebElement go_to_checkout2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.button:nth-child(4) > span:nth-child(1)")));
	  go_to_checkout2.click();
	  
	  WebElement terms = wait.until(ExpectedConditions.elementToBeClickable(By.id("cgv")));
	  terms.click();
	  
	  WebElement go_to_checkout3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.button:nth-child(4) > span:nth-child(1)")));
	  go_to_checkout3.click();
	  
	  WebElement payment = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bankwire")));
	  payment.click();
	  
	  WebElement confirm = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.button-medium > span:nth-child(1)")));
	  confirm.click();
	  
	  WebElement success_order = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cheque-indent > strong:nth-child(1)")));
	  assertTrue(success_order.getText().contains("Your order on My Store is complete."));
	   
  }
  
  @Test(priority = 5)
  public void Test_print_order_reference() {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  WebElement go_to_orders = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button-exclusive")));
	  go_to_orders.clear();
	  
	  WebElement order_ref = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".color-myaccount")));
	  WebElement total_price = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".history_price > span:nth-child(1)")));
	  
	  System.out.println(" \n Order Reference: " + order_ref.getText() + "\n Total price: " + total_price.getTagName());
	  System.out.println("Complete");
  }
  

}

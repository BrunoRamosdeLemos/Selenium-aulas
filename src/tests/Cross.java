package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross {
	
	WebDriver driver;
	
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}
		else {
			throw new Exception("Navegador incorreto!!");
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
  @Test
  public void testParameterWithXML() throws InterruptedException {
	  
	  driver.get("https:www.globo.com");
	  String titulo  = driver.getTitle();
	  
	  System.out.print("Título da Página: " + titulo);
  }
}

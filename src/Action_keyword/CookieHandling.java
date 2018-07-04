package Action_keyword;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import Util.WebElementLocators;

public class CookieHandling {
	WebDriver driver;
	WebElementLocators CookieLocator;
	String url="http://10.0.1.86/tatoc/error";
	
	public CookieHandling(WebDriver driver) throws IOException {
		this.driver=driver;
		CookieLocator = new WebElementLocators(driver);
	}
	
   public void CookieHandling(WebDriver driver) throws IOException {
	   this.driver = driver;
	   CookieLocator = new WebElementLocators(driver);
   }
   
   public void go_to_end_of_course_page() {
	  // String token = pointer.findElement(By.id("token")).getText();
	   CookieLocator.getWebElement("Generate_token_link").click();
	   String token = CookieLocator.getWebElement("Token").getText();
	    String tokenid= token.substring(7, token.length());
	    System.out.println("Lofa");
	    Cookie cookie = new Cookie("Token",tokenid);
	    driver.manage().addCookie(cookie);
	    CookieLocator.getWebElement("Proceed_button").click();
   }
   
   public void go_to_error_page_if_cookie_not_generated() {
	   CookieLocator.getWebElement("Generate_token_link").click();
	   CookieLocator.getWebElement("Proceed_button").click();
	   Assert.assertTrue(driver.getCurrentUrl().equals(url));
	   driver.navigate().back();
   }
}

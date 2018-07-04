package Action_keyword;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Util.WebElementLocators;

public class End {
	 WebDriver driver; 
	 WebElementLocators endPageLocator;
    public End(WebDriver driver) throws IOException {
    	this.driver = driver;
    	endPageLocator = new WebElementLocators(driver);
    }
    
    public void Check_end_page_by_url() {
    	Assert.assertTrue(driver.getCurrentUrl().equals("http://10.0.1.86/tatoc/end"));
    }
    
    public void Check_end_page_by_message() {
    String expected_msg="Obstacle Course is Complete!";
    String Actual_msg=endPageLocator.getWebElement("Message").getText();
    Assert.assertTrue(expected_msg.equals(Actual_msg));
    }
}

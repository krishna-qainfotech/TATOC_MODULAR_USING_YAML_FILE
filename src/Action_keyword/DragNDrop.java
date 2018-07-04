package Action_keyword;

import java.awt.Desktop.Action;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import Util.WebElementLocators;

public class DragNDrop {
   
	WebDriver driver;
    WebElementLocators DragNDropLocator;
    WebElement dragfrom,To;
    Actions act;
    String url="http://10.0.1.86/tatoc/error";
    
    public DragNDrop(WebDriver driver) throws IOException{
		this.driver=driver;
		DragNDropLocator = new WebElementLocators(driver);
		act=new Actions(driver);
	}
   
   private WebElement DragBoxElement() {
	   return DragNDropLocator.getWebElement("Dragbox_element");
   }
   
   private WebElement DropBoxElement() {
	   return DragNDropLocator.getWebElement("Dropbox_element");
   }
   
   public void proceedButton() {
	   driver.navigate().back();
	   act.dragAndDrop(DragBoxElement(), DropBoxElement()).build().perform();
	   DragNDropLocator.getWebElement("Proceed_button").click();
     }
   
   public void IsError() {
	   DragNDropLocator.getWebElement("Proceed_button").click();
	   Assert.assertTrue(driver.getCurrentUrl().equals(url));
	}
}

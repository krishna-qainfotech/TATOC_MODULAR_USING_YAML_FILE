package Action_keyword;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Util.WebElementLocators;

public class PopupWindows {
     WebDriver driver;
     WebElementLocators PopUpLocator;
     ArrayList windowlist;
     String url="http://10.0.1.86/tatoc/error";
     
	public PopupWindows(WebDriver driver) throws IOException {
	    this.driver = driver;
	    PopUpLocator = new WebElementLocators(driver);
	    
	}
	
	public void Pop_Up_Window2() {
		PopUpLocator.getWebElement("Popup_windows_button").click();
		windowlist = new ArrayList(driver.getWindowHandles());
		String window1=((String)windowlist.get(1));
	    driver.switchTo().window(window1);
	    Check_If_it_go_to_next_page_when_name_is_correct();
	}
	
	private void Pop_Up_Window1() {
		String window2=((String)windowlist.get(0));
		driver.switchTo().window(window2);
		Click_On_Procced_Result_To_NextPage();
	}
	
	private void Set_name_in_Pop_up_box_and_Submit(String name) {
		PopUpLocator.getWebElement("Input_field").sendKeys(name);
		PopUpLocator.getWebElement("Submit_button").click();
		Pop_Up_Window1();
	}
	
	public void Check_If_it_go_to_next_page_when_name_is_correct() {
		Set_name_in_Pop_up_box_and_Submit("Krishnachauhan");
	}
	
    public void Click_On_Procced_Result_To_Error_page() {
        PopUpLocator.getWebElement("Proceed_button").click();
    	Assert.assertTrue(driver.getCurrentUrl().equals(url));
        driver.navigate().back();
    }
	
    public void Click_On_Procced_Result_To_NextPage() {
    	//Pop_Up_Window2();
    	//Set_name_in_Pop_up_box_and_Submit('uday');
    	PopUpLocator.getWebElement("Proceed_button").click();
    	Assert.assertTrue(driver.getCurrentUrl().equals("http://10.0.1.86/tatoc/basic/cookie"));
    }
    
	
}

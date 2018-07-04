package Action_keyword;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Util.WebElementLocators;

public class GridBoxActions {
	WebDriver driver;
	WebElementLocators locateGridBoxElements;
	
	public GridBoxActions(WebDriver driver) throws IOException {
		this.driver = driver;
		 locateGridBoxElements = new WebElementLocators(driver);
	}
	
	
    public void clickGridBox(String colorOfBox) {
    	if(colorOfBox == "greenbox") {
    		locateGridBoxElements.getWebElement("Green_gridbox").click();
    	}
    	else {
    		locateGridBoxElements.getWebElement("Red_gridbox").click();
    	}
    }
}

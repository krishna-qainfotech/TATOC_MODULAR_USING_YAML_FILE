package Action_keyword;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Util.WebElementLocators;

public class FrameAndDungeonActions {
	WebDriver driver;
	 WebElementLocators frameAndDungeonElementLocators;
	 String CurrentUrl="";
	public FrameAndDungeonActions(WebDriver driver) throws IOException {
		this.driver = driver;
		frameAndDungeonElementLocators = new WebElementLocators(driver);
	}
	
	private String getColorOfBox1() {
		driver.switchTo().frame("main");
		String color_of_box1 = frameAndDungeonElementLocators.getWebElement("First_box_color").getAttribute("class");
		driver.switchTo().defaultContent();
		//System.out.println(color_of_box1+"LOLOLOLOLOLOLO");
		return color_of_box1;
	}
	
	private String getColorOfBox2() {
		driver.switchTo().frame("main");
		driver.switchTo().frame("child");
		String color_of_box_2 = frameAndDungeonElementLocators.getWebElement("Second_box_color").getAttribute("class");
		driver.switchTo().defaultContent();
		//System.out.println(color_of_box_2+"LOLOLOLOLOLOLO");
		return color_of_box_2;
	}
	
	private void repaint() {
		driver.switchTo().frame("main");
		frameAndDungeonElementLocators.getWebElement("Repaint_button").click();
		driver.switchTo().defaultContent();
	}
	
	private void matchColor() {
		String box1Color = getColorOfBox1();
		String box2Color = getColorOfBox2();
		while(box1Color.equals(box2Color) != true) {
			repaint();
			box2Color = getColorOfBox2();
		}
	}
	public  void proceed() {
		driver.switchTo().frame("main");
		frameAndDungeonElementLocators.getWebElement("Proceed_button").click();
	}
	public void isclickingWithmatchingColorsTakesToDragAndDropBoxPage() {
		matchColor();
		proceed();
		String expectedUrl = "http://10.0.1.86/tatoc/basic/drag";
		Assert.assertTrue(expectedUrl.contains(driver.getCurrentUrl()));	
	}
	
	public void isclickingWithoutColorMatchingTakesToErrorPage() {
		proceed();
		String expectedUrl = "http://10.0.1.86/tatoc/error";
		CurrentUrl=driver.getCurrentUrl();
		Assert.assertTrue(expectedUrl.contains(CurrentUrl));
		driver.navigate().back();
	}
}

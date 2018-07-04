package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Action_keyword.CookieHandling;
import Action_keyword.DragNDrop;
import Action_keyword.End;
import Action_keyword.FirstPageActions;
import Action_keyword.FrameAndDungeonActions;
import Action_keyword.GridBoxActions;
import Action_keyword.PopupWindows;

public class MainTest {
	
	WebDriver driver;
	FirstPageActions firstpage;
	GridBoxActions gridboxpage;
	FrameAndDungeonActions frameandDungeon;
	DragNDrop dragNdrop;
	PopupWindows popUpWindow;
	CookieHandling cookiehandling;
	End end;
	@BeforeTest
	public void openTatocLink() throws IOException {
		 System.setProperty("webdriver.chrome.driver", "/home/qainfotech/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		firstpage = new FirstPageActions( driver);
		gridboxpage = new GridBoxActions(driver);
		frameandDungeon = new FrameAndDungeonActions(driver);
		dragNdrop = new DragNDrop(driver);
		popUpWindow = new PopupWindows(driver);
		cookiehandling = new CookieHandling(driver);
		end = new End(driver);
	}
	
	@Test
	public void attempClickingBasicCourse() {
		firstpage.clickBasicCourse();
	}
	
	@Test(dependsOnMethods = {"attempClickingBasicCourse"})
	public void attempGridBoxPage() {
		gridboxpage.clickGridBox("redbox");
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		gridboxpage.clickGridBox("greenbox");
	}
	
	@Test(dependsOnMethods = {"attempGridBoxPage"})
	public void attemptFrameAndDungeonPage() {
		frameandDungeon.isclickingWithoutColorMatchingTakesToErrorPage();
		frameandDungeon.isclickingWithmatchingColorsTakesToDragAndDropBoxPage();
	}
	
	@Test(dependsOnMethods= {"attemptFrameAndDungeonPage"})
	public void attemptDragNdrop() {
		dragNdrop.IsError();
		dragNdrop.proceedButton();
	}
	
	@Test(dependsOnMethods= {"attemptDragNdrop"})
	public void attemptPopUpWindow() {
		popUpWindow.Click_On_Procced_Result_To_Error_page();
		popUpWindow.Pop_Up_Window2();
	}
	
	@Test(dependsOnMethods= {"attemptPopUpWindow"})
	public void attemptCookie() {
		cookiehandling.go_to_error_page_if_cookie_not_generated();
		cookiehandling.go_to_end_of_course_page();
		
	}
	
	@Test(dependsOnMethods= {"attemptCookie"})
	public void EndPage() {
	   end.Check_end_page_by_url();
	   end.Check_end_page_by_message();
	}
}

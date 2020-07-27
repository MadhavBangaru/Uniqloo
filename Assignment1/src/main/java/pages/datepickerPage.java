package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class datepickerPage {
	
	WebDriver driver;
	
	public datepickerPage(WebDriver driver) {
		this.driver= driver;
	}
	
	By disabledDP = By.xpath("//input[@id='datepicker1']");
	By activeDP = By.xpath("//input[@id='datepicker2']");
	
	
	 public void changeDisabledDate(String str)
	 {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("document.getElementById('datepicker1').value='"+str+"'");
		 
	 }
	 public void changeActiveDate(String str1) {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("document.getElementById('datepicker2').value='"+str1+"'");
		
	}
	 
	 public String get_disabledDate() 
	 {
		 return driver.findElement(disabledDP).getText();
	 }

	 public String get_activeDate() 
	 {
		 return driver.findElement(activeDP).getText();
	 }

	
}

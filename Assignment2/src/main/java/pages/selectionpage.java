package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class selectionpage {
	
	
	By cheapest = By.cssSelector("input[value='BOOK']");

	WebDriver driver;
	public selectionpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public WebElement selectCheapest() {
		// TODO Auto-generated method stub
		return driver.findElement(cheapest);
		 
	}
	
	public boolean checkTitle(String title) {
		// TODO Auto-generated method stub
		return driver.getTitle().contains(title);
	}
	
	

}

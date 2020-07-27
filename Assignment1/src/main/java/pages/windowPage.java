package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class windowPage {
	
	WebDriver driver;	
	
	public windowPage(WebDriver driver) {		
		this.driver = driver;
	}
	
	By Tabbed = By.cssSelector("[href*=Tabbed]");
	By Seperate = By.cssSelector("[href*=Seperate]");
	By Multiple = By.cssSelector("[href*=Multiple]");
	
	By tabButton = By.xpath("//div[@id='Tabbed']/a/button");
	By seperateButton = By.xpath("//div[@id='Seperate']/button");
	By multipleButton = By.xpath("//div[@id='Multiple']/button");
	
	public void clickTab() throws InterruptedException {
		driver.findElement(Tabbed).click();
		driver.findElement(tabButton).click();
	}
	public void clickSeperate() throws InterruptedException {
		driver.findElement(Seperate).click();
		driver.findElement(seperateButton).click();
	}
	public void clickMultiple() throws InterruptedException {
		driver.findElement(Multiple).click();
		driver.findElement(multipleButton).click();
	}
	
	public void openTabs(int i) {
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(i));
	}
	
	public void closeTab(int i) {
		openTabs(i);
		driver.close();
	}
	public String tabTitile(int i) {
		openTabs(i);
		
		return driver.getTitle();
	}
	
	
}

package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class alertPage {
		Alert alert;
	
		private WebDriver driver;
	
		public alertPage(WebDriver driver) {
			this.driver = driver;
		}
	
		By leftTabPane = By.cssSelector(".tabpane.pullleft");
		By alertOKTab = By.cssSelector("[href*=OK]");
		By alertOKandCancelTab = By.cssSelector("[href*=Cancel]");
		By alertTextboxTab = By.cssSelector("[href*=Textbox]");
	
		By alertOKDisplayBtn = By.xpath("//div[@id='OKTab']/button");
		By alertOKandCancelDisplayBtn = By.xpath("//div[@id=\"CancelTab\"]/button");
		By alertTextboxDisplayBtn = By.xpath("//div[@id=\"Textbox\"]/button");
		
		By confirmMessage = By.cssSelector("#demo");
		By confirmMessage1 = By.cssSelector("#demo1");
	
	
		public void clickOnAlertOkTab() throws InterruptedException {
			driver.findElement(alertOKTab).click();	
			driver.findElement(alertOKDisplayBtn).click();	
		}
		public void clickOnAlertOkandCancelTab() throws InterruptedException {
			driver.findElement(alertOKandCancelTab).click();	
			driver.findElement(alertOKandCancelDisplayBtn).click();	
		}
		public void clickOnAlertTextbox() throws InterruptedException {
			driver.findElement(alertTextboxTab).click();	
			driver.findElement(alertTextboxDisplayBtn).click();	
		}
		
		public String confirmMessage() {
			return driver.findElement(confirmMessage).getText();
		}
		public String confirmMessage1() {
			return driver.findElement(confirmMessage1).getText();
		}
		
		public String get_alertMessage() {
			alert = driver.switchTo().alert();		
			String alertMessage= alert.getText();
			return alertMessage;
		}
	
		public void accept_alert() {
			alert = driver.switchTo().alert();		
			alert.accept();
		}
	
		public void dismiss_alert() {
			alert = driver.switchTo().alert();		
			alert.dismiss();
		}
		
		public void sendKeys_alert(String str) {
			alert = driver.switchTo().alert();		
			alert.sendKeys(str);
		}
		
}



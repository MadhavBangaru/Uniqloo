package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingPage {
	
	
	WebDriver driver;
	
	By oneway = By.cssSelector("span#oneway");
	By roundtrip = By.cssSelector("span#roundTrip");
	By multiCity = By.cssSelector("span#multiCity");
	
	By from = By.xpath("//input[@placeholder='From']");
	By destination = By.xpath("//input[@placeholder='Destination']");
	
	By departure = By.xpath("//input[@placeholder='Departure']");
	By traveller = By.xpath("//span[contains(text(),'Traveller')]");
	By Class = By.xpath("////select[contains(@id,class)]");

	public BookingPage(WebDriver driver) {
		this.driver= driver;
		
	}
	
	public WebElement get_oneway() {
		return driver.findElement(oneway);
	}
	
	public WebElement get_roundtrip() {
		return driver.findElement(roundtrip);
	}
	public WebElement get_multiCity() {
		return driver.findElement(multiCity);
	}
	public WebElement get_fromPlace() {
		return driver.findElement(from);
	}
	public WebElement get_destinationPlace() {
		return driver.findElement(destination);
	}
	public WebElement get_departureDate() {
		return driver.findElement(departure);
	}
	
}

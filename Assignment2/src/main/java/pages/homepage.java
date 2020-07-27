package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class homepage {
	
	WebDriver driver;
	
	public homepage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By onewayTrip = By.cssSelector("span#oneway");
	By roundTrip = By.cssSelector("span#roundTrip");
	By multicityTrip = By.cssSelector("span#multiCity");
	
	By From = By.xpath("//input[@placeholder='From']");
	By Destination = By.xpath("//input[@placeholder='Destination']");
	By departureCal = By.cssSelector("input#departureCalendar");
	
	By month = By.cssSelector("[class='DayPicker-Caption']");
	By next = By.cssSelector("[class=DayPicker-NavBar] [class*=next]");
	By date = By.className("calDate");
	
	By Travellers = By.xpath("//span[contains(text(),'Traveller')]");
	By adultInc = By.cssSelector("button#adultPaxPlus");
	By childInc = By.cssSelector("button#childPaxPlus");
	
	By infantInc = By.cssSelector("button#infantPaxPlus");
	By classes = By.xpath("//select[@id='gi_class']");
	By search =By.cssSelector("button[value=Search]");
	
	public WebElement onewayTrip() {
		return driver.findElement(onewayTrip);
	}
	public WebElement roundTrip() {
		return driver.findElement(roundTrip);
	}
	public WebElement multicityTrip() {
		return driver.findElement(multicityTrip);
	}
	public WebElement From() {
		return driver.findElement(From);
	}
	public WebElement Destination() {
		return driver.findElement(Destination);
	}
	public WebElement departureCal() {
		return driver.findElement(departureCal);
	}
	public WebElement month() {
		return driver.findElement(month);
	}
	public WebElement nextView() {
		return driver.findElement(next);
	}
	
	public WebElement travellers() {
		return driver.findElement(Travellers);
	}
	
	public void SelectClass(String travelClass) {
		
		Select types = new Select(driver.findElement(classes));
		
		if(travelClass.equalsIgnoreCase("Economy")) {
			types.selectByVisibleText("Economy");
		}else if(travelClass.equalsIgnoreCase("Business")) {
			types.selectByVisibleText("Business");
		}else if(travelClass.equalsIgnoreCase("First Class")) {
			types.selectByVisibleText("First Class");
		}else if(travelClass.equalsIgnoreCase("Premium Economy")) {
			types.selectByVisibleText("Premium Economy");
		}
		
	}
	public WebElement childInc() {
		// TODO Auto-generated method stub
		return null;
	}
	public WebElement increment(String traveller) {
		// TODO Auto-generated method stub
		if(traveller.equalsIgnoreCase("adult"))
			return driver.findElement(adultInc);
		if(traveller.equalsIgnoreCase("child"))
			return driver.findElement(childInc);
		if(traveller.equalsIgnoreCase("infant"))
			return driver.findElement(infantInc);
		return null;
	}
	public void search() {
		// TODO Auto-generated method stub
		driver.findElement(search).click();
		
	}
	public void selectDate(String givenDate) {
		List<WebElement> dates = driver.findElements(date);
		int count = dates.size();
		for(int i=0;i<=count;i++) {
			
			String text = dates.get(i).getText();
			if(text.contains(givenDate)) {
				dates.get(i).click();
				break;
			}
		}
		
	}
	
	
	

}

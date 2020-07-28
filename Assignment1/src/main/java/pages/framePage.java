package pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class framePage {
	WebDriver driver ;

	public framePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	
	/*List<WebElement> frames = driver.findElements(By.tagName("iframe"));
	
	public int a = frames.size();
	WebElement frame1 = frames.get(0);
	WebElement frame2 = frames.get(1);*/
	
	WebElement frame1 = driver.findElement(By.xpath("//div[@id='Single']/iframe"));
	WebElement frame2 = driver.findElement(By.xpath("//div[@id='Muliple']/iframe"));
	
	
	By frame1btn = By.cssSelector("[href*=Single]");
	By frame2btn = By.cssSelector("[href*=Multiple]");
	
	public By frameTextbox = By.cssSelector("input[type=text]");
	
	
	public void singleFrame(String str) throws InterruptedException
	{
		driver.findElement(frame1btn).click();
		driver.switchTo().frame(frame1);		
		driver.findElement(frameTextbox).sendKeys(str);
	} 
	public void textbox2(String str) {
		driver.findElement(frame2btn).click();;
		driver.switchTo().frame(frame2);	
		driver.switchTo().frame(0);	
		driver.findElement(frameTextbox).sendKeys(str);
	} 
	
}

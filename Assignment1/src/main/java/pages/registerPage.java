package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class registerPage {

	public WebDriver driver;
	public registerPage(WebDriver driver) {
		this.driver = driver;
	}	

	By firstName = By.xpath("//input[@ng-model='FirstName']");
	By lastName = By.xpath("//input[@ng-model='LastName']");
	By adress = By.xpath("//textarea[@ng-model='Adress']");
	By email = By.xpath("//input[@type='email']");
	By phone = By.xpath("//input[@type='tel']");
	By radios = By.xpath("//input[@type='radio']");
	By hobbies = By.xpath("//input[@type='checkbox']");
	By skillset = By.id("Skills");
	By countriesList = By.id("countries");
	By submitBtn = By.id("submitbtn");
	By refreshBtn = By.cssSelector("button[value=Refresh]");
	By languages = By.id("msdd");
	By selectCountryDD = By.cssSelector("span[class*='select2-selection']");
	By countryTB = By.cssSelector("input[type=search]");




	public WebElement get_first_name() {
		return driver.findElement(firstName);
	}
	public WebElement get_last_name() {
		return driver.findElement(lastName);
	}
	public WebElement get_adress() {
		return driver.findElement(adress);
	}
	public WebElement set_email() {
		return driver.findElement(email);
	}
	public WebElement get_phone() {
		return driver.findElement(phone);
	}
	public void set_skill(String skill) {

		driver.findElement(skillset).click();
		Select skills = new Select(driver.findElement(skillset));
		skills.selectByValue(skill);

	}
	public void select_country(String countr) {


		driver.findElement(By.cssSelector("span[role='combobox'] ")).click();
		WebElement search = driver.findElement(By.cssSelector("input[type='search']"));
		search.sendKeys(countr);
		search.sendKeys(Keys.ENTER);

	}
	public void select_language(String lang) {
		driver.findElement(languages).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+lang+"')]")).click();
		driver.findElement(By.xpath("//body")).click();

	}
	public void set_country(String country) {
		Select countries = new Select(driver.findElement(countriesList));
		countries.selectByValue(country);
	}


	public void set_gender(String option) {
		List<WebElement> radiosEle =driver.findElements(By.xpath("//input[@type='radio']"));


		for(int i=0;i<radiosEle.size();i++) {

			WebElement ele = radiosEle.get(i);

			String gender = ele.getAttribute("value");

			if(gender.contains(option)) {

				ele.click();
				break;
			}

		}
	}
	public void set_hobby(String options) {
		List<WebElement> hobbiesEle = driver.findElements(hobbies);

		for(WebElement ele : hobbiesEle) {

			String hobby = ele.getAttribute("value");
			if(hobby.equalsIgnoreCase(options)) {
				ele.click();
				break;
			}
		}


	}
	public void set_DOB(String date) {
		String[] dob = date.split(" ");

		String year = dob[0]; 
		String month = dob[1];
		String day = dob[2];

		Select yearDD = new Select(driver.findElement(By.id("yearbox")));
		yearDD.selectByValue(year);

		Select monthDD = new Select(driver.findElement(By.xpath("//select[@placeholder='Month']")));    
		monthDD.selectByValue(month);

		Select dayDD = new Select(driver.findElement(By.id("daybox")));
		dayDD.selectByValue(day);




	}
	public void upload_file(String file) {

		driver.findElement(By.id("imagesrc")).sendKeys(file);

		String expectedFile = driver.findElement(By.id("imagesrc")).getAttribute("type");
		


	}
	public void set_password(String password) {
		driver.findElement(By.cssSelector("input#firstpassword")).sendKeys("password");
		
		
	}
	
	public void confirm_pass(String confirm) {
		driver.findElement(By.cssSelector("input#secondpassword")).sendKeys("confirm");
		
	}
	public WebElement submit() {
		return driver.findElement(By.xpath("//button[@type='submit']"));
		
	}
	public WebElement refresh() {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath("//button[@value='Refresh']"));
	}

}

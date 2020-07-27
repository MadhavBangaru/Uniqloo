package stepDefinations;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.homepage;
import pages.reviewpage;
import pages.selectionpage;
import resources.base;

public class stepDefination extends base{

	WebDriver driver;
	homepage h;
	selectionpage s;
	reviewpage r;
	
	@Given("^When user in on Goibibo Homepage\\.$")
	public void when_user_in_on_Goibibo_Homepage() throws Throwable {
		// Write code here that turns the phrase above into concrete action

		driver = initializeDriver();
		driver.get(prop.getProperty("Goibibo_url"));
		Assert.assertTrue(driver.getTitle().contains("Goibibo"));

	}
	@When("^user selects \"([^\"]*)\" trip$")
	public void user_selects_trip(String trip)  {
	    // Write code here that turns the phrase above into concrete actions
		
		h = new homepage(driver);
		
		if(trip.equalsIgnoreCase("oneway")) {
			h.onewayTrip().click();
		}else if(trip.equalsIgnoreCase("round")) {
			h.roundTrip().click();
		}else if(trip.equalsIgnoreCase("multi")) {
			h.multicityTrip().click();
		}
	    
	}


	@Then("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String from, String destination) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement fromTB = h.From();
		fromTB.sendKeys(""+from);
		Thread.sleep(1000);
		fromTB.sendKeys(Keys.ARROW_DOWN);
		fromTB.sendKeys(Keys.ENTER);
		
		WebElement destnTB = h.Destination();
		
		destnTB.sendKeys(""+destination);
		Thread.sleep(1000);
		destnTB.sendKeys(Keys.ARROW_DOWN);
		destnTB.sendKeys(Keys.ENTER);
	    
	}

	@Then("^user enters \"([^\"]*)\"$")
	public void user_enters(String departure) throws InterruptedException {
	    
		String[] Date = departure.split(" ");
		
		System.out.println(Date[0] + Date[1]);
		h.departureCal().click();
		
		while(!h.month().getText().contains(Date[1])) {
			h.nextView().click();
		}
		
		h.selectDate(Date[0]);
		
		
	}

	@Then("^user enters travellers \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\" type$")
	public void user_enters_travellers_and_type(String adults, String children, String infants,  String travelClass) throws Throwable {
		
		//String[] parts = travellers.split(" ");
		
		int adultCount = Integer.parseInt(adults);
		int childCount = Integer.parseInt(children);
		int infantCount = Integer.parseInt(infants); 
		
		h.travellers().click();		
		
		for(int i=1;i<adultCount;i++) {
			h.increment("adult").click();
		}
		for(int i=1;i<childCount;i++) {
			h.increment("child").click();
		}
		for(int i=1;i<infantCount;i++) {
			h.increment("infant").click();
		}
	
		h.SelectClass(travelClass);
	
	}

	@Then("^user clicks on search button$")
	public void user_clicks_on_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		
		h.search();
		//driver.findElement(By.cssSelector("button[value=Search]")).click();
	}

	@Then("^user is navigated to selection page$")
	public void user_is_navigated_to_selection_page() throws Throwable {
		s = new selectionpage(driver);
	    Assert.assertTrue(s.checkTitle("Goibibo"));	
	}
	
	@When("^user selects cheapest flight ticket$")
	public void user_selects_cheapest_flight_ticket() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    s.selectCheapest().click();
	}


	@Then("^user directed to review page$")
	public void user_directed_to_review_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
//	@Then("^user enters travellers \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\" type$")
//	public void user_enters_travellers_and_type(String arg1, String arg2, String arg3, String arg4) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^user is on selection page$")
//	public void user_is_on_selection_page() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^user selects cheapest flight ticket$")
//	public void user_selects_cheapest_flight_ticket() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^user clicks on review$")
//	public void user_clicks_on_review() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}


}

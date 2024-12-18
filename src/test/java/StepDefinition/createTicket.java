package StepDefinition;

import org.openqa.selenium.WebDriver;

import Pages.OrderGuideFirstPage;
import Pages.OrderGuideNextPage;
import Pages.SubmittedTicketPage;
import base.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class createTicket {
	
	OrderGuideFirstPage ogFirstPage;
	OrderGuideNextPage ogNextPage;
	SubmittedTicketPage ticketNumber;
	
	@Then("User fills Requestor Information")
	public void user_fills_requestor_information() {
		
		ogFirstPage=new OrderGuideFirstPage(Hooks.driver);
		
		ogFirstPage.getRequestor("Mkumar6");
		
	}

	@And("User selects Multilingual Support")
	public void user_selects_multilingual_support() throws InterruptedException {
		
		ogFirstPage=new OrderGuideFirstPage(Hooks.driver);
		ogFirstPage.getMultilingual("yes", "Bengali");
		
	}

	@And("User selects Source")
	public void user_selects_source() {
		
		ogFirstPage=new OrderGuideFirstPage(Hooks.driver);
		ogFirstPage.getSource("Outbound Call");
		
	}

	@And("User selects Reported for")
	public void user_selects_reported_for() throws InterruptedException {
		
		ogFirstPage=new OrderGuideFirstPage(Hooks.driver);
		ogFirstPage.getReportedFor("251383634");

	}

	@And("User enters Site")
	public void user_enters_site() throws InterruptedException {
		
		ogFirstPage=new OrderGuideFirstPage(Hooks.driver);
		ogFirstPage.getSite("X001@X001");

	}

	@And("User adds Description")
	public void user_adds_description() {
		
		ogFirstPage=new OrderGuideFirstPage(Hooks.driver);
		ogFirstPage.addDescription("First Test Case");
		
	}

//	@And("^User enters \"([^\"]*)\" item$")
//	public void user_enters_catalog_item(String catalogSearch) {
//		
//		ogFirstPage=new OrderGuideFirstPage(Hooks.driver);
//		ogFirstPage.getCatalog(catalogSearch);
//	}
	
	@And("^User enters \"([^\"]*)\" item$")
    public void user_enters_catalog_item(String catalogItem) throws InterruptedException {
		ogFirstPage=new OrderGuideFirstPage(Hooks.driver);
		ogFirstPage.getCatalog(catalogItem);
	}
	

	@And("User clicks on Next button")
	public void user_clicks_on_next_button() throws InterruptedException {
		
		ogFirstPage=new OrderGuideFirstPage(Hooks.driver);
		ogFirstPage.clickNextButton();
	}

	@And("User clicks on Save & Submit button")
	public void user_clicks_on_save_submit_button() {
		ogNextPage=new OrderGuideNextPage(Hooks.driver);
		ogNextPage.submitTicket();

	}

	@And("User gets the ticket number")
	public void user_gets_the_ticket_number() {
		ticketNumber= new SubmittedTicketPage(Hooks.driver);
		System.out.println(ticketNumber.getTicketNumber());
		
	}


}

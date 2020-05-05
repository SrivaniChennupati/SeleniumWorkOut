package BasicSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC009_CRM {
	
	public static void main(String[] args) throws InterruptedException
	{
		
		// Go to https://demo.1crmcloud.com/
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		
		ChromeDriver driver = new ChromeDriver();
		

		driver.get("https://demo.1crmcloud.com/");

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		//Give username as admin and password as admin
		
		driver.findElementById("login_user").sendKeys("admin");
		
		driver.findElementById("login_pass").sendKeys("admin");
		
		//Choose theme as Claro Theme
		
		WebElement themedropdown = driver.findElementById("login_theme");
		
		Select se = new Select(themedropdown);
		
		se.selectByVisibleText("Claro Theme");
		
		driver.findElementById("login_button").click();
		
		//Click on Sales and Marketting 
		
		
         wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[text()='Sales & Marketing']")));
          
         driver.findElementByXPath("//div[text()='Sales & Marketing']").click();
		
	
		
		//Click Create contacts
         
         Thread.sleep(7000);
		
	     driver.findElementByXPath("//div[text()='Create Contact']").click();
		
		//Select Title and type First name, Last Name, Email and Phone Numbers
		
	  
			WebElement element = driver.findElementById("DetailFormsalutation-input");
			
			List<WebElement> listOptions = element.findElements(By.id("DetailFormsalutation-input-label"));
			
			for (WebElement eachoption:listOptions)
				
			{
				
				if (eachoption.getText().equals("Ms."))
					
					eachoption.click();
				
				System.out.println(eachoption);
			}
			
			
			
			
		
		   driver.findElementById("DetailFormfirst_name-input").sendKeys("Srivani");
		   
		   driver.findElementById("DetailFormlast_name-input").sendKeys("Chennupati");
		   
		   driver.findElementById("DetailFormemail1-input").sendKeys("srivanichennupati@gmail.com");
		   
		   driver.findElementById("DetailFormphone_work-input").sendKeys("9108999874");
		   
		   //  Select Lead Source as "Public Relations"
		   
		   driver.findElementById("DetailFormlead_source-input").click();
		   
		   driver.findElementById("DetailFormlead_source-input").sendKeys("Public Relations");
		   
		   //Select Business Roles as "Sales"
		   
		   driver.findElementById("DetailFormbusiness_role-input").click();
		   
		   driver.findElementById("DetailFormbusiness_role-input").sendKeys("Sales");
		   
		   
		   //Fill the Primary Address, City, State, Country and Postal Code and click Save
		   
			driver.findElementById("DetailFormprimary_address_street-input").sendKeys("D 205, MGR Road, Nanganallur");
			
			driver.findElementById("DetailFormprimary_address_city-input").sendKeys("Chennai");
			
			driver.findElementById("DetailFormprimary_address_state-input").sendKeys("TamilNadu");
			
			driver.findElementById("DetailFormprimary_address_country-input").sendKeys("India");
			
			driver.findElementById("DetailFormprimary_address_postalcode-input").sendKeys("600061");
			
			driver.findElementById("DetailForm_save2").click();
			Thread.sleep(5000);
			
			// Mouse over on Today's Activities and click Meetings
			
			WebElement todayActivities = driver.findElementByXPath("(//div[@class='menu-label'])[1]");
			
			Actions builder = new Actions(driver);
			
			builder.moveToElement(todayActivities).perform();
			
			Thread.sleep(1000);
			driver.findElementByXPath("//div[text()='Meetings']").click();
			
			Thread.sleep(5000);
			
			// Click Create
			
			driver.findElementByXPath("(//button[@class='input-button first'])[1]").click();
			Thread.sleep(5000);
			
			// Type Subject as "Project Status" , Status as "Planned" 
			
			driver.findElementById("DetailFormname-input").sendKeys("Project Status");
			
			
			//Start Date & Time as tomorrow 3 pm and Duration as 1hr
			
			driver.executeScript("window.scrollBy(0, 250)");
			
			driver.findElementByXPath("//div[@id='DetailFormdate_start-input']").click();
			
			Thread.sleep(1000);
			
			
			driver.findElementByXPath("(//div[@class='grid-cell number-cell text-right day inside current selected quiet responsive']/following::div)[1]").click()
			;
			driver.findElementByXPath("(//input[@class='input-text'])[4]").clear();
			
			driver.findElementByXPath("(//input[@class='input-text'])[4]").sendKeys("15:00");
			
			driver.findElementByXPath("//div[@class='active-icon uii-accept uii-lg uii']").click();
			Thread.sleep(1000);
			driver.findElementById("DetailFormduration-time").clear();
			
			driver.findElementById("DetailFormduration-time").sendKeys("1h 00m",Keys.TAB);
			
			// Click Add paricipants, add your created Contact name and click Save
			
			driver.findElementByXPath("//button[@name='addInvitee']").click();
			
			Thread.sleep(500);
			driver.findElementByXPath("(//input[@class='input-text'])[4]").sendKeys("Pavithra");
			
			Thread.sleep(500);
			driver.findElementByXPath("(//div[@class='option-cell input-label '])[14]").click();
			
			driver.findElementByXPath("//span[@id='DetailForm_save2-label']").click();
			Thread.sleep(5000);
			String proTitle = driver.findElementByXPath("//div[@id='_form_header']").getText();
			
			//15) Go to Sales and Marketting-->Contacts
			
			WebElement salesMarketing = driver.findElementByXPath("//div[text()='Sales & Marketing']");
			
			Actions builder1 = new Actions(driver);
			
			builder1.moveToElement(salesMarketing).perform();
			
			Thread.sleep(1000);
			driver.findElementByXPath("//div[text()='Contacts']").click();
			
			Thread.sleep(5000);
			
			// search the lead Name and click the name from the result
			
			driver.findElementByXPath("//input[@id='filter_text']").sendKeys("Pavithra");
			
			Thread.sleep(500);
			
			driver.findElementByXPath("(//div[@class='menu-option single'])[15]").click();
	
			Thread.sleep(5000);
			
			//Check weather the Meeting is assigned to the contact under Activities Section.
			
			
			driver.executeScript("window.scrollBy(0, 750)");
			
			String projectName = driver.findElementByXPath("//span[@class='detailLink']").getText();
			
			if(projectName.equalsIgnoreCase(proTitle)) {
				System.out.println("The Meeting is scheduled to the created contact under activities section");
			}else {
				System.out.println("The Meeting is not scheduled to the created contact under activities section");
			}

			//close the window
			driver.close();
		}
		

		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	}




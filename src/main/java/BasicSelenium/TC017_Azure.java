package BasicSelenium;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC017_Azure {

	public static void main(String[] args) throws InterruptedException {
		
		
		    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		    
		    // set the download path in chrome using chrome preference
			
			ChromeOptions options = new ChromeOptions();
			
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			
			chromePrefs.put("download.default_directory", "C:\\testcases");

			options.setExperimentalOption("prefs", chromePrefs);
			
			options.addArguments("--disable-notifications");
			
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			
			cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
			
			ChromeDriver driver = new ChromeDriver(options);
			

			driver.get("https://azure.microsoft.com/en-in/");

			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebDriverWait wait = new WebDriverWait(driver,60);
			
			//Click on Pricing 
			
			driver.findElementByXPath("//nav[@class='nav-main']//a[text()='Pricing']").click();
			
			//Click on Pricing Calculator
			
			Thread.sleep(5000);
			
			driver.findElementByXPath("//ul[@class='linkList initial-list']/li[2]/a").click();
			
			//Click on Containers 
			
			driver.findElementByXPath("//div[@class='category-container']/button[@data-event-property='containers']").click();
			
			//Select Container Instances 
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//span[text()='Container Instances']/following-sibling::span[@class='sd-truncateText'])[2]")));
			
			driver.findElementByXPath("(//span[text()='Container Instances']/following-sibling::span[@class='sd-truncateText'])[2]").click();
			
			//Click on Container Instance Added View 
			
			//driver.findElementByXPath("//div[@class='notification active general']").click();
			
			driver.findElementById("new-module-loc").click();
			
			//Select Region as "South India" 
			

		    JavascriptExecutor jse = (JavascriptExecutor)driver;
		    
		    jse.executeScript("window.scrollBy(0,250)");
		    
		    WebElement element = driver.findElementByName("region");
		    
		    Select se = new Select(element);
		    
		    se.selectByVisibleText("South India");
		    
		    //Set the Duration as 180000 seconds 
		    
		    
		    driver.findElementByXPath("//h5[text()='Duration']/following::div[2]/input").click();
		    
		    
		    driver.findElementByXPath("//h5[text()='Duration']/following::div[2]/input").sendKeys(Keys.chord(Keys.CONTROL,"a"),"180000");
		    
		   
		    
		    //Select the Memory as 4GB 
		    
		    wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//select[@aria-label='Memory']")));
		    
		    WebElement element2 = driver.findElementByXPath("//select[@aria-label='Memory']");
		    
		  
			Select se1 = new Select(element2);
		    
		    se1.selectByVisibleText("4 GB");
		    
		    //Enable SHOW DEV/TEST PRICING 
		    
		    driver.findElementByXPath("//span[text()='Show Dev/Test Pricing']").click();
		    
		    //Select Indian Rupee  as currency 
		    
		    WebElement element3 = driver.findElementByXPath("//select[@class='select currency-dropdown']");
		    
            Select se2 = new Select(element3);
		    
		    se2.selectByValue("INR");
		    
		    //Print the Estimated monthly price 
		    
		    String Estimated = driver.findElementByXPath("//span[text()='Monthly cost']/following-sibling::span/span").getText();
			
			System.out.println("Estimated Monthly Cost is" +Estimated);
			
			//Click on Export to download the estimate as excel
			
			driver.findElementByXPath("(//div[@class='column large-6 calculator-actions']//button)[1]").click();
			
			//Verify the downloded file in the local folder 
			
			 File f = new File("C:\\testcases"); 
			
			  if(f.exists() && f.isDirectory())
				  
			  {
				  
				  System.out.println("File is downloaded successfully in the local folder");
			  }
			
			
		//Navigate to Example Scenarios and Select CI/CD for Containers 
			  
			  WebElement element5 = driver.findElementByXPath("//li[@id='solution-architectures-picker']/a");
			  
			  JavascriptExecutor executor1 = (JavascriptExecutor)driver;
				
			executor1.executeScript("arguments[0].click();", element5);
			  
			  WebElement element6 = driver.findElementByXPath("//div[@class='row row-size2 column']/button[@title='CI/CD for Containers']");
			  
			  JavascriptExecutor executor2 = (JavascriptExecutor)driver;
				
			executor2.executeScript("arguments[0].click();", element6);
		
		
		     //Click Add to Estimate 
			  
		   WebElement element7 = driver.findElementByXPath("//div[@class='row row-size0 column']/button[text()='Add to estimate']");
		
		   JavascriptExecutor executor3 = (JavascriptExecutor)driver;
			
			executor3.executeScript("arguments[0].click();", element7);
		
		//Change the Currency as Indian Rupee 
		
		 Thread.sleep(10000);
		 
		 
		 WebElement element4 = driver.findElementByXPath("//select[@class='select currency-dropdown']");
		 
		 Select se3 = new Select(element4);
		 
		 se3.selectByValue("INR");
		 
		 //Enable SHOW DEV/TEST PRICING 
		 
		 
		driver.findElementByXPath("//span[text()='Show Dev/Test Pricing']").click();
		
		//Export the Estimate 
		
		
		 driver.findElementByXPath("(//div[@class='column large-6 calculator-actions']//button)[1]").click();
		 
		 
		 //Verify the downloded file in the local folder
		 
		 File f1 = new File("C:\\testcases"); 
			
		  if(f1.exists() && f.isDirectory())
			  
		  {
			  
			  System.out.println("File is downloaded successfully in the local folder");
		  }
		 
			  
			  
			  
			  

	}

}

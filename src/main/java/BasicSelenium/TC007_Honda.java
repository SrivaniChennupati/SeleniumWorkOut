package BasicSelenium;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;


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

public class TC007_Honda {

	public static void main(String[] args) throws InterruptedException {

		// Go to https://www.honda2wheelersindia.com/

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		Map<String, String> map = new LinkedHashMap<String, String>();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.honda2wheelersindia.com/");

		driver.findElementByXPath("//button[@class='close']").click();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on scooters and click dio

		driver.findElementByXPath("(//a[text()='Scooter'])[1]").click();

		driver.findElementByXPath("(//div[@class='owl-item']//a)[4]").click();

		// Click on Specifications and mouseover on ENGINE

		driver.findElementByLinkText("Specifications").click();

		Thread.sleep(5000);

		WebElement Engine = driver.findElementByLinkText("ENGINE");

		Actions builder = new Actions(driver);

		builder.moveToElement(Engine).perform();

		// Get Displacement value

		WebDriverWait wait = new WebDriverWait(driver, 60);

		wait.until(ExpectedConditions
				.visibilityOf(driver.findElementByXPath("//div[@class='engine part-2 axx']//span[text()='109.51cc']")));

		String displacementvalue = driver
				.findElementByXPath("//div[@class='engine part-2 axx']//span[text()='109.51cc']").getText()
				.replaceAll("//D", "").substring(0, 4);

		double Ddisplacemetvalue1 = Double.parseDouble(displacementvalue);

		System.out.println("Displacement Value of Dio" + Ddisplacemetvalue1);

		// Go to Scooters and click Activa 125

		driver.findElementByLinkText("Scooter").click();

		Thread.sleep(6000);

		driver.findElementByXPath("(//div[@class='owl-item']//a)[6]").click();

		// Click on Specifications and mouseover on ENGINE

		Thread.sleep(5000);

		driver.findElementByXPath("//a[text()='Specifications']").click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//a[text()='ENGINE']")));

		WebElement Engine1 = driver.findElementByXPath("//a[text()='ENGINE']");

		Actions bilder1 = new Actions(driver);

		bilder1.moveToElement(Engine1).perform();

		// Get Displacement value

		wait.until(ExpectedConditions
				.visibilityOf(driver.findElementByXPath("//div[@class='engine part-4 axx']//span[text()='124 cc']")));

		String displacemetvalue1 = driver.findElementByXPath("//div[@class='engine part-4 axx']//span[text()='124 cc']")
				.getText().replaceAll("\\D", "");

		double Ddisplacemetvalue2 = Double.parseDouble(displacemetvalue1);

		System.out.println("Displacement value of Activa is " + displacemetvalue1);

		// Compare Displacement of Dio and Activa 125 and print the Scooter name having
		// better Displacement.

		if (Ddisplacemetvalue1 > Ddisplacemetvalue2)

		{

			System.out.println("Dio is having Better Displacement vale");

		}

		else {
			System.out.println("Activa 125 is having Better Displacement vale");

		}

		// Click FAQ from Menu

		driver.findElementByXPath("(//a[text()='FAQ'])[1]").click();

		// Click Activa 125 BS-VI under Browse By Product

		driver.findElementByXPath("//div[@class='home-box about-box tag']//a[text()='Activa 125 BS-VI']").click();

		// Click Vehicle Price

		wait.until(ExpectedConditions
				.visibilityOf(driver.findElementByXPath("(//i[@class='fa fa-angle-right']/parent::a)[6]")));

		driver.findElementByXPath("(//i[@class='fa fa-angle-right']/parent::a)[6]").click();

		// Make sure Activa 125 BS-VI selected and click submit

		WebElement element = driver.findElementById("ModelID6");

		Select se = new Select(element);

		String selectedscootername = se.getFirstSelectedOption().getText();

		System.out.println("Selected scooter name is " + selectedscootername);

		try {
			if (selectedscootername.contains("Activa 125 BS-VI"))

			{

				driver.findElementByXPath("(//div[@class='col-md-2 col-sm-2 col-xs-12']//button[@type='button'])[6]")
						.click();

				System.out.println("Clicked on submit button");
			}

		} catch (Exception NoSuchElementException)

		{

			System.out.println("Element not found ");
		}

		// click the price link

		Thread.sleep(4000);

		driver.findElementByLinkText("Click here to know the price of Activa 125 BS-VI.").click();

		// Go to the new Window and select the state as Tamil Nadu and city as Chennai

		Set<String> set = driver.getWindowHandles();

		List<String> list = new ArrayList<String>();

		list.addAll(set);

		driver.switchTo().window(list.get(1));

		WebElement state = driver.findElementById("StateID");

		Select se1 = new Select(state);

		se1.selectByVisibleText("Tamil Nadu");

		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("CityID")));

		WebElement City = driver.findElementById("CityID");

		Select se2 = new Select(City);

		Thread.sleep(7000);

		se2.selectByVisibleText("Chennai");

		// Click Search

		driver.findElementByXPath("//button[text()='Search']").click();

		// Print all the 3 models and their prices
		
		
		
		
		
		List<WebElement> list2 = driver.findElementsByXPath("//table[@id='gvshow']//td[contains(text(),'ACTIVA 125')]");
		
		System.out.println(list2.size());
		
		
		for (int i=0;i<=list2.size()-1;i++)
			
		{
			        
			
			
			String text = list2.get(i).getText();
			
			
			String text2 = driver.findElementByXPath("(//table[@id='gvshow']//td[contains(text(),'ACTIVA 125')]/following-sibling::td)['"+i+"']").getText();
			
			map.put(text, text2);
		}
		
		
	
		
		  for ( Entry<String,String> eachEntry:map.entrySet())
		  
		  {
		  
		  System.out.println(eachEntry.getKey() +"......>"+ eachEntry.getValue()); 
		  }
		 

	}

}

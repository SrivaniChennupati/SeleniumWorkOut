package BasicSelenium;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		
		
		  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			
			ChromeDriver driver = new ChromeDriver();
			
			driver.get("https://www.makemytrip.com");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.findElementByXPath("(//a[@class='makeFlex hrtlCenter column'])[1]").click();
			
			Thread.sleep(4000);
			
			driver.findElementByXPath("//span[text()='City / Hotel / Area / Building']").click();
			
			Thread.sleep(4000);
			
			driver.findElementByXPath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']").sendKeys("Goa");
			
			driver.findElementByXPath("//p[text()='Goa, India']").click();
			
			Thread.sleep(3000);
			
			driver.findElementById("checkin").click();
			
			WebDriverWait wait = new WebDriverWait(driver,30);
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//div[contains(text(),'15')])[2]")));

			String text = driver.findElementByXPath("(//div[contains(text(),'15')])[2]").getText();
			
			System.out.println(text);
			
			Thread.sleep(4000);
			
			driver.findElementByXPath("(//div[contains(text(),'15')])[2]").click();
			
			int checkout = Integer.parseInt(text)+5 ;
			
		
			driver.findElementByXPath("(//div[contains(text(),'"+checkout+"')])[2]").click();
			
			
			driver.findElementById("guest").click();
			
			driver.findElementByXPath("(//ul[@class='guestCounter font12 darkText']/li)[2]").click();
			
			driver.findElementByXPath("(//ul[@class='guestCounter font12 darkText']/li)[14]").click();
			
			driver.findElementByXPath("//button[text()='APPLY']").click();
			
			driver.findElementByXPath("//button[text()='Search']").click();
			
			Thread.sleep(4000);
			
			driver.findElementByXPath("//div[@class='mmBackdrop wholeBlack']").click();
			
		
			
			WebDriverWait mywait = new WebDriverWait(driver,60);
			
			mywait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//label[text()='Baga']")));
			 
			
			driver.findElementByXPath("//label[text()='Baga']").click();
			
			
            WebDriverWait mywait1 = new WebDriverWait(driver,60);
			
			mywait1.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//label[text()='5 Star']")));
			
			driver.findElementByXPath("//label[text()='5 Star']").click();
			
			
			driver.findElementByXPath("//span[text()='The Park Baga River Goa']").click();
			
			Set<String> set = driver.getWindowHandles();
			
			List<String> list =  new ArrayList<String>();
			
			list.addAll(set);
			
			driver.switchTo().window(list.get(1));
			
			String text2 = driver.findElementByXPath("//h1[text()='The Park Baga River Goa']").getText();
			
			System.out.println(text2);
			
			driver.findElementByXPath("(//span[text()='MORE OPTIONS'])[2]").click();
			
			driver.findElementByXPath("(//span[text()='SELECT'])[1]").click();
			
			driver.findElementByXPath("//span[@class='close']").click();
			
			
			
			
			
	
			
			
			
		
			
			
			
		

	}

}

package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class erailCA1 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		//ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("MAS",Keys.ENTER);
		Thread.sleep(1000);
		
		
	WebElement to = driver.findElement(By.id("txtStationTo"));
	to.clear();
	to.sendKeys("CBE",Keys.ENTER);
	Thread.sleep(1000);
	
	driver.findElement(By.id("chkSelectDateOnly")).click();
	
	List<WebElement> trainEles = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//td[2]/a"));
	
	List<String> trainNames = new ArrayList<String>();
	for (WebElement trainEle : trainEles) {
		trainNames.add(trainEle.getText());
	}
	
	Set<String> trains = new HashSet<String>(trainNames);
	
	if(trainNames.size() == trains.size()) {
		System.out.println("No Duplicates");
	} else {
		System.out.println("Duplicates are present");
	}
	

	
	
	}		
}

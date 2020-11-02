package TestVagrant.TestVagrant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestVagrant.utility.Constants;
import TestVagrant.utility.Executor;

public class WeatherWebTests {
	
	WebDriver driver = Executor.getDriver();
	
	@Test
	public void getWeather() throws InterruptedException {
		driver.navigate().to(Constants.URL);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//a[contains(text(),'No Thanks')]")));
		driver.findElement(By.xpath("//a[contains(text(),'No Thanks')]")).click();
		driver.findElement(By.xpath("//a[@id ='h_sub_menu']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'WEATHER')]")).click();
		driver.findElement(By.id("searchBox")).sendKeys("Karnal");
		Thread.sleep(3000);
		driver.findElement(By.xpath("*//label[contains(text(),'Karnal')]")).click();
		WebElement weatherText = driver.findElement(By.xpath("//div[@class='outerContainer' and @title='Karnal']"));
		System.out.println(weatherText.getText());
		String temperature = weatherText.getText();
		String celcius = temperature.substring(0,4);
		System.out.println("------------" + celcius);
		
		driver.findElement(By.xpath("//a[@title='Zoom in']")).click();
		Thread.sleep(3000);
		weatherText.click();
		//driver.findElement(By.xpath("//a[@title='Zoom in']")).click();
		//driver.findElement(By.xpath("//a[@title='Zoom in']")).click();
		
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//div[@class='cityText' and contains(text(),'Karnal')]")).click();
		WebElement detailedWeather =driver.findElement(By.xpath("//div[@class='leaflet-popup-content']"));
		String detailedWeatherText = detailedWeather.getText();
		String [] arr = detailedWeatherText.split(":,/");
		System.out.println(Arrays.toString(arr));
		//System.out.println(detailedWeather.getText());
	}
	
	
	@Test
	public void getString() {
		String a = "Karnal, Haryana\n" + 
				"Condition : Clear\n" + 
				"Wind: 4.44 KPH Gusting to 4.82 KPH\n" + 
				"Humidity: 18%\n" + 
				"Temp in Degrees: 29\n" + 
				"Temp in Fahrenheit: 84".trim();
		String [] arr = a.split(":|\\,|\\\n");
		HashMap<String, String> hm = new HashMap<String, String>();
		for (int i =0;i<arr.length-1;) {
			hm.put(arr[i], arr[i+1]);
			i = i+2;
			

		}
		for (Map.Entry hmp : hm.entrySet()) {
			System.out.println(hmp.getKey().toString().trim());
			System.out.println(hmp.getValue().toString().trim());
		}
		System.out.println(hm.get("Condition "));

	}

}

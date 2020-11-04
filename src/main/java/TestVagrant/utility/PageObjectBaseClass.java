package TestVagrant.utility;

import org.openqa.selenium.WebDriver;

public class PageObjectBaseClass {
	
	WebDriver driver;
	
	public PageObjectBaseClass(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}

}

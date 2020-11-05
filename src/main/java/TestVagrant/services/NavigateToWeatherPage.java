package TestVagrant.services;

import TestVagrant.pageObjects.HomePageObjects;
import TestVagrant.utility.TestsBaseClass;

public class NavigateToWeatherPage  extends TestsBaseClass{
	
	
	public void getWeatherPage(HomePageObjects homePageObjects) {
		
		homePageObjects.waitForElement(homePageObjects.getnewsAlertPopup());
		homePageObjects.clickOnNewsAlertPopup();
		homePageObjects.clickOnSubMenuDots();
		homePageObjects.clickOnWeatherLink();
}
}
package TestVagrant.utility;

public class TemperatureComparator {
	
	static int TemperatureMinThreshold = Integer.parseInt(PropertyFileReader.getConfigProperty("TEMPERATURE_MINTHRESHOLD"));
	static int TemperatureMaxThreshold = Integer.parseInt(PropertyFileReader.getConfigProperty("TEMPERATURE_MAXTHRESHOLD"));

	
	public static void getTemperatureDifferenceThreshold(int webTemperature, int apiTemperature ) throws Exception {
		
		System.out.println("Temperature from NdtvWebSite " + webTemperature);
		System.out.println("Temperature from weatherAPI "+ apiTemperature);
		int differenceInTemperature = webTemperature - apiTemperature;
		System.out.println("Difference in temperature " + differenceInTemperature);
		// Condition to check the difference lies in between the threshold
		if (differenceInTemperature >= TemperatureMinThreshold &&  differenceInTemperature <= TemperatureMaxThreshold) {
			System.out.println("+++++ Temperature is within given Threshold +++++");
		}
		else {
			throw new ArithmeticException("+++++++++ Temperature is not in given Threshold +++++++++++");
		}
		
	}

}

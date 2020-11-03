package TestVagrant.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
		static Properties prop = new Properties();
		static FileInputStream input = null;
		
		public static String getConfigProperty(String key) {
			
			try {
				input = new FileInputStream("config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				prop.load(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return prop.getProperty(key);
		}
		
	

}

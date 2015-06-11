package javaBasic;

import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties configProperties = new Properties();
		try {
			configProperties.load(PropertiesTest.class.getClassLoader()
					.getResourceAsStream("config.properties"));
			String property = configProperties.getProperty("name");
			System.out.println(property);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

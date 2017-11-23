package Com.smartshop2.Appium_SmartTests2.helper;

/**
 * Utility to instruct testNG to rerun failed tests a given amount
 */
public class SystemPropertyReader {
	
	public static String readStringProperty(String key, String defaultValue) {
		final String property;
		String tmp = System.getProperty(key);
		if (tmp != null && !tmp.isEmpty()) {
			property = tmp;
		}else {
			property = defaultValue;
		}
		System.out.println(key + " = " + property);
		return property;
	}
	
	public static Integer readIntegerProperty(String key, Integer defaultValue) {
		Integer property = defaultValue;
		String tmp = System.getProperty(key);
		if (tmp != null && !tmp.isEmpty()) {
			try{
				property = Integer.parseInt(tmp);
				} catch (Exception e) {
					
				}
		}
		System.out.println(key + " = " + property);
		return property;
	}

}

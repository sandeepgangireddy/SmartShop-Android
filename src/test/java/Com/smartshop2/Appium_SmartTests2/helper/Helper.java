package Com.smartshop2.Appium_SmartTests2.helper;

import java.util.Random;

/**
 * Collection of static utility methods
 * @author alessandro.candolini
 */
public class Helper {

	/**
	 * Default Sleep duration in milliseconds
	 */
	private static final Integer DELAY_IN_MILLISECONDS = 2000;
	
	/**
	 * Default long Sleep duration in milliseconds
	 */
	private static final Integer LONG_DELAY_IN_MILLISECONDS = 5000;
	
	/**
	 * Default short Sleep duration in milliseconds
	 */
	private static final Integer SHORT_DELAY_IN_MILLISECONDS = 500;
	
	/**
	 * Sleeps DELAY_IN_MILLISECONDS
	 */
	public static void delay() {
		sleep(DELAY_IN_MILLISECONDS);
	}

	/**
	 * Sleeps LONG_DELAY_IN_MILLISECONDS
	 */
	public static void longDelay() {
		sleep(LONG_DELAY_IN_MILLISECONDS);
	}
	
	/**
	 * Sleeps SHORT_DELAY_IN_MILLISECONDS
	 */
	public static void shortDelay() {
		sleep(SHORT_DELAY_IN_MILLISECONDS);
	}
	
	/**
	 * Wrapper for running Thread.sleep
	 * @param milliseconds Delay in milliseconds
	 */
	private static void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);                 
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
	/**
	 * Routine to generate a random integer [{@code min}, {@code max}]
	 * @param min minumum integer in range
	 * @param max maximum integer in range
	 * @return uniformly idenntically distributed pseudo random integers in range between @min and @max 
	 */
	public static Integer randomInt(int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

	/**
	 * Convert a string with alphanumeric characters to a new string 
	 * containing only numeric characters (including the "." for decimal digits)
	 * @param input aphanumeric string
	 * @return input string stripped from all non-numeric characters
	 */
	private static String stripNonNumericCharacters(String input) {
		return input.replaceAll("[^\\d.]", "");
	}

	/**
	 * @param quantityString String of the item quantity in trolley
	 * @return Integer quantity
	 */
	public static Integer extractQuantityFromAddTrolleyButton(String quantityString) {
		Integer quantity = 0;
		try {
			String tmp = stripNonNumericCharacters(quantityString);
			quantity = Integer.parseInt(tmp);
		} catch (NumberFormatException e) {

		}
		return quantity;
	}


	/**
	 * @param text Text in trolley footer with the total price
	 * @return the amount as double
	 */
	public static Double extractTotalAmountFromTrolleyFooter(String text) {
		Double quantity = 0.0;
		try {
			String quantityString = stripNonNumericCharacters(text);
			quantity = Double.parseDouble(quantityString.replace(" in trolley", ""));
		} catch (NumberFormatException e) {

		}
		return quantity;
	}

	/**
	 * @param price string of price
	 * @return amount as double
	 */
	public static Double extractAmountFromPriceString(String price) {
		Double amount = 0.0;
		try {
			String numericString = stripNonNumericCharacters(price);
			amount = Double.parseDouble(numericString);
		} catch (NumberFormatException e) {

		}
		return amount;
	}

	public static Integer extractNumberItemsInTrolleyIOS(String quantityString) {
		Integer quantity = 0;
		try {
			String tmp = stripNonNumericCharacters(quantityString);
			quantity = Integer.parseInt(tmp);
		} catch (NumberFormatException e) {

		}
		return quantity;
	}
	

	public static String generateRandomEmailAddress(int numberOfUsers, String prefix, String provider){
		Random rand = new Random();
		String email = prefix + Integer.toString(rand.nextInt(numberOfUsers))  + provider; // create email with random number
		return email;
	}

}

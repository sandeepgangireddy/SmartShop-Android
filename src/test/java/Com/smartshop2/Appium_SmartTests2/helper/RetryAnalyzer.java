package Com.smartshop2.Appium_SmartTests2.helper;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Utility to instruct testNG to rerun failed tests a given amount
 * of times. This should make it easier to detect false positive reports.
 * 
 * Reference: http://stackoverflow.com/questions/25781098/is-there-anyway-to-rerun-a-test-class-when-it-fails
 * 
 * @author alessandro.candolini
 */
public class RetryAnalyzer implements IRetryAnalyzer{

	/**
	 * Maximum number of times a failing test will be executed again before reporting the failure.
	 * If 0, the tests will never execute again when a failure occurs.
	 */
	private final int maximumNumberOfTrials;

	/**
	 * Keep track of the number of times a test has been executed again
	 */
	private int retryCount;
	
	/**
	 * Default constructor. {@link RetryAnalyzer#maximumNumberOfTrials} set to zero by default
	 */
	public RetryAnalyzer() {
		this(0);
	}

	/**
	 * COnstructor with arguments
	 * @param maximumNumberOfTrials desire number of attempts to retry the failing test before marking it as failed
	 */
	public RetryAnalyzer(int maximumNumberOfTrials) {
		this.maximumNumberOfTrials = maximumNumberOfTrials;
		this.retryCount = 0;
	}

	@Override
	public boolean retry(ITestResult result) {
		if(retryCount < maximumNumberOfTrials) 
		{ 
			retryCount++; 
			return true; 
		} else {
			return false;
		}
	} 
} 

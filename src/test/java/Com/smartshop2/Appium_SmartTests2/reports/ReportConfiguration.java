package Com.smartshop2.Appium_SmartTests2.reports;

import org.testng.Reporter;

public class ReportConfiguration {
	
	/**
	 * Boolean flag to enable/disable printing manual steps in the html reports
	 */
	private static final Boolean ENABLE_STEPS_IN_REPORT = true;

	/**
	 * Keep track automatically of the number of steps.
	 */
	private int stepCounter;
	
	/**
	 * Default constructor.
	 * Setting number of steps to zero.
	 */
	public ReportConfiguration() {
		super();
		this.stepCounter =0;
	}

	/**
	 * Reports the detailed test step with step summary and details
	 *
	 * @param stepText the test step summary text
	 * @param stepOutput the step output text
	 */
	public void report(String stepText, String stepDetails) {
		if ( ENABLE_STEPS_IN_REPORT ) {
			stepCounter++;
			Reporter.log("<p>" + stepCounter + ". " + "<b>" + stepText + ":</b>" + " " + stepDetails + "</p>", true);
		}
	}

}

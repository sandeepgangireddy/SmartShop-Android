package Com.smartshop2.Appium_SmartTests2.reports;

import java.util.List;

import org.testng.ITestResult;
import org.uncommons.reportng.ReportNGUtils;

public class ReportUtils extends ReportNGUtils  {

	@Override
	public List<String> getTestOutput(ITestResult result) {

        List<String> output = super.getTestOutput(result);
        
        String screenshot = (String)result.getAttribute("screenshot");
        if (screenshot != null) {
		output.add("<img alt=\"screenshot\" src=\"" + screenshot + "\" height=\"420\" width=\"auto\"/>");
        }

        return output;
    }
}

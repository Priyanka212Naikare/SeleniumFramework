package Academy;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportObject;
import resources.base;

public  class Listeners extends base implements ITestListener
{
	ExtentTest extentTest;
	ExtentReports extentReport=ExtentReportObject.getExtentReportObject();
	ThreadLocal <ExtentTest> extent=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		
	      extentTest=extentReport.createTest(result.getMethod().getMethodName());
		  extent.set(extentTest);
		  System.out.println("onTestStart");
	}

	public void onTestSuccess(ITestResult result) {
	   	   extent.get().log(Status.PASS,"Testcase passed");
	}

	public void onTestFailure(ITestResult result) {
		extent.get().fail(result.getThrowable());
		String methodName=result.getMethod().getMethodName();
		WebDriver driver=null;
		 try {
			driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			extent.get().addScreenCaptureFromPath(getScreenshotPath(methodName, driver));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentReport.flush();
		
	}

}

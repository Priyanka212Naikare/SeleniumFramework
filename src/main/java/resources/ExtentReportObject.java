package resources;

import java.util.Date;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReportObject {
	
	static ExtentReports extentReport;
	public static ExtentReports getExtentReportObject()
	{
		
		Date date=new Date();
		Long time=date.getTime();
		
		String currentWorkingDir=System.getProperty("user.dir");
		String dateTime=time.toString();
		String reportFileName=String.format("%s/reports/rediffmail_%s.html", currentWorkingDir,dateTime);
		System.out.println("file Name:"+reportFileName);
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportFileName);
		
		reporter.config().setDocumentTitle("Sanity testing report");
		reporter.config().setReportName("Rediffmail");
		
		extentReport=new ExtentReports();
		extentReport.attachReporter(reporter);
		
		return extentReport;
		
		
	}

}

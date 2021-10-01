package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class base {
	
	WebDriver driver;
	public Properties prop;
	String browserType;
	
	
	public WebDriver initializeDriver() throws Exception
	{
	String filePath=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
	FileInputStream fin=new FileInputStream(filePath);
	 prop= new Properties();
	 prop.load(fin);
	 
	// String browserType=System.getProperty("browser");
	// System.out.println("browser:"+ browserType);
	 browserType= prop.getProperty("browser");
	  if(browserType.trim().equalsIgnoreCase("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		  driver=new ChromeDriver();
	  }
	   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	   return driver;
	  
	}
	
	public String getScreenshotPath(String testcaseName,WebDriver driver) throws IOException
	{
		File tmpfile,destFile;
		String currentDir=System.getProperty("user.dir");
		String fileName=String.format("%s\\screenshots\\%s.png", currentDir,testcaseName);
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		   tmpfile=screenshot.getScreenshotAs(OutputType.FILE);
		   destFile=new File(fileName);
		   FileUtils.copyFile(tmpfile,destFile);
		 return fileName;
		
	}

}

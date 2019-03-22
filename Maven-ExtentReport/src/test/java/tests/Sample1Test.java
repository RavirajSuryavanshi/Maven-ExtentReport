package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
/*
 * steps to work with Extent Report
 * 1. Add Extent Report libraries to the project
 *    (we can add jars or maven dependancies)
 * 2. Create References of ExtentReport methods
 * 3. Use ExtentReport methods
 *    (log,info,pass,fail,etc..)
 * 4. Run and Validate      
 */
public class Sample1Test
{
  public static void main(String[] args) throws Exception 
  {
	  // start the reporter(extent.html)
	  ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("extent.html");
	  
	  // create ExtentReports and attach report(s)
	  ExtentReports extent=new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  
	  // create a toggle for the given test and adds
	  // all the log events under it
	  ExtentTest test1 = extent.createTest("Valid Login Test");
	
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harshith\\Desktop\\Advanced selenium\\MavenWithExtentReport\\src\\main\\resources\\chromedriver.exe");
	 test1.log(Status.INFO,"Starting the test case.");
	 
	 WebDriver driver=new ChromeDriver();
	 test1.pass("Browser launch success");
	 
	 driver.get("https://demo.actitime.com/login.do");
	 test1.pass("Navigated to ActiTIME login page");
	 
	 driver.findElement(By.id("username")).sendKeys("admin");
	 test1.pass("Entered Username admin into UN text field");
	 
	 driver.findElement(By.name("pwd")).sendKeys("manager");
	 test1.pass("Entered Password into PW text field");
	 
	 driver.findElement(By.xpath("//div[.='Login ']")).click();
	 test1.pass("Clicked on Login Button");
	 
	 Thread.sleep(2000);
	 
	 driver.close();
	 test1.fail("Closed the browser");
	 
	 test1.info("Test Completed..");
	 
	// to log the messages on the report 
	 extent.flush();
  }
}

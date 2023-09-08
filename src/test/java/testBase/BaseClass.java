package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb; // used to read the config file
	
	@BeforeClass(groups = {"Regression", "Sanity", "Master"})// this groups are used when we have to run the test cases in group
	@Parameters("browser")
	public void setUp(String br)
	{
		
		rb=ResourceBundle.getBundle("config");//we specified the property file name. This is just to load the config file here.
		logger=LogManager.getLogger(this.getClass());//this.getClass() will get the current name of the class for which we are logging the log.
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
		if(br.equals("chrome")) {
		driver = new ChromeDriver();
		}else if (br.equals("edge")) {
			driver = new EdgeDriver();	
		}else {
			driver=new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//driver.get("https://demo.opencart.com/index.php");
		driver.get(rb.getString("appURL"));
	}
	
	@AfterClass(groups = {"Regression", "Sanity", "Master"})// this groups are used when we have to run the test cases in group
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString() 
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;		
	}
	
	public String randomNumbers() 
	{
		String generatedString1 = RandomStringUtils.randomNumeric(10);
		return generatedString1;		
	}
	
	public String captureScreen(String tname) throws IOException 
	{
		/*
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhss");
		Date dt = new Date();
		String timeStamp = df.format(dt);
		*/
		String timeStamp = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String target = System.getProperty("user.dir")+"/Screenshots/" + tname + "_" + timeStamp + ".png";
		
		try {
		FileUtils.copyFile(source, new File(target));
		}catch(Exception e) {
			e.getMessage();
		}
		return target;
	}
}

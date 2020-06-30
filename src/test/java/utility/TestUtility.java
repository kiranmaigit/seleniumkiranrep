package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUtility {
		
		//properties
		public RemoteWebDriver driver;
		
		//constructor methods
		public TestUtility()
		{
			driver=null;
		
		}
		
		//operational methods
		public RemoteWebDriver openBrowser(String b)
		{
			if(b.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				
			}
			else if(b.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				
			}
			else if(b.equalsIgnoreCase("edge"))
			{
				
				WebDriverManager.edgedriver().setup();
				EdgeOptions e=new EdgeOptions();
				e.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge Beta\\Application\\msedge.exe");
				driver=new EdgeDriver();
				
			}
			else if(b.equalsIgnoreCase("opera"))
			{
				WebDriverManager.operadriver().setup();
				driver=new OperaDriver();
				
			}
			
			else
			{
				WebDriverManager.iedriver().setup();
				driver=new InternetExplorerDriver();	
				
			}
			return(driver);
		}
		public void launchSite(String url) 
		{
			driver.get(url);
			driver.manage().window().maximize();
		}
		public String screenShot() throws Exception
		{
			SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
			Date dt=new Date();
			String fn=sf.format(dt)+".png";
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File(fn);
			FileHandler.copy(src,dest);
			return (dest.getAbsolutePath());
		}
	    public void closeSite()
	    {
	    	driver.quit();
	    }
		
	


	

}

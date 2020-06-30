package gluecode;

import java.io.FileReader;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Loginpage;
import utility.TestUtility;

public class Stepdefinition {

	 public String projectpath;
	 public RemoteWebDriver driver;
	 public TestUtility tu;
     public Scenario s;
     public Loginpage lp;
     public Properties p;
     public WebDriverWait w;
     
  @Before
  public void method1(Scenario s) throws Exception
  {
	  this.s=s;
	  
	 
	  tu = new TestUtility(); 
  }

  @Given("^launch site using \"(.*)\"$")
  public void method2(String x)
  {
	 driver=tu.openBrowser(x);
	 lp=new Loginpage(driver);
	 w=new WebDriverWait(driver,20);
	 tu.launchSite("https://www.facebook.com");
	 w.until(ExpectedConditions.visibilityOf(lp.uid));
  }
  @When("^login id \"(.*)\" and password is \"(.*)\"$")
  public void method3(String x,String y)
  {
	  lp.uidfill(x, y);
	  lp.clicknext();
	  
  }
  @Then("^home page wiith tittle \"(.*)\" should be displayed$")
  public void method4(String x)
  {
	  
	  String actual=driver.getTitle();
	  System.out.println(actual);
	 if(actual.contains(x))
	  {
		  s.write("facebook login test passed");
		  
	  }
	  else
	  {
		  s.write("facebook login test failed");
		  
	  }
	  tu.closeSite();
  }
  
  
  
  
  
  
  
  
  

}

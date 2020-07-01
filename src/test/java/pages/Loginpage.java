package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	public RemoteWebDriver driver;
	
	@FindBy(how = How.ID,using="email")
	public WebElement uid;
	
	@FindBy(how= How.ID,using= "pass")
	public WebElement pass;
    
	@FindBy(how= How.XPATH,using= "//input[@type='submit']")
	public WebElement submit;
	@FindBy(how= How.XPATH,using= "//input[@type='submit']")
	public WebElement submit1;
	
	public Loginpage(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	  
	}
	
	public void uidfill(String x,String y)
	{
	 uid.sendKeys(x);
	 pass.sendKeys(y);
	}
	public void clicknext()
	{
		submit.click();
	}
	
	
	
	
}

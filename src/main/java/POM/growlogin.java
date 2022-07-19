package POM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.utilityClass;

public class growlogin {
	
	@FindBy(xpath="(//span[@class='absolute-center'])[1]")private WebElement loginbtn;
	@FindBy(id="login_email1")private WebElement id;
	@FindBy(xpath="//span[contains(text(),'Continue')]")private WebElement continueclick;
	@FindBy(id="login_password1")private WebElement pass;
	@FindBy(xpath="//span[contains(text(),'Submit')]")private WebElement submitbtn;
	@FindBy(xpath="//input[@autocomplete='new-password']")private WebElement pin;

	public growlogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginbtnclick()
	{   
		loginbtn.click();
	}

   
	public void getemail() throws EncryptedDocumentException, IOException
	{  String uid1=utilityClass.propertyAccess(0, 0);
		 id.sendKeys(uid1);
	}
	
	public void clickoncontinue()
	{
		continueclick.click();
	}
	public void sendpass() throws EncryptedDocumentException, IOException
	{  String pass1=utilityClass.propertyAccess(1, 0);
		pass.sendKeys(pass1);
	}
	
	public void submitbtnclick()
	{
		submitbtn.click();
	}
	
	public void sendpin() throws EncryptedDocumentException, IOException
	{   String pin2=utilityClass.propertyAccess(2, 0);
		pin.sendKeys(pin2);
	}
	
}

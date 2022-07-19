package Testclass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Baseclass.baseclass;
import Baseclass.listener;
import POM.growlogin;
import Utility.utilityClass;
import junit.framework.Assert;

@Listeners(Baseclass.listener.class)
public class TestClass extends baseclass {
	ExtentReports reporter;
	ExtentHtmlReporter htlm;
	ExtentTest test;

	@BeforeClass
	public void lauchBrowser() {
		reporter = new ExtentReports();
		htlm = new ExtentHtmlReporter(".//Screenshots//abc.html");
		reporter.attachReporter(htlm);
		test = reporter.createTest("VanitaTeest", "Helooo");
		
		openBrowser();
		
		test.info("Browser Opening Successfully");
	}

	@BeforeMethod
	public void hiturl() throws IOException {
		driver.get(utilityClass.getproperty());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void lauch() throws EncryptedDocumentException, IOException, InterruptedException {

		growlogin gr = new growlogin(driver);
		gr.loginbtnclick();
		test.info("Login Button click Succssfull");
		gr.getemail();
		gr.clickoncontinue();
		test.info("Mail sent Succssfull");
		gr.sendpass();
		gr.submitbtnclick();
		Thread.sleep(2000);
		gr.sendpin();
		test.info("Login Succssfull");


	}

	@AfterMethod
	public void capture(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.INFO, "Test is Fail");
			baseclass.getScrennshot(007);
			test.fail("test case is Pass", MediaEntityBuilder.createScreenCaptureFromPath("testcase7.png").build());
			test.addScreenCaptureFromPath("testcase7.png");
		} else {
			test.log(Status.INFO, "Test is Pass");
			baseclass.getScrennshot(007);
			test.pass("test case is Pass", MediaEntityBuilder.createScreenCaptureFromPath("testcase7.png").build());
			test.addScreenCaptureFromPath("testcase7.png");
		}
	}

	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		reporter.flush();
		driver.close();
	}

}

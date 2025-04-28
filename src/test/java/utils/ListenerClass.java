package utils;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.ProjectSpecificationMethods;


public class ListenerClass extends ProjectSpecificationMethods implements ITestListener {
	
	
	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test pased");
		
		String screenShotpath=null;
		try {
			screenShotpath = screenshot(result.getMethod().getMethodName()+" pass");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(screenShotpath, "Passed Test Screenshot");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		
		String screenShotpath=null;
		try {
			screenShotpath = screenshot(result.getMethod().getMethodName()+ " fail");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(screenShotpath, "Failed Test Screenshot");
	}
	
	

}


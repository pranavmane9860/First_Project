package com.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;

public class LoginTest extends BaseClass {

	@BeforeSuite
	public void setup() throws Exception {
		initialiazation();
		reportInit();
	}

	@Test
	public void test01() {
		LoginPage lp = new LoginPage(driver);
		lp.LoginApp("kiran@gmail.com", "123456");
		Assert.assertEquals(driver.getTitle(),"JavaByKiran | Dashboard");
	}

	
}

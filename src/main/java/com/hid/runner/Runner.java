package com.hid.runner;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/main/java/com/hid/feature" }, glue = {
		"com.hid.step" }, monochrome = true, plugin = { "pretty", "html:target/report",
				"com.cucumber.listener.ExtentCucumberFormatter" })

public class Runner {

	@BeforeClass
	public static void setup() {
		ExtentCucumberFormatter.initiateExtentCucumberFormatter();
		ExtentCucumberFormatter.loadConfig(new File("src/main/java/extent-config.xml"));
		ExtentCucumberFormatter.addSystemInfo("Service Technology", "springboot");

	}

}

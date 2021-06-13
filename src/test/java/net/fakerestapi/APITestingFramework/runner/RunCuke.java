package net.fakerestapi.APITestingFramework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features= {"src/test/resources/features"},plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} ,glue="net.fakerestapi.APITestingFramework.steps")
public class RunCuke extends AbstractTestNGCucumberTests{





}

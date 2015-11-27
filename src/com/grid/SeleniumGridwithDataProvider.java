///http://www.guru99.com/introduction-to-selenium-grid.html
/// Please check in Google driver 
///to execute node :---->  java -Dwebdriver.chrome.driver=D:\chromedriver.exe  -Dwebdriver.ie.driver=D:\IEdriver.exe -jar selenium-server-standalone.jar  -role webdriver -hub://localhost:4444/wd/grid/register -port 5556 -browser broserName=friefox,maxInstances=2 -browser browserName=chrome -browser browserName=iexplore


package com.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumGridwithDataProvider {
	WebDriver driver = null;
	String 	baseurl, nodeurl;
	
	@Parameters ("browser")
	@BeforeClass 
	public void Initialization (String brow) throws MalformedURLException{
		baseurl= "http://www.wisepiggy.com";
		nodeurl ="http://172.16.155.133:5555/wd/hub";
		
		DesiredCapabilities  capability =  null;
		if (brow.equals("firefox")){
			capability=DesiredCapabilities.firefox();
			capability.setJavascriptEnabled(true);
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(nodeurl), capability);
		}
		else if (brow.equals("chrome")){
		capability=DesiredCapabilities.chrome();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL(nodeurl), capability);
		}
	else if (brow.equals("internetexplore")){
		capability=DesiredCapabilities.internetExplorer();
		capability.setBrowserName("iexplore");
		capability.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL(nodeurl), capability);
		}
	}
	
	
	
	@Test
	public void Gettitle(){
		driver.get(baseurl);
		driver.findElement(By.xpath("//*[@href, '/credit-cards/best-credit-cards']")).click();
		
	}

}

package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AutoUtil {
	public static String getProperty(String path, String key)
	{
		String value="";
		Properties p=new Properties();
		try {
			p.load(new FileInputStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		value=p.getProperty(key);
		return value;
	}
	
	public static void getPhoto(WebDriver driver, String folder, String testName)
	{
		Date d=new Date();
		String sDate=d.toString();
		String dateTime=sDate.replaceAll(":", "_");
		String path=folder+dateTime+testName+".png";
		TakesScreenshot t=(TakesScreenshot)driver;
		File srcFile=t.getScreenshotAs(OutputType.FILE);
		File destFile=new File(path);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

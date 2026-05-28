package com.dap.qa.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShotUtils 
{
	private static String baseTestFolder = null;
	public static void resetTestFolder()
	{
	    baseTestFolder = null;
	}
	
	public static String getTestCaseFolder(String testname)
	{
		if(baseTestFolder == null)
		{
			String datetime = new SimpleDateFormat("yyyyMMdd_hhmm").format(new Date());
			baseTestFolder = System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + testname + "_" + datetime;
			File folder = new File(baseTestFolder);
			
            if(!folder.exists())
            {
                folder.mkdirs();
            }

            new File(baseTestFolder + File.separator + "Passed").mkdirs();
            new File(baseTestFolder + File.separator + "Failed").mkdirs();
            new File(baseTestFolder + File.separator + "Skipped").mkdirs();
		}
		
		

		return baseTestFolder;
		
		
	}
	public static String captureFullPageScreenshot(WebDriver driver, String testCaseName,String screenShotName,String status)
	{
		if (driver == null)
		{
			System.out.println("Driver is NULL, Screenshot not captured");
			return "";
		}
		
		String folderpath = getTestCaseFolder(testCaseName);
		String statusFolderPath = folderpath + File.separator + status;
	    new File(statusFolderPath).mkdirs();
		
		String path = statusFolderPath + File.separator + screenShotName + "_full.png";
		
		try 
		{
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(4000)).takeScreenshot(driver);
			BufferedImage image = screenshot.getImage();
			ImageIO.write(image, "PNG", new File(path));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return path;
	}
	public static String captureVisibleScreenshot(WebDriver driver, String testCaseName, String screenShotName,String status)
	{
	    if (driver == null)
	    {
	        System.out.println("Driver is NULL, Screenshot not captured");
	        return "";
	    }

	    String folderpath = getTestCaseFolder(testCaseName);
	    String statusfolderpath = folderpath + File.separator + status;
	    new File(statusfolderpath).mkdirs();
	    
		String path = statusfolderpath + File.separator + screenShotName + ".png";
	   
	    try
	    {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        File destination = new File(path);
	        FileUtils.copyFile(source, destination);
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }

	    return path;
	}
}

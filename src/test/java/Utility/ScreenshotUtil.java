package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	/*
	 * public static String takeScreenshot(WebDriver driver, String filePath) { //
	 * Convert WebDriver object to TakeScreenshot TakesScreenshot scrShot =
	 * (TakesScreenshot) driver;
	 * 
	 * // Call getScreenshotAs method to create an image file File srcFile =
	 * scrShot.getScreenshotAs(OutputType.FILE);
	 * 
	 * // Move image file to new destination File destFile = new File(filePath); try
	 * { FileUtils.copyFile(srcFile, new File(filePath)); } catch (IOException e) {
	 * e.printStackTrace(); } return filePath; }
	 */
	public static String takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        String screenshotPath = "screenshots/" + screenshotName + "_" + timestamp + ".png";
        //String screenshotPath = screenshotName.replace(".png", "_" + timestamp + ".png");
        File destFile = new File(screenshotPath);
        //FileUtils.copyFile(screenshot, new File(screenshotPath));
        //return screenshotPath;
        FileUtils.copyFile(screenshot, destFile);
        return destFile.getAbsolutePath();
    }


}

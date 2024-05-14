package utilities;

import driver.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenshotFactory {
    public static void captureScreenshots(String testName, int x, int y, int width, int height) {
        TakesScreenshot scrShot = ((TakesScreenshot) AppDriver.getCurrentDriver());
        // Gọi hàm để chụp ảnh màn hình - getScreenshotAs
        File sourceFile = scrShot.getScreenshotAs(OutputType.FILE);
        // Kiểm tra folder tồn tại. Nếu không thì tạo mới folder theo đường dẫn
        File destFile = new File("./screenshots/");
        if (!destFile.exists()) {
            destFile.mkdirs();
            System.out.println("Directory is created");
        }
        // Lưu file ảnh với tên cụ thể vào đường dẫn
        try {
            BufferedImage fullImg = ImageIO.read(sourceFile);
            BufferedImage coppedImg = fullImg.getSubimage(x, y, width, height);
            ImageIO.write(coppedImg, "png", new File("./screenshots/" + testName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void captureScreenshotOf(MobileElement element, String testName) {
        // Gọi hàm để chụp ảnh màn hình - getScreenshotAs
        File sourceFile = element.getScreenshotAs(OutputType.FILE);
        // Kiểm tra folder tồn tại. Nếu không thì tạo mới folder theo đường dẫn
        File destFile = new File("./screenshots/");
        if (!destFile.exists()) {
            destFile.mkdirs();
            System.out.println("Directory is created");
        }
        // Lưu file ảnh với tên cụ thể vào đường dẫn
        try {
            FileHandler.copy(sourceFile, new File("./screenshots/" + testName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

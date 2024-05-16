package utilities;

import driver.AppDriver;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.core.Point;
//import org.opencv.core.Scalar;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ImageComparison {
    private static final String VALIDATION_PATH = "D:\\AUT_LoanTTV\\Test_Cucumber\\cucumber_ci_cd_test\\validation-img" +
            "\\resultImg.png";
    private static final String EXPECTED_IMAGE_PATH = "D:\\AUT_LoanTTV\\Test_Cucumber\\cucumber_ci_cd_test\\" +
            "validation-img\\expectedImg2.png";
    private static final String ERROR_EXPECTED_IMAGE = "D:\\AUT_LoanTTV\\Test_Cucumber\\cucumber_ci_cd_test\\" +
            "validation-img\\expectedImg.png";


//    public static Rectangle getDifferenceBounds(BufferedImage image1, BufferedImage image2) {
//        int width = image1.getWidth();
//        int height = image1.getHeight();
//        Rectangle diffBounds = new Rectangle();
//
//        // Initialize bounds with invalid values
//        int minX = Integer.MAX_VALUE;
//        int minY = Integer.MAX_VALUE;
//        int maxX = Integer.MIN_VALUE;
//        int maxY = Integer.MIN_VALUE;
//
//        for (int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                int pixel1 = image1.getRGB(x, y);
//                int pixel2 = image2.getRGB(x, y);
//                if (pixel1 != pixel2) {
//                    minX = Math.min(minX, x);
//                    minY = Math.min(minY, y);
//                    maxX = Math.max(maxX, x);
//                    maxY = Math.max(maxY, y);
//                    int diffWidth = maxX - minX + 1;
//                    int diffHeight = maxY - minY + 1;
//                    diffBounds = new Rectangle(minX, minY, diffWidth, diffHeight);
//                }
//            }
//        }
//        return diffBounds;
//    }

    public static boolean getDifferenceImage(BufferedImage image1, BufferedImage image2) throws IOException {
        // convert images to pixel arrays...
        final int
                w1 = image1.getWidth(),
                h1 = image1.getHeight(),
                w2 = image2.getWidth(),
                h2 = image2.getHeight(),
                highlight = Color.RED.getRGB();
        final int[] p1 = image1.getRGB(0, 0, w1, h1, null, 0, w1);
        final int[] p2 = image2.getRGB(0, 0, w2, h2, null, 0, w2);

        int differentPixelCount = 0;

        // compare image1 to image2, pixel by pixel. If different, highlight image1's pixel...
        for (int i = 0; i < p1.length; i++) {
            if (p1[i] != p2[i]) {
                p1[i] = highlight;
                differentPixelCount++;
            }
        }

        if (w1 != w2 || h1 != h2) {
            System.out.println("Dimensions do not match!");
            return true;
        }

        if (differentPixelCount == 0) {
            System.out.println("There is no difference in both images.");
            return true;
        }

        BufferedImage result = new BufferedImage(w1, h1, BufferedImage.TYPE_INT_RGB);
        result.setRGB(0, 0, w1, h1, p1, 0, w1);
//
//        Rectangle rec = getDifferenceBounds(image1, image2);
//        Graphics2D g2d = result.createGraphics();
//
//        g2d.setColor(Color.RED);
//        g2d.drawRect(rec.x, rec.y, rec.width, rec.height);
        ImageIO.write(result, "png", new File(VALIDATION_PATH));
        System.out.println("There are differences between 2 images.");
        return false;
    }

    public static boolean compareImages(File sourceFile) throws IOException {
        return getDifferenceImage(
                ImageIO.read(sourceFile),
                ImageIO.read(new File(EXPECTED_IMAGE_PATH)));
    }
}

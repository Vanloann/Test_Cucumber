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

import java.io.File;
import java.io.IOException;

public class ImageComparison {
    private static final String VALIDATION_PATH = "D:\\AUT_LoanTTV\\Test_Cucumber\\cucumber_ci_cd_test\\validation-img";
    private static final String EXPECTED_IMAGE_PATH = "D:\\AUT_LoanTTV\\Test_Cucumber\\cucumber_ci_cd_test\\" +
            "validation-img\\expectedImg.png";
    private static final String ACTUAL_IMAGE_PATH = "D:\\AUT_LoanTTV\\Test_Cucumber\\cucumber_ci_cd_test\\" +
            "screenshots\\SuccessfulImage.png";
    private static final double MATCH_THRESHOLD = 1;

//    public static void opencvTest() {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        Mat mat = Imgcodecs.imread(EXPECTED_IMAGE_PATH);
//        Imgproc.rectangle(mat, new Point(10,10), new Point(100,100), new Scalar(0, 255, 0));
//        Imgcodecs.imwrite(EXPECTED_IMAGE_PATH, mat);
//    }


    public static void doVisualCheckOf(String screenName) throws Exception {
        File expectedImg = new File(EXPECTED_IMAGE_PATH);
        File actualImg = new File(ACTUAL_IMAGE_PATH);
        SimilarityMatchingOptions options = new SimilarityMatchingOptions();
        options.withEnabledVisualization();
        SimilarityMatchingResult matchingResult = AppDriver.getCurrentDriver()
                .getImagesSimilarity(expectedImg, actualImg, options);
        if (matchingResult.getScore() < MATCH_THRESHOLD) {
            File comparingFile = new File(VALIDATION_PATH + "/FAIL_" + screenName + ".png");
            throw new Exception(String.format("Visual check of '%s' failed, similarity watch was only %f, and below the" +
                            " threshold of %f. Visualization written to %s.", screenName, matchingResult.getScore(),
                    MATCH_THRESHOLD, comparingFile.getAbsolutePath()));
        }
        System.out.println(String.format("Visual check of '%s' passed; similarity match was %f", screenName,
                matchingResult.getScore()));
    }
}

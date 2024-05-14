package utilities;

import com.google.common.collect.ImmutableList;
import driver.AppDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.Optional;

public class ScrollFactory {
    static Duration SCROLL_DUR = Duration.ofMillis(500);

    public enum ScrollDirection {
        UP, DOWN, LEFT, RIGHT
    }

//    public static void scroll(ScrollDirection dir, double scrollRatio, int count) {
//
//        if (scrollRatio < 0 || scrollRatio > 1) {
//            throw new Error("Scroll distance must be between 0 and 1");
//        }
//        Dimension size = AppDriver.getCurrentDriver().manage().window().getSize();
//        Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
//        int bottom = midPoint.y + (int) (midPoint.y * scrollRatio);
//        int top = midPoint.y - (int) (midPoint.y * scrollRatio);
//        //Point Start = new Point(midPoint.x, bottom );
//        //Point End = new Point(midPoint.x, top );
//        int left = midPoint.x - (int) (midPoint.x * scrollRatio);
//        int right = midPoint.x + (int) (midPoint.x * scrollRatio);
//
//        if (dir == ScrollDirection.UP) {
//            swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR, count);
//        } else if (dir == ScrollDirection.DOWN) {
//            swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR, count);
//        } else if (dir == ScrollDirection.LEFT) {
//            swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR, count);
//        } else {
//            swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR, count);
//        }
//    }

//    public static void swipe(Point start, Point end, Duration duration, int count) {
//        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        Sequence swipe = new Sequence(input, 0);
//        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
//        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
//        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        for (int i = 0; i < count; i++) {
//            AppDriver.getCurrentDriver().perform(ImmutableList.of(swipe));
//        }
//    }

    public static void touchActions(int a1, int b1, int a2, int b2, int time) {
        TouchAction<?> touchAction = new TouchAction<>(AppDriver.getCurrentDriver());
        touchAction.press(PointOption.point(a1, b1)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(time))).
                moveTo(PointOption.point(a2, b2)).release();
        touchAction.perform();
    }
    public static void swipe(String direction, int count, int time) {
        Dimension size = AppDriver.getCurrentDriver().manage().window().getSize();
        switch (direction) {
            case "left":
            case "LEFT":
                for (int i = 0; i < count; i++) {
                    int startx = (int) (size.width * 0.8);
                    int endx = (int) (size.width * 0.20);
                    int starty = size.height / 2;
                    touchActions(startx, starty, endx, starty, time);
                }
                break;
            case "right":
            case "RIGHT":
                for (int j = 0; j < count; j++) {
                    int endx = (int) (size.width * 0.8);
                    int startx = (int) (size.width * 0.20);
                    int starty = size.height / 2;
                    touchActions(startx, starty, endx, starty, time);
                }
                break;
            case "up":
            case "UP":
                for (int j = 0; j < count; j++) {
                    int starty = (int) (size.height * 0.80);
                    int endy = (int) (size.height * 0.20);
                    int startx = size.width / 2;
                    touchActions(startx, starty, startx, endy, time);
                }
                break;
            case "down":
            case "DOWN":
                for (int j = 0; j < count; j++) {
                    int starty = (int) (size.height * 0.80);
                    int endy = (int) (size.height * 0.20);
                    int startx = size.width / 2;
                    touchActions(startx, endy, startx, starty, time);
                }
                break;
            default:
                break;
        }
    }
}

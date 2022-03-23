package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class ReusableMethods {


    public static void setContext(String contextName){
        Set<String> contextNames = Driver.getAppiumDriver().getContextHandles();

        for (String w: contextNames) {
            if ((w.contains(contextName))){
                Driver.getAppiumDriver().context((String) w);
                break;
            }
        }
    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getScreenshot(String name) throws IOException {

        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        File scrFile = ((TakesScreenshot)Driver.getAppiumDriver()).getScreenshotAs(OutputType.FILE);

        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";

        File finalDestination = new File(target);

        FileUtils.copyFile(scrFile, finalDestination);

        return target;
    }




}

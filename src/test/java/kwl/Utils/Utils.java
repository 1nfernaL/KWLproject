package kwl.Utils;

import kwl.Drive.MyDriver;
import kwl.Pages.BasePage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebElement;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Set;

public class Utils extends BasePage {
    static public class Data {

        public static String getPdfContent(String url) throws IOException {
            URL pdfURL = new URL(url);
            InputStream is = pdfURL.openStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            PDDocument doc = PDDocument.load(bis);
            int pages = doc.getNumberOfPages();
            PDFTextStripper strip = new PDFTextStripper();
            strip.setStartPage(1);
            strip.setEndPage(2);
            String stripText = strip.getText(doc);
            doc.close();
            return stripText;
        }

        public static void openPDFlink (WebElement pdfLink){
            String oldWindowHandle = driver.getWindowHandle();
            MyDriver.getInstance().scrollDown(0,500);
            pdfLink.click();
            Set<String> windowHandles = driver.getWindowHandles();
            String newWindowHandle = "";
            for (String handle : windowHandles) {
                if (!handle.equals(oldWindowHandle)) {
                    newWindowHandle = handle;
                    break;
                }
            }
            driver.switchTo().window(newWindowHandle);
        }

    }
}

package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;

/**
 * Created by syam.suryanarayanan on 5/17/2017.
 */
public class accessingurl {

    public static void main(String [] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
      //  WebDriver driver = new ChromeDriver();
         String fileName = "C:\\asdf.txt";
        File f = new File(fileName);
        if(!f.exists()) {
            f.createNewFile();
        }

        BufferedReader br = null;
      //  BufferedWriter bw = null;
         String sCurrentLine;
         br = new BufferedReader(new FileReader("\\..\\url1.txt"));
         FileWriter fw = new FileWriter(fileName);
            while ((sCurrentLine = br.readLine()) != null) {
                WebDriver driver = new ChromeDriver();
                driver.get(sCurrentLine);
                String sCurrentUrl=driver.getCurrentUrl();
                // fw.write(sCurrentLine + " : "+sCurrentUrl);
             fw = new FileWriter(fileName);
                BufferedWriter  bw = new BufferedWriter(fw);
                bw.write(sCurrentLine + " : "+sCurrentUrl);
                bw.flush();
                driver.quit();



                }



        }

    }



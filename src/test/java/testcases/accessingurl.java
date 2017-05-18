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
         String fileName = "\\..\\filename22.txt";



        BufferedReader br = null;



            String sCurrentLine;

            br = new BufferedReader(new FileReader("\\..\\url1.txt"));
        FileWriter fw = new FileWriter(fileName,true);
            while ((sCurrentLine = br.readLine()) != null) {
                //System.out.println(sCurrentLine);
                WebDriver driver = new ChromeDriver();
                driver.get(sCurrentLine);

                    String sCurrentUrl=driver.getCurrentUrl();
                System.out.println(sCurrentLine + ":"+sCurrentUrl);
                    fw.write(sCurrentLine + ":"+sCurrentUrl);
                 driver.quit();


                }

        fw.flush();
        fw.close();

        }

    }



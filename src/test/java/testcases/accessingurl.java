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
         String fileName = "C:\\filename22.txt";
        File f = new File(fileName);
        if(!f.exists()) {
            f.createNewFile();
        }

        BufferedReader br = null;



            String sCurrentLine;

            br = new BufferedReader(new FileReader("\\..\\url1.txt"));
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);

            while ((sCurrentLine = br.readLine()) != null) {
                //System.out.println(sCurrentLine);
                WebDriver driver = new ChromeDriver();
                driver.get(sCurrentLine);

                    String sCurrentUrl=driver.getCurrentUrl();
                    bw.write(sCurrentLine + " : "+sCurrentUrl);

                    bw.newLine();

                 driver.quit();


                }

        fw.flush();
        fw.close();

        }

    }



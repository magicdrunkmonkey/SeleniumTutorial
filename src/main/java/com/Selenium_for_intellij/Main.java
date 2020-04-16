package com.Selenium_for_intellij;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {

    // WebDriver obj;

    public static void main(String[] args) throws IOException, InterruptedException {

        //System.setProperty("webdriver.gecko.driver","C:\\Gecko\\geckodriver.exe"); //Firefox webdriver
       // System.setProperty("webdriver.chrome.driver","C:\\Dev_Drivers\\Chrome_Webdriver\\chromedriver.exe"); //Chrome webdriver
        //System.setProperty("webdriver.edge.driver","C:\\Dev_Drivers\\MS_Edge_Webdriver\\msedgedriver.exe"); //Edge webdriver

        WebDriver obj = new ChromeDriver();
        obj.get("https://metrum-cloud-pilot.azurewebsites.net/WebForms/LogIn.aspx?ref=https://metrum-cloud-pilot.azurewebsites.net/WebForms/EventsPage.aspx");

        Thread.sleep(2000);

        //Fånga Metrum Logo på sidan Metrum PQX Web
        WebElement webElement = obj.findElement(By.cssSelector("#metrumLogo"));
        Screenshot screenshot = new AShot().takeScreenshot(obj, webElement);

        Thread.sleep(2000);

        ImageIO.write(screenshot.getImage(),"PNG",new File("Image"));

        Thread.sleep(2000);

        obj.quit();

    }
}

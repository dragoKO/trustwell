package com.trustwell.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

public class Driver {

    private Driver() {
    }

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver() {

        if (driverPool.get() == null) {
            String browserName = System.getProperty("browser") != null ? browserName = System.getProperty("browser") : ConfigurationReader.getProperty("browser");

            if (browserName.equals("remote-chrome") || browserName.equals("remote-edge")) {

                try {

                    String gridAddress = "localhost";
//                    http://localhost:4444/ui container ui
                    URL url = new URL("http://" + gridAddress + ":4444");
                    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

                    desiredCapabilities.setBrowserName(browserName
                            .substring(browserName.indexOf('-') + 1)); // choose remote browser

                    driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (browserName.equals("chrome") || browserName.equals("firefox") || browserName.equals("edge")) {

                WebDriverManager.chromedriver().setup();

                if (browserName.equals("chrome")) driverPool.set(new ChromeDriver());
                if (browserName.equals("firefox")) driverPool.set(new FirefoxDriver());
                if (browserName.equals("edge")) driverPool.set(new EdgeDriver());


                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            }
        }

        return driverPool.get();

    }


    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }

    }

}
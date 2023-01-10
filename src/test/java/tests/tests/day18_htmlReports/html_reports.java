package tests.tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class html_reports extends TestBaseRapor {
    @Test
    public void test(){
        extentTest=extentReports.createTest("Nutella Testi","Kullanici amazon Nutella Testi");


        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon Anasayfaya Gidildi");
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        extentTest.info("Arama kutusuna Nutella yazip, arama yapildi");
        String actualSonucYazisi=amazonPage.aramaSonucuElementi.getText();
        String expectedKelime="Nutella";
        extentTest.info("Arama sonuclari kaydedildi");
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        extentTest.pass("Arama sonuclarinin Nutella icerdigi test edildi");


    }
}

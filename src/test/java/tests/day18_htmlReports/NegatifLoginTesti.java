package tests.day18_htmlReports;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegatifLoginTesti {



    QualitydemyPage qualitydemyPage=new QualitydemyPage();

    @DataProvider
    public static Object[][] kullaniciBilgileri() {
        Object[][] kullaniciBilgileriArr={{"A11","A12345",},{"B11","B12345",},{"C11","C12345",},{"D11","D12345",},{"E11","E12345",}};



        return kullaniciBilgileriArr;
    }

    @Test(dataProvider = "kullaniciBilgileri")
    public void negatif(String username,String password){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        if (qualitydemyPage.cookie.isDisplayed()){
            qualitydemyPage.cookie.click();
        }
        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.kullaniciEmailKutusu.sendKeys(username);
        qualitydemyPage.passwordKutusu.sendKeys(password);
        qualitydemyPage.loginButonu.click();
        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());


    }
}

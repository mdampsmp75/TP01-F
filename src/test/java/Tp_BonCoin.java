import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tp_BonCoin {

    WebDriver driver;

    @BeforeMethod
    public void ouvrirChrome(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);   //deconseillé
        driver.get("https://www.ebay.fr/");
        driver.manage().window().maximize();
        //driver.findElement(By.id("gdpr-banner-accept")).click();
    }

    @Test
    public void test(){
        //Arrang

        String resultatAttendu = "Buts de Foot 2pcs Mini Pop-Up Cages de Football Enfant Adulte + Sac de Transport";
        String chiffreTrouvePanier = "1";

        //Act
        By allCategorieSelector = By.cssSelector("#gh-shop-a");
        driver.findElement(allCategorieSelector).click();

        By sportVacancesSelector = By.cssSelector(".scnd[_sp='m570.l3778']");
        driver.findElement(sportVacancesSelector).click();

        By firstArcticleSelector = By.xpath("//*[@id=\"s0-27_2-9-0-1[0]-0-0-xCarousel-x-carousel-items\"]/ul/li[1]/a/div[1]/div/img");
        driver.findElement(firstArcticleSelector).click();

        By ajouterPanierSelector = By.cssSelector(".vi-bbox-atcaslink#isCartBtn_btn");
        driver.findElement(ajouterPanierSelector).click();

        //Assert
        By resultatTrouveSelector = By.cssSelector("[data-test-id=cart-item-link]");
        String resultatTrouve = driver.findElement(resultatTrouveSelector).getText();
        System.out.println(resultatTrouve);
        Assert.assertEquals(resultatTrouve,resultatAttendu);

        By trouveChiffre1PanierSelector = By.cssSelector("[data-test-id='main-title']");
        String trouveChiffrePanier = driver.findElement(trouveChiffre1PanierSelector).getText();
        System.out.println(trouveChiffrePanier);
        Assert.assertTrue(trouveChiffrePanier.contains(chiffreTrouvePanier));

    }
}

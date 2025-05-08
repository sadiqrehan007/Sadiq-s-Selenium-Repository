package pages;

import org.openqa.selenium.*;
import java.util.ArrayList;

public class AmazonPage {
    WebDriver driver;

    public AmazonPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String productName) throws InterruptedException {
        driver.get("https://www.amazon.in/");
        Thread.sleep(2000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productName);
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    public void selectProduct() {
        driver.findElement(By.xpath("(//span[contains(text(),'boAt Stone Spinx Pro Bluetooth Speaker with 20 W R')])[2]")).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void addToCartAndGoToCart() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/cart?ref_=ewc_gtc']")).click();
    }

    public String getProductTextInCart() {
        return driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).getText();
    }

    public void proceedToCheckout() {
        driver.findElement(By.name("proceedToRetailCheckout")).click();
    }

    public void login(String email, String password) {
        driver.findElement(By.id("ap_email")).sendKeys(email);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys(password);
        driver.findElement(By.id("signInSubmit")).click();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}

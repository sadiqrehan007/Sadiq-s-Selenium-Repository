package test;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AmazonPage;

public class AmazonTest extends BaseTest {

    @Test
    public void testAmazonFlow() throws InterruptedException {
        AmazonPage amazon = new AmazonPage(driver);
        amazon.searchProduct("boAt Stone Spinx Pro 20 w");
        amazon.selectProduct();
        amazon.selectTest();
        amazon.addToCartAndGoToCart();

        String productText = amazon.getProductTextInCart();
        System.out.println("Product in Cart: " + productText);

        amazon.proceedToCheckout();
        amazon.login("9756132567", "***********"); // Use dummy/test credentials only in test env

        System.out.println("Current URL after login: " + amazon.getCurrentURL());
    }
}

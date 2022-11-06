package ch.zhaw.checkout.checkout;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ch.zhaw.checkout.checkout.model.FiveBuckesVoucher;
import ch.zhaw.checkout.checkout.model.Product;

public class FiveBuckesVoucherTest {
    @Test
    public void testEmpty() {
        // Code that tests one thing
        List<Product> testempty = new ArrayList<>();
         FiveBuckesVoucher fiveBuckesVoucher = new FiveBuckesVoucher();

        System.out.println(fiveBuckesVoucher.getDiscount(testempty)+ "Test Erfolgreich");
        

    }

    @Test
    public void testTen() {
        // Code that tests one thing
        List<Product> testempty = new ArrayList<>();
        Product testprodukt = new Product("1", "Name", "gruppe1", 0.0);
        testempty.add(testprodukt);
        FiveBuckesVoucher fiveBuckesVoucher = new FiveBuckesVoucher();

        System.out.println(fiveBuckesVoucher.getDiscount(testempty)+ "Test Erfolgreich");
        

    }

}
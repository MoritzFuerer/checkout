package ch.zhaw.checkout.checkout;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ch.zhaw.checkout.checkout.model.PercentageVoucher;
import ch.zhaw.checkout.checkout.model.Product;

public class PercentageVoucherTest {

    @ParameterizedTest
    @ValueSource (ints = { 1, 2, 5, 20, 49, 50 })
    
    public void testEven3(int value) {
       

        List<Product> testempty = new ArrayList<>();
        Product testprodukt = new Product("1", "Name", "gruppe1", 25.0);
        testempty.add(testprodukt);
         PercentageVoucher percentageVoucher = new PercentageVoucher();
         double discount = percentageVoucher.getDiscount(testempty);

        System.out.println(discount + "Test 3 war korrekt");
    }
}

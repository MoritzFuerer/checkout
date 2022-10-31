package ch.zhaw.checkout.checkout;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import ch.zhaw.checkout.checkout.model.Product;
import ch.zhaw.checkout.checkout.model.TwoForOneVoucher;

public class TwoForOneVoucherTest {

    Product testprodukt = new Product("1", "Name", "productGroup", 77);
    private TwoForOneVoucher twoForOneVoucher = new TwoForOneVoucher(testprodukt);
 
    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,0", "2,1", "3,1", "4,2"})
    void testGetDiscount(ArgumentsAccessor accessor) {
        int amountSameProducts = accessor.getInteger(0);
        int amountFreeProducts = accessor.getInteger(1);
        
        List<Product> products = new ArrayList<>();
        
        for(int i = 0; i <amountSameProducts; i++) {
            products.add(testprodukt);
        }
        
        double discount = twoForOneVoucher.getDiscount(products);
        assertEquals((amountFreeProducts * 77.0), discount);
    }

    @Test
    void testZeroDiscount() {
        double discount = twoForOneVoucher.getDiscount(List.of(
            new Product("2", "Product 1", "Tester", 42.0),
            new Product("3", "Product 2", "Tester", 77.0)));
        assertEquals(0.0, discount);
    }
}

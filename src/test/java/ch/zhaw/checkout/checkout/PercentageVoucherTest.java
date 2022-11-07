package ch.zhaw.checkout.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ch.zhaw.checkout.checkout.model.PercentageVoucher;
import ch.zhaw.checkout.checkout.model.Product;

public class PercentageVoucherTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 5, 20, 49, 50})
    public void test3(int value) {
        List<Product> testliste = new ArrayList<>();
        Product testprodukt = new Product("1", "Name", "productGroup", 2000);
        testliste.add(testprodukt);
        PercentageVoucher percentageVoucher = new PercentageVoucher(value);
        double discount = percentageVoucher.getDiscount(testliste);
        System.out.println(discount + " Test 3 Erfolgreich");
    }

    
    @ParameterizedTest
    @ValueSource(ints = { 0, 51})
    public void Nulltest(int value) {

        String expectedMessage1 = "Error: Discount value must be greater zero.";
        String expectedMessage2 = "Error: Discount value must less or equal 50.";

        Exception exception = assertThrows(java.lang.RuntimeException.class, () -> {
            PercentageVoucher percentageVoucher = new PercentageVoucher(value);
        });
        String actualMessage = exception.getMessage();
        if (value == 0) {
            assertTrue(actualMessage.contains(expectedMessage1));
        } else {
            assertTrue(actualMessage.contains(expectedMessage2));
        }
    }

    @Test
    void testTwoProducts() {

        Product p1 = mock(Product.class);
        Product p2 = mock(Product.class);
        when(p1.getPrice()).thenReturn((double) 42);
        when(p2.getPrice()).thenReturn((double) 77);

        PercentageVoucher percentageVoucher = new PercentageVoucher(42);
        double discount = percentageVoucher.getDiscount(List.of(p1, p2));

        assertEquals(49.98, discount);
    }   
}

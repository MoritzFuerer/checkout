package ch.zhaw.checkout.checkout;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import ch.zhaw.checkout.checkout.model.Product;
import ch.zhaw.checkout.checkout.model.ProductGroupVoucher;

public class ProductGroupVoucherTest {
    
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 5, 20, 49})
    public void korrekteRabatte(int value) {
        ProductGroupVoucher productGroupVoucher = new ProductGroupVoucher("a", value);
    }
    
    @ParameterizedTest
    @ValueSource(ints = { 0, -1, -Integer.MAX_VALUE})
    public void falscheRabatte(int value) {
        ProductGroupVoucher productGroupVoucher = new ProductGroupVoucher("a", value);
    }

    @Test
    public void fehlerhafteProduktgruppen() {
        ProductGroupVoucher productGroupVoucher1 = new ProductGroupVoucher(" ", 42);
        ProductGroupVoucher productGroupVoucher2 = new ProductGroupVoucher(null, 42);
    }


    @ParameterizedTest
    @CsvSource(value = {"p1,5,p1,7,p1,10,10","p1,5,p1,3,p1,10,8","p1,5,p2,7,p1,10,5","p2,5,p2,7,p1,10,0","p1,11,p2,7,p1,10,10"})
    void testGetDiscount(ArgumentsAccessor accessor) {
        
        Product p1 = mock(Product.class);
        Product p2 = mock(Product.class);
        when(p1.getProductGroup()).thenReturn(accessor.getString(0) );
        when(p1.getPrice()).thenReturn((double) accessor.getInteger(1) );
        when(p2.getProductGroup()).thenReturn(accessor.getString(2) );
        when(p2.getPrice()).thenReturn((double) accessor.getInteger(3) );

        ProductGroupVoucher productGroupVoucher = new ProductGroupVoucher(accessor.getString(4), accessor.getInteger(5));
                
        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
               
        double discount = productGroupVoucher.getDiscount(products);
        assertEquals((double) accessor.getInteger(6), discount);
    }
}


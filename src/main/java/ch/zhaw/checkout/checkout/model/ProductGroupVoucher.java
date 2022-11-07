package ch.zhaw.checkout.checkout.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductGroupVoucher implements Voucher{

    private String productGroup;
    private int amount;
    

    @Override
    public double getDiscount(List<Product> products) {
       
        double sum = products.stream().filter(p -> p.getProductGroup().equals(productGroup)).collect(Collectors.summingDouble(p -> p.getPrice()));

        if (sum - amount >= 0) { // 12 - 10 = 2 > 0 -> korrekt
            return amount;       // 8 - 10 = -2 > 0 -> falsch
        }
        else{
            return sum; 
        }
    }
}

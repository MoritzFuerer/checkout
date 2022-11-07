package ch.zhaw.checkout.checkout.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;



@Getter

public class PercentageVoucher implements Voucher {
    private int discount = 0;

    public PercentageVoucher(int discount){
        if (discount <= 0){
        throw new RuntimeException("Error: Discount value muts be greater zero.");
    } else if (discount > 50) {
        throw new RuntimeException("Error: Discount value must less or equal 50.");
    } else {
        this.discount = discount;}
    }

    @Override
    public double getDiscount(List<Product> products){
    
    Double summe = products.stream().collect(Collectors.summingDouble(x -> x.getPrice()));
   

    return (double)discount / 100 * summe;
    }
}

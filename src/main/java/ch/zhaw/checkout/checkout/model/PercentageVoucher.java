package ch.zhaw.checkout.checkout.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

public class PercentageVoucher implements Voucher {
    private int discount;

    @Override
    public Double getDiscount(List<Product> products){
    
    Double summe = products.stream().collect(Collectors.summingDouble(x -> x.getPrice()));
   

    return (double)discount / 100 * summe;
    }
}

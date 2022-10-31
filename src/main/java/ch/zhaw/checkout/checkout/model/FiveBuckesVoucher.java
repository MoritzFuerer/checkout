package ch.zhaw.checkout.checkout.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter

public class FiveBuckesVoucher implements Voucher {

    public Double getDiscount(List<Product> products){

        Double summe = products.stream().collect(Collectors.summingDouble(x -> x.getPrice()));
        
        if (summe >= 10.0) {
            return 5.0;
        }
        return 0.0;
    }
   

}

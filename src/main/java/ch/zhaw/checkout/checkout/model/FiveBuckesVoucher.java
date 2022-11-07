package ch.zhaw.checkout.checkout.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;





public class FiveBuckesVoucher implements Voucher {

    public double getDiscount(List<Product> products){
        Stream<Product> filtered = products.stream().filter(x -> x.getPrice() > 0);
        Double summe = products.stream().collect(Collectors.summingDouble(x -> x.getPrice()));
        
        if (summe >= 10.0) {
            return 5.0;
        }
        return 0.0;
    }
   
    public FiveBuckesVoucher(){

}
}
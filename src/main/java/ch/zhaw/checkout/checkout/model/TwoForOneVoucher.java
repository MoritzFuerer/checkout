package ch.zhaw.checkout.checkout.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
public class TwoForOneVoucher implements Voucher {
    @NonNull
    private Product product;

    @Override
    public double getDiscount(List<Product> products) {
        double discount = 0.0;
        if (products.size() <= 1) {
            return discount;
        } else {

            List<Product> productvoucher = products.stream().filter(p -> p.getId().equals(product.getId())).toList();

            int size = productvoucher.size();

            if (size % 2 != 0) {
                size -= 1;

            }
            if (productvoucher.size() != 0) {
                discount = productvoucher.get(0).getPrice() * (size / 2);
            }

            return discount;
        }
    }
}


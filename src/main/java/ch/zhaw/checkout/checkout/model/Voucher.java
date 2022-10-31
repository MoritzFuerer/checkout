package ch.zhaw.checkout.checkout.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.checkout.checkout.model.FiveBuckesVoucher;
import ch.zhaw.checkout.checkout.model.Product;

import java.util.List;

public @interface Voucher {
    List<Product> findByPriceGreaterThan(Double price);
}

package ch.zhaw.checkout.checkout.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public @interface Voucher {
    List<Product> findByPriceGreaterThan(Double price);
}

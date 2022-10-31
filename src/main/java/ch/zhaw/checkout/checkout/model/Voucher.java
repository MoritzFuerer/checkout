package ch.zhaw.checkout.checkout.model;


import java.util.List;


public interface Voucher {
    abstract Double getDiscount(List<Product> products);


} 
    


package ch.zhaw.checkout.checkout.model;


import java.util.List;


public interface Voucher {
    abstract double getDiscount(List<Product> products);


} 
    


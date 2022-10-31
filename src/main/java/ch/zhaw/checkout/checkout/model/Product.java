package ch.zhaw.checkout.checkout.model;



import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@RequiredArgsConstructor
@Getter


public class Product {
    
    @NonNull
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String productGroup;
    @NonNull
    private double price;

}

package com.mirea.confectionery.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Recipient {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String city;
    @NonNull
    private String address;
    private String instructions;
    @NonNull
    private List<Product> productList;
}

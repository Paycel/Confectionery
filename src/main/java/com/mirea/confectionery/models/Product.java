package com.mirea.confectionery.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @NonNull
    @Column(name = "full_name")
    private String fullName;

    @NonNull
    @Column(name = "product_name")
    private String productName;

    @NonNull
    @Column(name = "brand_name")
    private String brandName;

    @NonNull
    @Column(name = "price")
    private Float price;

    @NonNull
    @Column(name = "amount")
    private Integer amount;

    @NonNull
    @Column(name = "quantity")
    private Integer quantity = 1;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id")
    private Category category = new Category();

    @ManyToMany(mappedBy = "cart")
    private Set<User> users;
}

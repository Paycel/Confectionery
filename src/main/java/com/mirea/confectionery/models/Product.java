package com.mirea.confectionery.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
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
    @Column(name = "product_name")
    private String productName;

    @NonNull
    @Column(name = "price")
    private Float price;

    @NonNull
    @Column(name = "amount")
    private Integer amount;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id")
    private Category category = new Category();

    @ManyToMany(mappedBy = "cart")
    @JsonIgnore
    private Set<User> users;
}

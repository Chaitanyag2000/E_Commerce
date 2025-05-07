package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String description;

    private long price;

    private long discountedPrice;

    private long discountPresent;

    private int quantity;

    private String brand;

    private String colour;

    @Embedded
    @ElementCollection
    private Set<Size> sizes = new HashSet<>();

    private String imageUrl;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating>ratings = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    private int numRatings;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private LocalDateTime createdAt;
}

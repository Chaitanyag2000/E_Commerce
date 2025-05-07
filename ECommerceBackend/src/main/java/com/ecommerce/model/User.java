package com.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long userId;

    private String firstName;

    private String lastName;

    private String emailId;

    private String password;

    private String role;

    private long mobileNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)  // user cascade because when we delete the user information then all other related field also deleted
    private List<Address> address = new ArrayList<>();

    @Embedded  // It is not entity, we dont want to insert into database
    @ElementCollection  // for create seperate table of it
    @CollectionTable(name = "Payment_Information", joinColumns = @JoinColumn(name = "user_id"))  //it used because we can change the name of field and row in table
    private  List<PaymentInformation> paymentInformation = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore     // in user create nested problem so that we used JsonIgnore
    private List<Rating>ratings = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore     // in user Entity it will create nested problem so that we used it
    private List<Review> reviews = new ArrayList<>();

    private LocalDateTime createdAt;
}

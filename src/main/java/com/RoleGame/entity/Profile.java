package com.RoleGame.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "Profile")
@Getter
@Setter

public class Profile {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;
    @Column (name = "firstName")
    private String firstName;
    @Column (name = "lastName")
    private String lastName;
    @Column (name = "email")
    private String email;
    @Column (name = "phoneNumber")
    private String phoneNumber;
    @Column (name = "postalCode")
    private String postalCode;

    @OneToOne(mappedBy = "profile")
    private User user;
}

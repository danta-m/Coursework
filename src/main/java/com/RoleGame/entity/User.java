package com.RoleGame.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "User")
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;
    @Column (name = "user_name")
    private String userName;
    @Column (name = "password")
    private String password;
    @Column (name = "user_role_id")
    private long userRoleId;
    @Column (name = "profile_id")
    private long profileId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Service",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<Service> services;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
    private UserRole userRole;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Incident> incidents;

    @ManyToMany
    @JoinTable(name = "User_service",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "service_id"))
    private List<Service> service;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "user_role_role_name")
    private UserRole user_role;

}

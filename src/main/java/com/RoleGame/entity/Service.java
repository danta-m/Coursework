package com.RoleGame.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "Service")
@Getter
@Setter

public class Service {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;
    @Column (name = "serviceName")
    private String serviceName;
    @Column (name = "isActive")
    private boolean isActive;
    @Column (name = "serviceMonthPrice")
    private double serviceMonthPrice;
    @Column (name = "customerId")
    private long customerId;

    @ManyToMany(mappedBy = "service")
    private List<User> users;

}

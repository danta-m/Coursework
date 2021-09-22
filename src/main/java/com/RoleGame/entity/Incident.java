package com.RoleGame.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "Incident")
@Getter
@Setter
public class Incident {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;
    @Column (name = "serviceName")
    private String serviceName;
    @Column (name = "isActive")
    private boolean isActive;
    @Column (name = "problemDescription")
    private String problemDescription;
    @Column (name = "user_id")
    private long userId;

    @ManyToOne
    private User user;

}

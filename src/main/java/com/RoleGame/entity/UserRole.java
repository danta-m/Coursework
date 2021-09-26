package com.RoleGame.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "User_role")
@Getter
@Setter

public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;

    @Column (name = "role_name")
    private String roleName;
    @Column (name = "role_description")
    private String roleDescription;

    @OneToOne(mappedBy = "user_role")
    private User user;
}

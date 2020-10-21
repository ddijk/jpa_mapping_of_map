package com.example.demo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by avanderheijde on 09/08/16.
 *
 * Group with id 1 and name ADMIN is the admin group
 */
@Data
@Entity
public class UserGroup {

    private @Id
    @GeneratedValue
    Long id;

    @Column(unique = true)
    private String name;

    private String ldapName;



    public UserGroup(String name) {
        this.name= name;
    }

    public UserGroup() {

    }
}

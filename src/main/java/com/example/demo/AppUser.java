package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by avanderheijde on 08/08/16.
 */
@Data
@ToString(exclude = "password")
@Entity
public class AppUser {

    private static int workload= 12;

    private @Id
    @GeneratedValue
    Long id;

    @Column(unique = true)
    private String name;

    private String displayName;

    private String title;

    /**
     * Used to sort the appUsers in the UI
     */
    private String employeeNumber;

    private String email;

    private String department;

    private String employeeType;

    private Boolean disabled= false;

    private @JsonIgnore
    String password;

    @Transient
    private String ip;


    @Column(unique = true)
    private String activeDirectoryUuid;

    public void setPassword(String password) {
        this.password= password;
    }


    public AppUser() {}


}

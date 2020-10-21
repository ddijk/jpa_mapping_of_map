package com.example.demo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class AppUserSettings {

    private @Id
    @GeneratedValue
    Long id;

    @OneToOne
    AppUser appUser;

    private String defaultFolder;

    /**
     * Type is het folder id
     * Value is de naam van persoon waarmee standaard ondertekend moet worden
     */

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appUserSettings", orphanRemoval = true)
    private List<AppUserSetting> settings;

    /**
     * Don't save in the database, used to display the hours after which files are processed
     */
    @Transient
    private String sendFileHours;

    /**
     * Type is de company
     * Value is de naam van de printer
     */
}

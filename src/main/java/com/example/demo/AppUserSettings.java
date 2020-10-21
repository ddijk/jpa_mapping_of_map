package com.example.demo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

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

    @ElementCollection
    @JoinTable(name="app_user_setting", joinColumns = @JoinColumn(name="settings_id"))
    @MapKeyColumn(name="key")
    @Column(name="value")
    private Map<String, String> settings;

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

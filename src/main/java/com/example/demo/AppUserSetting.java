package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AppUserSetting {

    @Id
    @GeneratedValue
    private int id;

    String key;
    String value;

    @ManyToOne
    @JoinColumn(name = "settings_id")
    @JsonIgnore
    AppUserSettings appUserSettings;

}

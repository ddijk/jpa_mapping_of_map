package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by avanderheijde on 09/08/16.
 */
public interface AppUserSettingsRepository extends CrudRepository<AppUserSettings, Long> {

    AppUserSettings findByAppUserId(Long id);

}

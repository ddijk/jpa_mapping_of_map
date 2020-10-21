package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppUserSettingController {


    @Autowired
    AppUserSettingsRepository appUserSettingsRepository;

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("priem");
    }

    @GetMapping(path = "/users")
    public ResponseEntity<String> getUsers() {
        final AppUserSettings user = appUserSettingsRepository.findByAppUserId(60L);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }


        return ResponseEntity.ok("user is " + user);
    }

    @GetMapping(path = "settings/{userId}")
    public ResponseEntity<AppUserSettings> getSettings(@PathVariable(name = "userId") Long userId) {

        AppUserSettings appUserSettings = appUserSettingsRepository.findByAppUserId(userId);

        if (appUserSettings == null) {
            return ResponseEntity.notFound().build();
        }
        System.out.println(appUserSettings);
        return ResponseEntity.ok(appUserSettings);
    }

    @PostMapping(path = "setting/{userId}")
    public ResponseEntity<AppUserSettings> createSetting(@RequestParam String key, @RequestParam String value, @PathVariable(name = "userId") Long user) {

        AppUserSettings appUserSettings = appUserSettingsRepository.findByAppUserId(user);

        appUserSettings.getSettings().put(key, value);
        appUserSettings =  appUserSettingsRepository.save(appUserSettings);

        return ResponseEntity.ok(appUserSettings);
    }
}

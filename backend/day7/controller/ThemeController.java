package com.learn.springsecurity.controller;

import com.learn.springsecurity.model.ThemeEntity;
import com.learn.springsecurity.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/theme")
public class ThemeController {

    private final ThemeService themeService;

    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping("/")
    public List<ThemeEntity> getAllThemes() {
        return themeService.getAllThemes();
    }

    @GetMapping("/{id}")
    public Optional<ThemeEntity> getThemeById(@PathVariable long id) {
        return themeService.getThemeById(id);
    }

    @PostMapping("/")
    public ThemeEntity createTheme(@RequestBody @NonNull ThemeEntity theme) {
        return themeService.createTheme(theme);
    }

    @PutMapping("/{id}")
    public ThemeEntity updateTheme(@PathVariable long id, @RequestBody ThemeEntity updatedTheme) {
        return themeService.updateTheme(id, updatedTheme);
    }

    @DeleteMapping("/{id}")
    public String deleteTheme(@PathVariable long id) {
        return themeService.deleteTheme(id);
    }
}

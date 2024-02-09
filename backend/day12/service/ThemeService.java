package com.learn.springsecurity.service;

import com.learn.springsecurity.model.ThemeEntity;
import com.learn.springsecurity.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {
    private final ThemeRepository themeRepository;
    @Autowired
    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }
    public List<ThemeEntity> getAllThemes() {
        return themeRepository.findAll();
    }

    public Optional<ThemeEntity> getThemeById(Long id) {
        return themeRepository.findById(id);
    }

    public ThemeEntity createTheme(ThemeEntity theme) {
        return themeRepository.save(theme);
    }

    public ThemeEntity updateTheme(Long id, ThemeEntity theme) {
        if (themeRepository.existsById(id)) {
            theme.setId(id);
            return themeRepository.save(theme);
        } else {
            throw new IllegalArgumentException("Theme with id " + id + " does not exist.");
        }
    }

    public String deleteTheme(Long id) {
        Optional<ThemeEntity> themeOptional = themeRepository.findById(id);
        if (themeOptional.isPresent()) {
            themeRepository.deleteById(id);
            return "Theme with ID " + id + " deleted successfully";
        } else {
            return "Theme with ID " + id + " not found";
        }
    }
}
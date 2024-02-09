package com.learn.springsecurity.model;

@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "theme")
public class ThemeEntity {

    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String themeName;
    private String themeDetails;
    private int themePrice;
    private String imageUrl;

    // Constructors
    public ThemeEntity() {
    }

    public ThemeEntity(String themeName, String themeDetails, int themePrice, String imageUrl) {
        this.themeName = themeName;
        this.themeDetails = themeDetails;
        this.themePrice = themePrice;
        this.imageUrl = imageUrl;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getThemeDetails() {
        return themeDetails;
    }

    public void setThemeDetails(String themeDetails) {
        this.themeDetails = themeDetails;
    }

    public int getThemePrice() {
        return themePrice;
    }

    public void setThemePrice(int themePrice) {
        this.themePrice = themePrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
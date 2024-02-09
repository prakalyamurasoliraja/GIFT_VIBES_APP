package com.learn.springsecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gift") // Changed table name to "gift"
public class GiftEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String giftName;
    private String giftDetails;
    private int giftPrice;
    private String giftUrl;

    // Constructors
    public GiftEntity() {
    }

    public GiftEntity(String giftName, String giftDetails, int giftPrice, String giftUrl) {
        this.giftName = giftName;
        this.giftDetails = giftDetails;
        this.giftPrice = giftPrice;
        this.giftUrl = giftUrl;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public String getGiftDetails() {
        return giftDetails;
    }

    public void setGiftDetails(String giftDetails) {
        this.giftDetails = giftDetails;
    }

    public int getGiftPrice() {
        return giftPrice;
    }

    public void setGiftPrice(int giftPrice) {
        this.giftPrice = giftPrice;
    }

    public String getGiftUrl() {
        return giftUrl;
    }

    public void setGiftUrl(String giftUrl) {
        this.giftUrl = giftUrl;
    }
}

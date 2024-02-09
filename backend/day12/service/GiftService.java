package com.learn.springsecurity.service;

import com.learn.springsecurity.model.GiftEntity;
import com.learn.springsecurity.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiftService {
    private final GiftRepository giftRepository;

    @Autowired
    public GiftService(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    public List<GiftEntity> getAllGifts() {
        return giftRepository.findAll();
    }

    public Optional<GiftEntity> getGiftById(Long id) {
        return giftRepository.findById(id);
    }

    public GiftEntity createGift(GiftEntity gift) {
        return giftRepository.save(gift);
    }

    public GiftEntity updateGift(Long id, GiftEntity updatedGift) {
        if (giftRepository.existsById(id)) {
            updatedGift.setId(id);
            return giftRepository.save(updatedGift);
        } else {
            throw new IllegalArgumentException("Gift with id " + id + " does not exist.");
        }
    }

    public String deleteGift(Long id) {
        if (giftRepository.existsById(id)) {
            giftRepository.deleteById(id);
            return "Gift with ID " + id + " deleted successfully";
        } else {
            return "Gift with ID " + id + " not found";
        }
    }
}

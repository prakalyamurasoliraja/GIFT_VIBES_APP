package com.learn.springsecurity.controller;

import com.learn.springsecurity.model.GiftEntity;
import com.learn.springsecurity.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gift")
public class GiftController {

    private final GiftService giftService;

    @Autowired
    public GiftController(GiftService giftService) {
        this.giftService = giftService;
    }

    @GetMapping("/")
    public List<GiftEntity> getAllGifts() {
        return giftService.getAllGifts();
    }

    @GetMapping("/{id}")
    public Optional<GiftEntity> getGiftById(@PathVariable long id) {
        return giftService.getGiftById(id);
    }

    @PostMapping("/")
    public GiftEntity createGift(@RequestBody @NonNull GiftEntity gift) {
        return giftService.createGift(gift);
    }

    @PutMapping("/{id}")
    public GiftEntity updateGift(@PathVariable long id, @RequestBody GiftEntity updatedGift) {
        return giftService.updateGift(id, updatedGift);
    }

    @DeleteMapping("/{id}")
    public String deleteGift(@PathVariable long id) {
        return giftService.deleteGift(id);
    }
}

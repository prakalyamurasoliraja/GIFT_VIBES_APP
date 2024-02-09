package com.learn.springsecurity.repository;

import com.learn.springsecurity.model.GiftEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftRepository extends JpaRepository<GiftEntity, Long> {
}
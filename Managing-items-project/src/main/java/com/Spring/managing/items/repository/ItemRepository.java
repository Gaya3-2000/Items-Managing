package com.Spring.managing.items.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.managing.items.entity.Item;


public interface ItemRepository extends JpaRepository<Item, Long> {

}

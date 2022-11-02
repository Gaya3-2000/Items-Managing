package com.Spring.managing.items.service;

import java.util.List;

import com.Spring.managing.items.entity.Item;

public interface ItemService {
	
	List<Item> getAllItems();
    public Item saveItem(Item item);
    
    Item getItemById(Long id);
    Item updateItem(Item item);
    
    void deleteItemById(Long id);
}

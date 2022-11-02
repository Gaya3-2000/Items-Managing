package com.Spring.managing.items.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.managing.items.entity.Item;
import com.Spring.managing.items.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
    
	public ItemRepository getItemRepository() {
		return itemRepository;
	}
    public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	@Override
	public List<Item> getAllItems() {
		
		return itemRepository.findAll();
	}
	@Override
	public Item saveItem(Item item) {
		
		return itemRepository.save(item);
	}
	@Override
	public Item getItemById(Long id) {
		
		return itemRepository.findById(id).get();
	}
	@Override
	public Item updateItem(Item item) {
		// TODO Auto-generated method stub
		return itemRepository.save(item);
	}
	@Override
	public void deleteItemById(Long id) {
		
		 itemRepository.deleteById(id);
		
	}
    

}

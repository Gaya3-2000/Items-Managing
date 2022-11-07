package com.Spring.managing.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.Spring.managing.items.entity.Item;
import com.Spring.managing.items.service.ItemService;

@Controller
public class ItemController {
    @Autowired
	private ItemService itemService;

	public ItemController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}
	
	//handler method to handle list items and return model and view
	@GetMapping("/items")
	public String listItems(Model model) {
		model.addAttribute("TotalItems", itemService.getAllItems());
		return "itemsView";
		
	}
	@GetMapping("/items/new")
	public String createItemPage(Model model) {
		
		//create item object to hold item page data
		Item item=new Item();
		model.addAttribute("item", item);
		return "Create_Item";

	}
	@PostMapping("/items")
	public String saveItem(@ModelAttribute("item") Item item) {
		itemService.saveItem(item);
		return "redirect:/items";
	}
	@GetMapping("/items/edit/{id}")
	public String editItemPage(@PathVariable Long id,Model model) {
		model.addAttribute("item", itemService.getItemById(id));
		return "edit_Item";
	}
	
	//handler method to handle edit_student template
	
	@PostMapping("/items/{id}")
	public String updateItem(@PathVariable Long id,
			@ModelAttribute("item") Item item,
	        Model model){
	      
		//get Item from database by id
		Item existingItem=itemService.getItemById(id);
		//existingItem.setId(id);
		existingItem.setName(item.getName());
		existingItem.setPrice(item.getPrice());
		existingItem.setQuantity(item.getQuantity());
	      
		//save updated item object
		itemService.updateItem(existingItem);
		return "redirect:/items";  	
	 }
	
	//handler method to handle delete item request
	@GetMapping("/items/{id}")
	public String deleteItem(@PathVariable Long id) {
		itemService.deleteItemById(id);
		return "redirect:/items";
	}
	
	/*@GetMapping("/items/adress")
	public String placeOrder() {
		return "place_order";
	}*/

	
	@GetMapping("/items/final")
	public String confirmOrder() {
		return "confirm_order";
	}

	
}

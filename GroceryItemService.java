package org.example;
import org.example.ResourceNotFoundException;

import org.example.GroceryItem;
import org.example.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemService {
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public List<GroceryItem> getAllItems() {
        return groceryItemRepository.findAll();
    }

    public GroceryItem addGroceryItem(GroceryItem item) {
        return groceryItemRepository.save(item);
    }

    public Optional<GroceryItem> getItemById(Long id) {
        return groceryItemRepository.findById(id);
    }

    public GroceryItem updateItem(Long id, GroceryItem itemDetails) {
        GroceryItem item = groceryItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));



        return groceryItemRepository.save(item);
    }

    public void deleteItem(Long id) {
        groceryItemRepository.deleteById(id);
    }
}

package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private GroceryItemService groceryItemService;

    @PostMapping("/items")
    public GroceryItem addGroceryItem(@RequestBody GroceryItem item) {
        return groceryItemService.addGroceryItem(item);
    }

    @PutMapping("/items/{id}")
    public GroceryItem updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem itemDetails) {
        return groceryItemService.updateItem(id, itemDetails);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<?> deleteGroceryItem(@PathVariable Long id) {
        groceryItemService.deleteItem(id);
        return ResponseEntity.ok().build();
    }
}

import org.example.GroceryItem;
import org.example.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private GroceryItemService groceryItemService;

    @GetMapping("/items")
    public List<GroceryItem> viewAllItems() {
        return groceryItemService.getAllItems();
    }

    @PostMapping("/order")
    public ResponseEntity<String> bookItems(@RequestBody List<Long> itemIds) {
        // Implementation for booking items in a single order
        return ResponseEntity.ok("Order placed successfully");
    }
}

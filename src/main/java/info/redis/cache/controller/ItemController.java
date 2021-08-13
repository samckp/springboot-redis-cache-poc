package info.redis.cache.controller;

import info.redis.cache.dao.Item;
import info.redis.cache.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService ;

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Integer id) {
        return itemService.getItem(id);
    }

    @PostMapping("/")
    public Item createItem(@RequestBody Item item){

        return itemService.createItem(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Integer id, @RequestBody Item item){

        return itemService.updateItem(id, item);
    }
}

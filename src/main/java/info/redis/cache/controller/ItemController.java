package info.redis.cache.controller;

import info.redis.cache.dao.Item;
import info.redis.cache.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService ;

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItem() {

        return new ResponseEntity<>(itemService.items(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getItem(@PathVariable Integer id) {

        return new ResponseEntity(itemService.getItem(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createItem(@RequestBody Item item){

        return new ResponseEntity<>(itemService.createItem(item), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateItem(@PathVariable Integer id, @RequestBody Item item){

        return new ResponseEntity<>(itemService.updateItem(id, item), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Integer id){

         //return new ResponseEntity<>(itemService.deleteItem(id), HttpStatus.OK);

          itemService.deleteItem(id);
    }
}

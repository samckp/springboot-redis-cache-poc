package info.redis.cache.controller;

import info.redis.cache.dao.Item;
import info.redis.cache.service.ItemService;
import io.github.jhipster.web.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final Logger log = LoggerFactory.getLogger(ItemController.class);
    private static final String ENTITY_NAME = "Item";

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private ItemService itemService ;

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItem() {

        log.info("REST request to get all Items");
        return new ResponseEntity<>(itemService.items(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getItem(@PathVariable Integer id) {

        log.info("REST request to get Item : {}", id);
        return new ResponseEntity(itemService.getItem(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createItem(@RequestBody Item item){

        log.info("REST request to save Item : {}", item);
        return new ResponseEntity<>(itemService.createItem(item), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateItem(@PathVariable Integer id, @RequestBody Item item){

        log.info("REST request to update Item : {}", item);
        return new ResponseEntity<>(itemService.updateItem(id, item), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deleteItem(@PathVariable Integer id){

        log.info("REST request to delete Item : {}", id);
        itemService.deleteItem(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName,
                false, ENTITY_NAME, id.toString())).build();
    }
}

package info.redis.cache.service;

import info.redis.cache.dao.Item;
import info.redis.cache.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.util.List;

@Service
public class ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemService.class);

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> items() {
        return itemRepository.findAll();
    }

    @Cacheable(value = "items", key = "#id")
    public Item getItem(Integer id) {
        Item item = itemRepository.findById(id).orElseThrow(RuntimeException::new);
        logger.info("Loading data from DB {}", item);
        return item;
    }

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @CacheEvict(value = "items", key = "#id")
    public Item updateItem(Integer id, Item request) {
        Item item = getItem(id);
        item.setPrice(request.getPrice());
        item.setProductName(request.getProductName());
        return itemRepository.save(item);
    }

    public void deleteItem(Integer id) {

        itemRepository.deleteById(id);
    }
}

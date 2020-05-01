package com.onlinetutorialspoint.cache;

import com.onlinetutorialspoint.model.Item;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class ItemCache {

	static Map<Integer, Item> data = new HashMap<Integer, Item>();

    @Cacheable(value="itemCache", key="#id")
    public Item getItem(int id){
    	Item item = data.get(id);
        System.out.println("Returning ItemCache .." + item);
        return item;
    }
    
    @CachePut(value="itemCache")
    public void addItem(Item item){
        System.out.println("Adding ItemCache .." + item);
        data.put(item.getId(), item);
    }

    @CacheEvict(value="itemCache",key = "#id")
    public int deleteItem(int id){
    	Item item = data.get(id);

        System.out.println("Deleting ItemCache .." + item);
        data.remove(id);
        return id;
    }
}

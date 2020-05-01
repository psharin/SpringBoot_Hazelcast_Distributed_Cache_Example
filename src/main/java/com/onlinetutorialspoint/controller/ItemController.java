package com.onlinetutorialspoint.controller;

import com.onlinetutorialspoint.cache.ItemCache;
import com.onlinetutorialspoint.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    @Autowired
    ItemCache itemCache;
    
 
    @GetMapping("/item/{itemId}")
    @ResponseBody
    public ResponseEntity<Item> getItem(@PathVariable int itemId){
        System.out.println("RestController.. getItem for item " + itemId);
        long start = System.currentTimeMillis();
        Item item = itemCache.getItem(itemId);
        long end = System.currentTimeMillis();
        System.out.println("Took : " + ((end - start) / 1000+" sec."));
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @GetMapping("/addItem")
    @ResponseBody
    public ResponseEntity<Item> addItem(){
    	int i = getRandomNumber();
    	Item item = new Item();
        item.setCategory("category"+i);
        item.setId(i);
        item.setName("Sreehari"+i);
        if(item != null){
            itemCache.addItem(item);
        }
        System.out.println("RestController.. addItem for item " + item);

        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }
    
    @GetMapping("/delete/{itemId}")
    @ResponseBody
    public ResponseEntity<String> deleteItem(@PathVariable int itemId){
        itemCache.deleteItem(itemId);
        System.out.println("RestController.. deleteItem for item " + itemId);

        return new ResponseEntity<String>("Deleted item "+ itemId, HttpStatus.OK);
    }
    
    private int getRandomNumber() {
    	int max = 100;
    	int min = 1;
    	int x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }
}

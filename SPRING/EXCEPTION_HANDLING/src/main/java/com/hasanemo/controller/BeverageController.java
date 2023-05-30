package com.hasanemo.controller;

import com.hasanemo.exception.SpriteNotFoundException;
import com.hasanemo.model.Sprite;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beverage")
// any request starting with 'beverage' will be forwarded here
public class BeverageController {
    @GetMapping("/sprite/{size}")
    public ResponseEntity<Object> beveragePriceDetails(@PathVariable String size) {
        if (size.equals("250") || size.equals("500") || size.equals("1000")) {
            Sprite sprite = new Sprite();
            return new ResponseEntity<>(sprite.getPrice(Integer.parseInt(size)), HttpStatus.OK);
        } else {
            throw new SpriteNotFoundException("Not in stock, try some other beverage variant.");
        }
    }
}

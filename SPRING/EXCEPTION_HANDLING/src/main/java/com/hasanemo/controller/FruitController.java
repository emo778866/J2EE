package com.hasanemo.controller;

import com.hasanemo.exception.MangoNotFoundException;
import com.hasanemo.model.Mango;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fruit")
// any request starting with 'admin' will be forwarded here
public class FruitController {
    @GetMapping("/mango/{f_id}")
    public ResponseEntity<Object> fruitDetails(@PathVariable String f_id) {
        if (f_id.equalsIgnoreCase("Miyazaki")) {
            Mango mango = new Mango();
            return new ResponseEntity<>(mango, HttpStatus.OK);
        } else {
            throw new MangoNotFoundException("Not in stock, try some other fruit.");
        }
    }
}

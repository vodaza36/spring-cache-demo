package com.hochbichler.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {
    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> testCache() {
        String currentDate = cacheService.cacheDate();
        System.out.println("Hello: " + currentDate);

        return ResponseEntity.ok(currentDate);
    }

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public ResponseEntity<Void> resetCache() {
        String currentDate = cacheService.resetCache();
        System.out.println("Hello: " + currentDate);

        return ResponseEntity.ok().build();
    }
}

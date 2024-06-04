package com.zahid.spring_data_starer_redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CacheController {

    private static final Logger logger = LoggerFactory.getLogger(CacheController.class);

    private final ExpensiveService expensiveService;

    public CacheController(ExpensiveService expensiveService) {
        this.expensiveService = expensiveService;
    }

    @GetMapping("/compute/{input}")
    public ResponseEntity<String> compute(@PathVariable int input) {
        long startTime = System.currentTimeMillis();
        int result = expensiveService.expensiveComputation(input);
        long duration = System.currentTimeMillis() - startTime;
        logger.info("Computation for input {} took {} ms", input, duration);
        return ResponseEntity.ok("Result: " + result + ", Time taken: " + duration + " ms");
    }

    @PutMapping("/update/{input}")
    public ResponseEntity<String> update(@PathVariable int input) {
        long startTime = System.currentTimeMillis();
        int result = expensiveService.updateComputation(input);
        long duration = System.currentTimeMillis() - startTime;
        logger.info("Update computation for input {} took {} ms", input, duration);
        return ResponseEntity.ok("Result: " + result + ", Time taken: " + duration + " ms");
    }

    @DeleteMapping("/clear")
    public ResponseEntity<String> clearCache() {
        long startTime = System.currentTimeMillis();
        expensiveService.clearCache();
        long duration = System.currentTimeMillis() - startTime;
        logger.info("Cache cleared! Time taken: {} ms", duration);
        return ResponseEntity.ok("Cache cleared! Time taken: " + duration + " ms");
    }
}

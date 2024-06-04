package com.zahid.spring_data_starer_redis;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ExpensiveService {

    private static final int COMPUTATION_DELAY_MS = 1000;

    /**
     * Simulate a computationally expensive method for creating and caching.
     * The result is cached to avoid repeated computations.
     *
     * @param input the input value
     * @return the square of the input value
     */
    @Cacheable(cacheNames = "expensiveComputations", key = "#input")
    public int expensiveComputation(int input) {
        simulateLongComputation();
        return computeSquare(input);
    }

    /**
     * Simulate a different computationally expensive method for updating the cache.
     *
     * @param input the input value
     * @return the cube of the input value
     */
    @CachePut(cacheNames = "expensiveComputations", key = "#input")
    public int updateComputation(int input) {
        simulateLongComputation();
        return computeCube(input);
    }

    /**
     * Clear all entries in the "expensiveComputations" cache.
     */
    @CacheEvict(cacheNames = "expensiveComputations", allEntries = true)
    public void clearCache() {
        // This method will clear the entire "expensiveComputations" cache
    }

    /**
     * Helper method to simulate a long computation.
     */
    private void simulateLongComputation() {
        try {
            Thread.sleep(COMPUTATION_DELAY_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Helper method to compute the square of a number.
     *
     * @param input the input value
     * @return the square of the input value
     */
    private int computeSquare(int input) {
        return input * input;
    }

    /**
     * Helper method to compute the cube of a number.
     *
     * @param input the input value
     * @return the cube of the input value
     */
    private int computeCube(int input) {
        return input * input * input;
    }
}

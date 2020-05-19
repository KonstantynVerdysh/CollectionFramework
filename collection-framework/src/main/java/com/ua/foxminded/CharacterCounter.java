package com.ua.foxminded;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version 1.0 23 May 2020
 * @author Konstantyn Verdysh
 */
class CharacterCounter {
    private Map<String, String> cache = new HashMap<>();
    private static final int COUNTER = 1;
    private static final String SEPARATOR = System.lineSeparator();
    /**
     * Method count all unique characters and cache 
     * the results.
     * 
     * @param string line
     * @return string contains counted unique characters
     */
    public String computeStatistics(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input to count should be not null");
        }
        if (cache.containsKey(input)) {
            return cache.get(input);
        }
        Map<Character, Integer> countedChars = new LinkedHashMap<>();
        for (char symbol : input.toCharArray()) {
            countedChars.merge(symbol, COUNTER, Integer::sum);
        }
        String result = buildStatsView(countedChars);
        cache.put(input, result);
        return result;
    }
    /**
     * Method buildString create string from map
     * 
     * @param map of counted characters
     * @return string
     */
    private String buildStatsView(Map<Character, Integer> countedChars) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : countedChars.entrySet()) {
            result.append(String.format("\"%s\" - %s%s", entry.getKey(), entry.getValue(), SEPARATOR));
        }
        return result.toString();
    }
}

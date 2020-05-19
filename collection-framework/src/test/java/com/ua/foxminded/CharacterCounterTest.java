package com.ua.foxminded;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CharacterCounterTest {
    private CharacterCounter counter = new CharacterCounter();
    private final String separator = System.lineSeparator();
    /**
     * Test method for {@link com.ua.foxminded.CharacterCounter#computeStatistics(java.lang.String)}.
     */
    @Test
    public void computeStatistics_returnSameStringWhenInputIsSame() {
        String expected = counter.computeStatistics("hello world!");
        String actual = counter.computeStatistics("hello world!");
        assertSame(expected, actual);
    }
    /**
     * Test method for {@link com.ua.foxminded.CharacterCounter#computeStatistics(java.lang.String)}.
     */
    @Test
    public void computeStatistics_returnStringWithCountedUniqueCharactersWhenInputIsString() {
        String expected = "\"h\" - 1" + separator +
                          "\"e\" - 1" + separator +
                          "\"l\" - 3" + separator + 
                          "\"o\" - 2" + separator + 
                          "\" \" - 1" + separator + 
                          "\"w\" - 1" + separator + 
                          "\"r\" - 1" + separator + 
                          "\"d\" - 1" + separator + 
                          "\"!\" - 1" + separator;
        String actual = counter.computeStatistics("hello world!");
        assertEquals(expected, actual);
    }
    /**
     * Test method for {@link com.ua.foxminded.CharacterCounter#computeStatistics(java.lang.String)}.
     */
    @Test
    public void computeStatistics_returnStringWithCountedUdniqueCharactersWhenInputIsSymbols() {
        String expected = "\"1\" - 4" + separator +
                          "\" \" - 3" + separator +
                          "\"!\" - 2" + separator +
                          "\"@\" - 2" + separator +
                          "\"#\" - 2" + separator +
                          "\"a\" - 1" + separator +
                          "\"b\" - 1" + separator +
                          "\"c\" - 1" + separator +
                          "\"A\" - 1" + separator +
                          "\"B\" - 1" + separator +
                          "\"C\" - 1" + separator;
        String actual = counter.computeStatistics("1111 !@#!@# abcABC ");
        assertEquals(expected, actual);
    }
    /**
     * Test method for {@link com.ua.foxminded.CharacterCounter#computeStatistics(java.lang.String)}.
     */
    @Test
    public void computeStatistics_throwExceptionWhenInputIsNull() {
        RuntimeException exception = assertThrows(RuntimeException.class, 
                () -> counter.computeStatistics(null));
        assertTrue(exception.getMessage().contains("Input to count should be not null"));
    }
}

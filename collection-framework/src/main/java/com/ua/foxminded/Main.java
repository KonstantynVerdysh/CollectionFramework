package com.ua.foxminded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        CharacterCounter counter = new CharacterCounter();
        System.out.println("Enter string line to count the number of unique characters:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String input = reader.readLine();
                System.out.println(counter.computeStatistics(input));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("System error");
        }
    }
}

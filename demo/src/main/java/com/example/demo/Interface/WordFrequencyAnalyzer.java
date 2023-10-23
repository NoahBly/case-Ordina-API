package com.example.demo.Interface;

import java.util.Map;

public interface WordFrequencyAnalyzer {

    int calculateHighestFrequency(String text);
    int calculateFrequencyForWord (String text, String word);
    Map<String, Integer> calculateMostFrequentNWords (String text, int n);



}

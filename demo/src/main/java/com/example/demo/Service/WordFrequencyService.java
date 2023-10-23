package com.example.demo.Service;

import com.example.demo.Model.WordFrequencyModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class WordFrequencyService {



    public int calculateHighestFrequency(String text) {

        WordFrequencyModel test = new WordFrequencyModel();
        int max = test.calculateHighestFrequency(text);

        return max;

    }

    public int calculateFrequencyForWord(String text, String word) {

        WordFrequencyModel test = new WordFrequencyModel();
        int count = test.calculateFrequencyForWord(text, word);

        return count;

    }

    public Map<String, Integer> calculateMostFrequentNWords(String text, int num) {

        WordFrequencyModel test = new WordFrequencyModel();
        Map<String, Integer> map = test.calculateMostFrequentNWords(text, num);

        return map;

    }



}

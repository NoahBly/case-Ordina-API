package com.example.demo.Model;

import com.example.demo.Interface.WordFrequency;
import com.example.demo.Interface.WordFrequencyAnalyzer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Entity
public class WordFrequencyModel implements WordFrequency, WordFrequencyAnalyzer {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String word;

    private int frequency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String getWord() {
        return null;
    }

    @Override
    public int getFrequency() {
        return 0;
    }

    @Override
    public int calculateHighestFrequency(String text) {
        int max = 0;
        int count = 0;
        String word = "";
        Map<String, Integer> map1 = new TreeMap<>();

        String arr[] = text.split(" ");

        for (int i = 0; i < arr.length; i++) {

            if (map1.containsKey(arr[i])) {
                map1.put(arr[i], map1.get(arr[i]) + 1);
                count = map1.get(arr[i]);
            } else {
                map1.put(arr[i], 1);
                count = 1;
            }
            if (max < count) {
                max = count;
                word = arr[i];
            }
        }
        System.out.println(word + " " + max);
        return max;
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        String[] StringArray = text.split(" ");

        int count = 0;
        for(int i=0; i < StringArray.length; i++) {
            if(StringArray[i].equals(word)){
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    @Override
    public Map<String, Integer> calculateMostFrequentNWords(String text, int n) {

        String word = "";
        int count = 0;
        Map<String,Integer> map1=new TreeMap<>();

        String arr[]=text.split(" ");

        for(int i=0;i<arr.length;i++)
        {

            if(map1.containsKey(arr[i]))
            {
                map1.put(arr[i], map1.get(arr[i])+1);
            }
            else
            {
                map1.put(arr[i],1);
            }
        }

        Map<String, Integer> Map2 = new HashMap<String, Integer>();

        LinkedHashMap<String, Integer> numbers1 = map1.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

//        System.out.println(numbers1.toString());

        int value2 = 0;
        Loop:for (Map.Entry<String, Integer> entry : numbers1.entrySet()) {
            int value = entry.getValue();
            Map2.put(entry.getKey(), entry.getValue());
            value2 = value2 + entry.getValue();
            if (n == value) {
//                System.out.println(Map2.toString());
                break Loop;
            } else {
                if (n == value2) {
//                    System.out.println(Map2.toString());
                    break Loop;
                }
            }
        }
        return Map2;
    }
}

package com.example.demo.Controller;


import com.example.demo.Service.WordFrequencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping ("/words")
public class WordfrequencyController {

    public WordFrequencyService service;


    public WordfrequencyController(WordFrequencyService service) {
        this.service = service;
    }

    @PostMapping(value = "/calculatehighestfreq/")
    public ResponseEntity<Object> calculateHighestFrequency(@RequestParam("text") String text) throws Exception{

        int max = service.calculateHighestFrequency(text);

        return new ResponseEntity<>(max, HttpStatus.CREATED);

    }

    @PostMapping(value = "/calculateFreqword/")
    public ResponseEntity<Object> calculateFrequencyForWord(@RequestParam("text") String text,@RequestParam("word") String word) throws Exception{

        int count = service.calculateFrequencyForWord(text,word);

        return new ResponseEntity<>(count, HttpStatus.CREATED);

    }

    @PostMapping(value = "/calculateMostFrequentNWords/")
    public ResponseEntity<Object> calculateMostFrequentNWords(@RequestParam("text") String text,@RequestParam("num") int num) throws Exception{

        Map<String, Integer> Map = service.calculateMostFrequentNWords(text, num);

        return new ResponseEntity<>(Map, HttpStatus.CREATED);

    }



}

package com.example.demo.sorting;

import org.springframework.stereotype.Service;

@Service
public class SorterFactory {
    public Sorter createSorter(String type) {
        switch (type) {
            case "bubble":
                return new BubbleSorter();
            case "heapsort":
                return new HeapSorter();
            case "merge":
                return new MergeSorter();
        }
        return null;
    }
}

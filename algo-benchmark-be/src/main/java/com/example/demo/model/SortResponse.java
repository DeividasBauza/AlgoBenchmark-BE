package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SortResponse {
    private List<Student> studentList;
    private double timeTaken;
    private int count;
    private String algo;

    public SortResponse(List<Student> studentList, double timeTaken, int count) {
        this.studentList = studentList;
        this.timeTaken = timeTaken;
        this.count = count;
    }
}

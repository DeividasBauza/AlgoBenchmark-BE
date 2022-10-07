package com.example.demo.sorting;

import com.example.demo.model.Student;

import java.util.List;

public interface Sorter {
    List<Student> sort(List<Student> list);

    default Student[] listToArray(List<Student> list, int length){
        Student[] array = new Student[length];
        return list.toArray(array);
    }
}

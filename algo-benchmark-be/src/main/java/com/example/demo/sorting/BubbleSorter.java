package com.example.demo.sorting;

import com.example.demo.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
public class BubbleSorter implements Sorter {

    @Override
    public List<Student> sort(List<Student> studentList) {
        int length = studentList.size();
        Student[] array = listToArray(studentList, length);
        for (int i = 0; i < length - 1; ++i) {

            for (int j = 0; j < length - i - 1; ++j) {
                double firstVal = array[j + 1].getScore();
                double secondVal = array[j].getScore();
                if (compare(firstVal, secondVal)) {
                    Student swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }
        return Arrays.asList(array);
    }

    private boolean compare(double firstVal, double secondVal) {
         return firstVal < secondVal;
    }
}

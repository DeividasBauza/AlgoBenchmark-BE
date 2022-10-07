package com.example.demo.sorting;

import com.example.demo.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
public class HeapSorter implements Sorter {

    @Override
    public List<Student> sort(List<Student> studentList) {
        int length = studentList.size();

        Student[] array = listToArray(studentList, length);
            for (int i = length / 2 - 1; i >= 0; i--)
                heapify(array, length, i);

            for (int i = length - 1; i > 0; i--) {
                Student temp = array[0];
                array[0] = array[i];
                array[i] = temp;

                heapify(array, i, 0);
            }

        return Arrays.asList(array);
    }


    private void heapify(Student[] arr, int N, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < N && arr[l].getScore() > arr[largest].getScore())
            largest = l;

        if (r < N && arr[r].getScore() > arr[largest].getScore())
            largest = r;

        if (largest != i) {
            Student swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, N, largest);
        }
    }
}

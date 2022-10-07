package com.example.demo.sorting;

import com.example.demo.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
public class MergeSorter implements Sorter{

    @Override
    public List<Student> sort(List<Student> list) {
        int length = list.size();
        Student[] array = listToArray(list, length);
        return Arrays.asList(mergeSort(array, 0, length-1));
    }
    Student[] mergeSort(Student[] array, int firstIndex, int lastIndex){

        if (firstIndex < lastIndex) {

            int mid = (firstIndex + lastIndex) / 2;

            mergeSort(array, firstIndex, mid);
            mergeSort(array, mid + 1, lastIndex);

            merge(array, firstIndex, mid, lastIndex);
        }
        return array;
    }
    void merge(Student[] array, int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        Student[] L = new Student[n1];
        Student[] M = new Student[n2];

        for (int i = 0; i < n1; i++)
            L[i] = array[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = array[q + 1 + j];

        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            if (L[i].getScore() <= M[j].getScore()) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = M[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = M[j];
            j++;
            k++;
        }
    }
}

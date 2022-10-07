package com.example.demo.sorting;

import com.example.demo.fileupload.BenchmarkService;
import com.example.demo.fileupload.DataParseService;
import com.example.demo.model.SortRequestParams;
import com.example.demo.model.SortResponse;
import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class SortingService {

    private final SorterFactory sorterFactory;
    private final BenchmarkService benchmarkService;
    private final DataParseService dataParseService;

    public SortingService(SorterFactory sorterFactory, BenchmarkService benchmarkService, DataParseService dataParseService) {
        this.sorterFactory = sorterFactory;
        this.benchmarkService = benchmarkService;
        this.dataParseService = dataParseService;
    }

    public SortResponse sortStudents(List<String> studentList, SortRequestParams requestParams) throws Exception {
        List<Student> students = dataParseService.studentsFromLines(studentList);
        Sorter sorter = sorterFactory.createSorter(requestParams.getAlgo());
        Function<List<Student>, List<Student>> sortFunction = sorter::sort;
        SortResponse response = benchmarkService.benchmarkSortingAction(students, sortFunction);
        response.setAlgo(requestParams.getAlgo());
        return response;
    }
}

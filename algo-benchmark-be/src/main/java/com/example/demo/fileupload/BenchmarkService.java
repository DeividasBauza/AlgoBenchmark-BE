package com.example.demo.fileupload;

import com.example.demo.model.SortResponse;
import com.example.demo.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@Slf4j
public class BenchmarkService {

    public SortResponse benchmarkSortingAction(List<Student> list, Function<List<Student>, List<Student>> function) {
        long startTime = System.nanoTime();
        List<Student> sortedStudents = function.apply(list);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        log.info("Sorting took {}ms", duration);
        return new SortResponse(sortedStudents, duration, sortedStudents.size());
    }
}

package com.example.demo.fileupload;

import com.example.demo.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class DataParseService {
    public List<Student> studentsFromLines(List<String> lines) {
        log.info("Starting to sort {} items", lines.size());
        return lines.stream().map(line -> {
            String[] parts = line.split(",");
            return new Student(parts[0], Double.parseDouble(parts[1]));
        }).collect(Collectors.toList());
    }
}

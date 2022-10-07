package com.example.demo.fileupload;

import com.example.demo.model.SortRequestParams;
import com.example.demo.model.SortResponse;
import com.example.demo.sorting.SortingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class FileUploadController {

    private final SortingService sortingService;

    public FileUploadController(SortingService sortingService) {
        this.sortingService = sortingService;
    }

    @PostMapping("/sort")
    public SortResponse sortStudentsByScore(@RequestBody List<String> lines, SortRequestParams requestParams) throws Exception {
        return sortingService.sortStudents(lines, requestParams);
    }
}

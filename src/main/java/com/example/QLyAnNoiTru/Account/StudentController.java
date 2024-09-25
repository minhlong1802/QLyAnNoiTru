package com.example.QLyAnNoiTru.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentRepository studentRepository;
    private final JdbcTemplateService jdbcTemplateService;

    @Autowired
    public StudentController(StudentRepository studentRepository,JdbcTemplateService jdbcTemplateService) {
        this.studentRepository = studentRepository;
        this.jdbcTemplateService = jdbcTemplateService;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Student student) {
        studentRepository.update(student);
        return ResponseEntity.noContent().build();
    }

}

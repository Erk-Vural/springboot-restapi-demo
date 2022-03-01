package com.example.springbootutorial.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PutMapping("update/{id}")
    public void update(
            @PathVariable("id") int id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.update(id, name, email);
    }

    @PostMapping("create")
    public void create(@RequestBody Student student) {
        studentService.create(student);
    }

    @GetMapping("getAll")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("get/{id}")
    public Optional<Student> get(@PathVariable("id") int id) {
        return studentService.get(id);
    }


    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") int id) {
        studentService.delete(id);
    }


}

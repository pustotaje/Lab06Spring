package ru.arkhipov.MySpringBoot2Dbase.controller;

import jakarta.transaction.Transactional;
import ru.arkhipov.MySpringBoot2Dbase.entity.Discipline;
import ru.arkhipov.MySpringBoot2Dbase.entity.Student;
import ru.arkhipov.MySpringBoot2Dbase.service.DisciplineService;
import ru.arkhipov.MySpringBoot2Dbase.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@Transactional
@RequestMapping

public class Controller {
    @Autowired
    private StudentService studentService;
    @Autowired
    private DisciplineService disciplineService;
    @GetMapping("/students")
    public ApiResponse<List<Student>>allStudents() {
        try {
            return new ApiResponse<>(true, "Запрос успешно выполнен", studentService.getAllStudents());
        } catch (Exception e) {
            return new ApiResponse<>(false, "Ошибка при выполнении запроса", null);
        }
    }
    @GetMapping("/students/{id}")
    public ApiResponse<Student> getStudent(@PathVariable("id") int id) {
        try {
            return new ApiResponse<>(true, "Запрос успешно выполнен", studentService.getStudent(id));
        } catch (Exception e) {
            return new ApiResponse<>(false, "Ошибка при выполнении запроса", null);
        }
    }
    @PostMapping("/students")
    public ApiResponse<Student> saveStudent(@RequestBody Student student) {
        try {
            return new ApiResponse<>(true, "Объект успешно создан", studentService.saveStudent(student));
        } catch (Exception e) {
            return new ApiResponse<>(false, "Ошибка при выполнении запроса", null);
        }
    }
    @PutMapping("/students")
    public ApiResponse <Student> updateStudent(@RequestBody Student student) {
        try {
            return new ApiResponse<>(true, "Объект успешно обновлен", studentService.saveStudent(student));
        } catch (Exception e) {
            return new ApiResponse<>(false, "Ошибка при выполнении запроса", null);
        }
    }
    @DeleteMapping("/students/{id}")
    public ApiResponse<Integer> deleteStudent(@PathVariable("id") int id) {
        try {
            studentService.deleteStudent(id);
            return new ApiResponse<>(true, "Объект успешно удален", id);
        } catch (Exception e) {
            return new ApiResponse<>(false, "Ошибка при выполнении запроса", null);
        }
    }
    @GetMapping("/disciplines")
    public ApiResponse<List<Discipline>>allDisciplines() {
        try {
            return new ApiResponse<>(true, "Запрос успешно выполнен", disciplineService.getAllDisciplines());
        } catch (Exception e) {
            return new ApiResponse<>(false, "Ошибка при выполнении запроса", null);
        }
    }
    @PostMapping("/disciplines")
    public ApiResponse<Discipline> saveDiscipline(@RequestBody Discipline discipline) {
        try {

            return new ApiResponse<>(true, "Объект успешно создан", disciplineService.saveDiscipline(discipline));
        } catch (Exception e) {
            return new ApiResponse<>(false, "Ошибка при выполнении запроса", null);
        }
    }
}
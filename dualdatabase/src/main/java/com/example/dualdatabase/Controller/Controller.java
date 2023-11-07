package com.example.dualdatabase.Controller;

import com.example.dualdatabase.builder.ObjectBuilder;
import com.example.dualdatabase.entity1.Student;
import com.example.dualdatabase.entity1.StudentDTO;
import com.example.dualdatabase.entity2.Professor;
import com.example.dualdatabase.entity2.ProfessorDTO;
import com.example.dualdatabase.repo1.StudentRepository;
import com.example.dualdatabase.repo2.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    StudentRepository studentRepository;



    @Autowired
    ProfessorRepository professorRepository;

    @PostMapping("/Student")
    public Student saveStudent(@RequestBody StudentDTO studentDTO) {
        Student student = ObjectBuilder.createStudentFromStudentDTO(studentDTO);
        return studentRepository.save(student);
    }

    @PostMapping("/Professor")
    public Professor saveProfessor(@RequestBody ProfessorDTO professorDTO) {
        Professor professor = ObjectBuilder.createProfessorFromProfessorDTO(professorDTO);
        return professorRepository.save(professor);
    }

    @GetMapping("/allStudents")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/allProfessors")
    public List<Professor> getAllProfessors(){
        return professorRepository.findAll();
    }
}

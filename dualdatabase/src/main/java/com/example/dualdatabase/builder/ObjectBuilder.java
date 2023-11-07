package com.example.dualdatabase.builder;


import com.example.dualdatabase.entity1.Student;
import com.example.dualdatabase.entity1.StudentDTO;
import com.example.dualdatabase.entity2.Professor;
import com.example.dualdatabase.entity2.ProfessorDTO;

import java.util.Stack;

public class ObjectBuilder {


    public static Student createStudentFromStudentDTO(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setCollegeName(studentDTO.getCollegeName());
        student.setGroupName(studentDTO.getGroup());
        return student;
    }


    public static Professor createProfessorFromProfessorDTO(ProfessorDTO professorDTO) {

        Professor professor = new Professor();
        professor.setName(professorDTO.getName());
        professor.setSubject(professorDTO.getSubject());
        return professor;
    }

}


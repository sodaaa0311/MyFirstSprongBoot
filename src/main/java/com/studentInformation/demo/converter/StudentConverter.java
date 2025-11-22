package com.studentInformation.demo.converter;

import com.studentInformation.demo.dao.student;
import com.studentInformation.demo.dto.Studentdto;

public class StudentConverter {

    //将dto转为student
    public static student converter(Studentdto studentdto){
        student student=new student();
        student.setId(studentdto.getId());
        student.setName(studentdto.getName());
        student.setEmail(studentdto.getEmail());
        return student;
    }

    //将student转为dto
    public static Studentdto converter(student student){
        Studentdto studentdto=new Studentdto();
        studentdto.setId(student.getId());
        studentdto.setName(student.getName());
        studentdto.setEmail(student.getEmail());
        return studentdto;
    }

}

package com.studentInformation.demo.sercive;

import com.studentInformation.demo.dao.StudentRepository;
import com.studentInformation.demo.dao.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    //注入StudentRepository
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public student getStudentById(long id) {

        return studentRepository.findById(id).orElseThrow(RuntimeException::new);


    }
}

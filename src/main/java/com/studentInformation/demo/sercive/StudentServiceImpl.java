package com.studentInformation.demo.sercive;

import com.studentInformation.demo.converter.StudentConverter;
import com.studentInformation.demo.dao.StudentRepository;
import com.studentInformation.demo.dao.student;
import com.studentInformation.demo.dto.Studentdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    //注入StudentRepository
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public student getStudentById(long id) {

        return studentRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    @Override
    public  long addNewStudent(Studentdto studentdto){
        //首先检查email唯一性
        List<student> byEmail = studentRepository.findByEmail(studentdto.getEmail());
        if(!CollectionUtils.isEmpty(byEmail))
            throw new IllegalStateException("email"+studentdto.getEmail()+"has been taken");
        student save = studentRepository.save(StudentConverter.converter(studentdto));
        return save.getId();

    }
    public void deleteById(long id){
        //先判断存不存在，若不存在则不需要删除
        student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("id " + id + " doesn't exist"));
        studentRepository.deleteById(id);
    }

    public Studentdto updateById(long id, String name, String email){
        student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("id " + id + " doesn't exist"));
        student.setId(id);
        student.setName(name);
        student.setEmail(email);
        return StudentConverter.converter(student);
    }

}

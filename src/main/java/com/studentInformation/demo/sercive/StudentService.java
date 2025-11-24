package com.studentInformation.demo.sercive;

import com.studentInformation.demo.dao.student;
import com.studentInformation.demo.dto.Studentdto;

public interface StudentService {

    public student getStudentById(long id);

    public long addNewStudent(Studentdto studentdto);

    void deleteById(long id);

    Studentdto updateById(long id, String name, String email);
}

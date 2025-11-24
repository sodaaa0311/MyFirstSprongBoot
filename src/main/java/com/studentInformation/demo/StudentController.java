package com.studentInformation.demo;

import com.studentInformation.demo.converter.StudentConverter;
import com.studentInformation.demo.dao.student;
import com.studentInformation.demo.dto.Studentdto;
import com.studentInformation.demo.sercive.StudentService;
import com.studentInformation.demo.sercive.StudentServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    //注入service
    @Autowired
   private StudentService studentService;
    @GetMapping("/hello")
    public String hello(){
        return "hello,world";
    }
    @GetMapping("/student/{id}")
//   public student getStudentById(@PathVariable long id){
//
//       return studentService.getStudentById(id);
//   }
        //此时应该返回dto类型
//       public Studentdto getStudentById(@PathVariable long id){
//
//        student student = studentService.getStudentById(id);
//        return StudentConverter.converter(student);
//    }
        //此时我们返回response
    public response<Studentdto> getStudentById(@PathVariable long id){

        student student = studentService.getStudentById(id);
        return response.newSuccess(StudentConverter.converter(student));
    }

    @PostMapping("/student")
    public response<Long> add(@RequestBody Studentdto studentdto){
        return response.newSuccess(studentService.addNewStudent(studentdto));
    }

    @DeleteMapping("/student/{id}")
    public void deleteById(@PathVariable long id){
        studentService.deleteById(id);
    }

    @PutMapping("student/{id}")
    @Transactional
    public response<Studentdto> updateById(
            @PathVariable long id,
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String email
    ){
        return response.newSuccess(studentService.updateById(id,name,email));
    }

}



























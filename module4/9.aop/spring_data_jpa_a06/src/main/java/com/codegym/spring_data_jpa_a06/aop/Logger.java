package com.codegym.spring_data_jpa_a06.aop;


import com.codegym.spring_data_jpa_a06.dto.StudentDto;
import com.codegym.spring_data_jpa_a06.model.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Aspect
public class Logger {
    private static int count =0;
    private static int count1 =0;
    // tạo một pointCut có tham số
    @Pointcut("execution(* com.codegym.spring_data_jpa_a06.controller.StudentController.showList2(..))")
    public void getShowList(){
    }

    @After(value = "getShowList()")
    public void writeHistoryShowList2(){
        count++;
        System.out.println("Truy cập lần thứ : "+ count );
    }
    @Pointcut("execution(* com.codegym.spring_data_jpa_a06.controller.StudentController.save(..))&&args(studentDto,*,*,*)")
    public void createThrowing(StudentDto studentDto){
    }

    @AfterThrowing(value = "createThrowing(studentDto)", argNames = "studentDto")
    public void writeExceptionOfSave(StudentDto studentDto){
        count1++;
        System.out.println("Số lần bị exception "+ count1);
        System.out.println("nguyên nhân là thêm tên : "+ studentDto.getName());
    }

    // demo bị lỗi nhưng đã fix lại và chạy thành công
    @Around(value = "getShowList()")
    public Object writeBeforeAndAfterList(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        // công việc thực hiện trước khi chạy list
            Object object =proceedingJoinPoint.proceed();
          // công việc thực hiên sau khi chạy list
        System.out.println("Sau khi chạy");
        return object;
    }
}

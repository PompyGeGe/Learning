package com.controller;

import com.controller.common.builder.ResponseBuilder;
import com.controller.dto.request.ReqDTO;
import com.controller.dto.request.RequestDTO;
import com.controller.dto.response.BaseResponseDTO;
import com.learning.spring.beanRegister.TestBeanFactory;
import com.learning.spring.beanRegister.TestPropertiesConfig;
import com.learning.spring.mybatis.functionTest.model.Student;
import com.learning.spring.mybatis.functionTest.service.StudentInfoService;
import com.learning.stateMachine.service.TestExecuteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class TestController {

    @Resource
    private TestExecuteService testExecuteService;

    @Autowired
    private TestPropertiesConfig testPropertiesConfig;

    @Autowired
    private TestBeanFactory testBeanFactory;


    @Autowired
    private StudentInfoService studentInfoService;


    @PostMapping("/stateMachine")
    public BaseResponseDTO<String> stateMachine(@RequestBody ReqDTO reqDTO){
        testExecuteService.execute(reqDTO);
        return ResponseBuilder.buildSuccess("success");
    }

    @GetMapping("/properties1")
    public String getProperties1(){
        String str = "a1=" + testPropertiesConfig.getA() + ";b1="
                + testPropertiesConfig.getB();
        log.info(str);
        return str;
    }

    @PostMapping("/getClass")
    public BaseResponseDTO<Object> getClass(@RequestBody RequestDTO reqDTO){
        Object o= testBeanFactory.getClass(reqDTO.getStr());
        return ResponseBuilder.buildSuccess(o);
    }

    @PostMapping("/getFirstStudent")
    public BaseResponseDTO<Student> getFirstStudent(){
        return ResponseBuilder.buildSuccess(studentInfoService.getFirstStudent());
    }

    @PostMapping("/getAllStudents")
    public BaseResponseDTO<List<Student>> getAllStudents(){
        return ResponseBuilder.buildSuccess(studentInfoService.getAllStudents());
    }
}

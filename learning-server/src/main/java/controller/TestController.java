package controller;

import controller.common.builder.ResponseBuilder;
import controller.dto.request.ReqDTO;
import controller.dto.request.RequestDTO;
import controller.dto.response.BaseResponseDTO;
import learning.spring.TestBeanFactory;
import learning.spring.TestPropertiesConfig;
import learning.stateMachine.service.TestExecuteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class TestController {

    @Resource
    private TestExecuteService testExecuteService;

    @Autowired
    private TestPropertiesConfig testPropertiesConfig;

    @Autowired
    private TestBeanFactory testBeanFactory;



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
}

package com.learning.spring.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.controller.dto.response.BaseResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author: 皮皮
 * @Date: 2024/8/5 18:59
 * @Description:
 */
@Aspect
@Component
@Slf4j
public class LoggingAspect {


    private static final Long MAX_TIME = 4000L;

    @Pointcut("execution(* com.learning.spring.beanRegister.TestBeanFactory.*(..))")
    //我只想给com.learning.spring.beanRegister包下的类做aop代理
    //AbstractAutoProxyCreator实现了postProcessAfterInitialization方法，里面的wrapIfNecessary方法会会生成aop代理。
    //目前来看，自定义切面(切面表达式里指定的路径的类)和用到了AOP的注解(如@Transactional)会在这里生成代理对象！
    public void exPointCut() {
    }

    @Around("exPointCut()")
    public Object around(ProceedingJoinPoint point) {
        long startTime = System.currentTimeMillis();
        Object[] pointArgs = point.getArgs();
        Signature sig = point.getSignature();
        String signature = sig.getName();

        Object proceed = null;
        try {
            proceed = point.proceed();
            try {
                log.info("[entrance_result] {}", JSONObject.toJSONString(proceed));

                BaseResponseDTO baseResponseDTO = JSON.parseObject(JSON.toJSONString(proceed), BaseResponseDTO.class);
                baseResponseDTO.setMessage("你好哇，嘻嘻嘻");
                return baseResponseDTO;

            } catch (Exception e) {
                log.error("FacadeWeaver.execute entrance_result.", e);
            }
            return proceed;
        } catch (Throwable t) {
            log.error("interface error, args: {}，throwable: {}, trace:{}", pointArgs, t, Arrays.stream(t.getStackTrace()).map(f -> "\tat " + f).collect(Collectors.joining("\n")));
            return proceed;
        } finally {
            long elapsedMills = System.currentTimeMillis() - startTime;
            log.info(signature + "接口执行消耗{}ms ", elapsedMills);
            if (elapsedMills > MAX_TIME) {
                log.error(signature + "接口执行消耗超过" + MAX_TIME / 1000 + "秒：" + elapsedMills + "ms");
            }
            //记录业务日志
        }
    }

}

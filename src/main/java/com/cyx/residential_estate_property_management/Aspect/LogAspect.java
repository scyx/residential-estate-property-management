package com.cyx.residential_estate_property_management.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author cyx
 * @data 2020/1/20 11:02
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(* com.cyx.residential_estate_property_management.Controller.*Controller.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        StringBuilder sb = new StringBuilder();
        Signature signature = joinPoint.getSignature();
        sb.append(signature.getName() + " ");
        MethodSignature methodSignature = (MethodSignature) signature;//获取参数名
        int i = 0;
        for (Object arg : joinPoint.getArgs()) {
            sb.append(methodSignature.getParameterNames()[i++] + ":");
            sb.append(arg.toString() + " ");
        }
        logger.info("before method: " + sb.toString());
    }

    @Before("execution(* com.cyx.residential_estate_property_management.Controller.*Controller.*(..))" +
    "&&!execution(* com.cyx.residential_estate_property_management.Controller.*LoginController.*(..))")
    public void checkLogin(JoinPoint joinPoint) throws Exception {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
//            throw new Exception("无Cookie");
        }
    }
}

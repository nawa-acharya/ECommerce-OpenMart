package com.openmart.core.utils.aspect;

import com.openmart.core.business.user.model.User;
import com.openmart.core.utils.Logging.Logger;
import com.openmart.core.utils.Logging.LoggerImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by Nawa on 7/13/2016.
 */
@Aspect
@Component
public class LoginAspect {
    @Autowired
    private Logger logger;

    public void serLogger(Logger logger){
        this.logger = logger;
    }

    @Before("execution(public * com.openmart.web.shop.controllers.user.UserController.*(..))")
    public void traceBeforeMethod(JoinPoint joinpoint) {
        logger.log("Inside user Controller..." + joinpoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(public * com.openmart.web.shop.controllers.user.UserController.updateProfile(..))", returning = "user")
    public void traceaftermethodNormal(JoinPoint joinpoint, User user) {
        logger.log(user.getUsername() + " profile is updated successfully... " );
    }

    @AfterThrowing(pointcut = "execution(public * com.openmart.web.shop.controllers.user.UserController.*(..))", throwing="exception")
    public void traceaftermethodException(JoinPoint joinpoint, Exception exception) {
       logger.log("Exception caught " + exception.getMessage());
    }

    @AfterReturning(pointcut = "execution(public * com.openmart.web.shop.controllers.user.UserController.registerUser(..))", returning = "user")
    public void traceAfterRegisterSucessful(JoinPoint joinPoint, User user){
        logger.log(user.getUsername() + " registered successfully...");
    }

    @AfterReturning(pointcut = "execution(public * com.openmart.web.shop.controllers.user.UserController.getUserFromUsername(..))", returning = "user")
    public void traceAfterLoginSuccessful(JoinPoint joinPoint, User user){
        logger.log(user.getUsername() + " logged in successfully...");
    }
}
